package org.fkit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.fkit.domain.Focus;
import org.fkit.domain.Gather;
import org.fkit.domain.Member;
import org.fkit.domain.Strategy;
import org.fkit.service.FocusService;
import org.fkit.service.GatherService;
import org.fkit.service.MemberService;
import org.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("gather")
public class GatherController {
	@Autowired
	@Qualifier("gatherService")
	private GatherService gatherService;
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@Autowired
	@Qualifier("focusService")
	private FocusService focusService;
	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;
	@RequestMapping(value="/addg")
	@ResponseBody
	public void Addgather(Integer user_id,String user_name,String title,String content,String city,String Ecity,String Sdate,
			String Edate,String sex,HttpSession session,String images,String connection,String con_status){
		String[] imgs=images.split("//");
		images="http://localhost:8090/MyWe/upload/"+imgs[1];
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdf.format(d);
		String travel_city=city+"-"+Ecity;
		String travel_date=Sdate+"至"+Edate;
		Integer focus=0;
		Integer joiner=0;
		gatherService.insertGather(title,user_id,user_name,date,content,travel_city,travel_date,sex,images,focus,joiner,connection,con_status);
		
		
	}
	
	@RequestMapping(value="/show")
	@ResponseBody
	public Object Showgather(){
		Map<String,Object> data=new HashMap<String,Object>();
		List<Gather> gatherlist=gatherService.show();
		List<Gather> gatherhot=gatherService.showHot();
		data.put("gatherlist", gatherlist);
		data.put("gatherhot", gatherhot);
		return data;
	
	}
	
	@RequestMapping(value="/details")
	@ResponseBody
	public Object Detailsgather(Integer id,Integer user_id,String user_name){
		Map<String,Object> data=new HashMap<String,Object>();
		Gather gather=gatherService.selectGather(id);
		data.put("gather", gather);
		Integer gather_id=id;
		Integer member_id=user_id;
		String text1;
		String text2;
		//查询是否关注
		Focus focus=focusService.selectByUser_idAndId(user_id, gather_id);
		if(focus!=null){
			text1="已关注";
		}else{
			text1="关注";
		}
		//查询是否报名
		String con;
		Member member=memberService.selectByG_idAndM_id(gather_id, member_id);
		if(member!=null){
			text2="已报名";
			con=gather.getConnection();
		}else{
			if(gather.getCon_status().equals("true")){
			text2="我要报名";
			con="报名后可见";
		}else{
			text2="我要报名";
			con=gather.getConnection();
			}
		}
		data.put("text1", text1);
		data.put("text2", text2);
		String sex;
		if(gather.getSex()==3){
			sex="不限";
		}else if(gather.getSex()==2){
			sex="女";
		}else{
			sex="男";
		}
		data.put("sex", sex);
		data.put("con", con);
		
		return data;
	
	}
	@RequestMapping(value="/focus")
	@ResponseBody
	public Object Focus(Integer gather_id,Integer user_id){
		Map<String,Object> data=new HashMap<String,Object>();
		Focus focus=focusService.selectByUser_idAndId(user_id, gather_id);
		String text1;
		if(focus==null){
			focusService.insertFocus(gather_id, user_id);
			Integer count=focusService.SelectCount(gather_id);
			gatherService.updateFocus(count, gather_id);
			text1="已关注";
		}else{
			focusService.deleteFocus(gather_id, user_id);
			Integer count=focusService.SelectCount(gather_id);
			gatherService.updateFocus(count, gather_id);
			text1="关注";
		}
		Integer id=gather_id;
		Gather gather=gatherService.selectGather(id);
		data.put("gather", gather);
		data.put("text1", text1);
		return data;
	}
	
	@RequestMapping(value="/join")
	@ResponseBody
	public Object Join(Integer gather_id,Integer user_id){
		Integer member_id=user_id;
		Map<String,Object> data=new HashMap<String,Object>();
		Member member=memberService.selectByG_idAndM_id(gather_id, member_id);
		Integer id=gather_id;
		Gather gather=gatherService.selectGather(id);
		String text2="";
		String con;
		if(member==null){
			memberService.insertMember(gather_id, member_id);
			Integer count=memberService.SelectCount(gather_id);
			gatherService.updateJoiner(count, gather_id);
			text2="已报名";
			con=gather.getConnection();
		}else{ 
			if(gather.getCon_status().equals("false")){
			memberService.deleteJoiner(gather_id, user_id);
			Integer count=memberService.SelectCount(gather_id);
			gatherService.updateJoiner(count, gather_id);
			text2="我要报名";
			con=gather.getConnection();
		}else{
			memberService.deleteJoiner(gather_id, user_id);
			Integer count=memberService.SelectCount(gather_id);
			gatherService.updateJoiner(count, gather_id);
			text2="我要报名";
			con="报名后可见";
		}
	}
		Gather gathers=gatherService.selectGather(id);
		data.put("gather", gathers);
		data.put("text2", text2);
		data.put("con", con);
		return data;
	}
	
	@RequestMapping(value="/Userpublic")
	@ResponseBody
	public Object FindUserGatherPublish(Integer user_id){
		List<Gather> gathers=gatherService.selectGatherList(user_id);
		return gathers;
	}
	
	@RequestMapping(value="/Userfocus")
	@ResponseBody
	public Object FindUserGatherFocus(Integer user_id){
		List<Gather> gatherList=focusService.selectGatherFocus(user_id);
		return gatherList;
	}
	@RequestMapping(value="/Userjoin")
	@ResponseBody
	public Object FindUserGatherJoin(Integer user_id){
		List<Gather> gatherMeun=memberService.selectGatherJoiner(user_id);
		System.out.println(gatherMeun);
		return gatherMeun;
	}
	
	@RequestMapping(value="/search")
	@ResponseBody
	public Object researchGather(String Keyword){
		Map<String,Object> data=new HashMap<String,Object>();
		Set<String> expectedNature = new HashSet<String>() {{
            add("ns");
            //add("v");add("vd");add("vn");add("vf");
            //add("vx");add("vi");add("vl");add("vg");
            //add("nt");add("nz");add("nw");add("nl");
            //add("ng");add("userDefine");add("wh");
        }};
        //String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        Result result = ToAnalysis.parse(Keyword); //分词结果的一个封装，主要是一个List<Term>的terms
        System.out.println(result.getTerms());

        List<Term> terms = result.getTerms(); //拿到terms
        System.out.println(terms.size());
        ArrayList<String> List=new ArrayList<String>();
        for(int i=0; i<terms.size(); i++) {
            String word = terms.get(i).getName(); //拿到词
            String natureStr = terms.get(i).getNatureStr(); //拿到词性
            if(expectedNature.contains(natureStr)) {
                System.out.println(word + ":" + natureStr);
                List.add(word); 
            }
        }
        System.out.println(List.size());
        if (List.size()==1){
        	List<Gather> Keygathers=gatherService.selectKeyword(List.get(0));
        	System.out.println(Keygathers);
        	data.put("Keygathers", Keygathers);
        }else if(List.size()==2){
        	String Key="+"+List.get(0)+"+"+List.get(1);
        	System.out.println(Key);
        	List<Gather> Keygathers=gatherService.SearchWithKey(Key);
        	System.out.println(Keygathers);
        	data.put("Keygathers", Keygathers);
        }else{
        	 ArrayList<Gather>Keygathers =new ArrayList<Gather>();
        	for(int i=0; i<List.size(); i++){
        		List<Gather> gather=gatherService.selectKeyword(List.get(i));
        		for(int j=0; j<gather.size(); j++){
        			Keygathers.add(gather.get(j));
        			System.out.println(Keygathers);
        			data.put("Keygathers", Keygathers);
        		}
        	}
        }
        return data;
	}
}
