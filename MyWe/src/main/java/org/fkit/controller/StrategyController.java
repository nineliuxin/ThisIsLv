package org.fkit.controller;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import java.util.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.fkit.domain.Collection;
import org.fkit.domain.Dianzan;
import org.fkit.domain.Strategy;
import org.fkit.domain.Strategy_photo;
import org.fkit.service.CollectionService;
import org.fkit.service.DianzanService;
import org.fkit.service.StrategyService;
import org.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("strategy")
public class StrategyController {
	@Autowired
	@Qualifier("strategyService")
	private StrategyService strategyService;
	@Autowired	
	@Qualifier("dianzanService")
	private DianzanService dianzanService;
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@Autowired
	@Qualifier("collectionService")
	private CollectionService collectionService;
		@RequestMapping(value="/show")
		@ResponseBody
		public Object Show(){
			Map<String,Object> data=new HashMap<String,Object>();
			List<Strategy> strategylist=strategyService.show();
			List<Strategy> strategyOther=strategyService.showOther();
			data.put("strategylist", strategylist);
			data.put("strategyOther", strategyOther);
			//System.out.println(strategylist.get(0));
			//int i;
			//for(i=0;i<strategylist.size();i++){
				//String[] imgs=strategylist.get(i).getCover().split("//");
				//System.out.println(imgs[1]);
				//strategylist.get(i).setCover(imgs[1]);
			//}
			//System.out.println("123");
		return  data;
		}
		
		@RequestMapping(value="/details")
		@ResponseBody
		public  Object Details(Integer id,Integer user_id,String user_name){
			//System.out.println(id);
			Strategy strategy=strategyService.SelectStrategyById(id);
			System.out.println(strategy);
			List<Strategy_photo> image=strategyService.Selectphoto(id);
			ArrayList<Strategy_photo> images=new ArrayList<Strategy_photo>();
			Strategy_photo cover=new Strategy_photo();
			cover.setId(id);
			cover.setImage(strategy.getCover());
			images.add(cover);
			if(image!=null){
			for(int i=0;i<image.size();i++){
				images.add(image.get(i));
			}
			System.out.println(cover);
			System.out.println(images);
		}
			// 将字符串转化为json对象
			System.out.println(images);
			Map<String,Object> data=new HashMap<String,Object>();
			data.put("strategy", strategy);
			data.put("imageArray", images);
			//查询点赞情况
			System.out.println(user_id);
			String res="";
			Dianzan dianzan=dianzanService.selectByIdAndUser_id(id,user_id);
			if(dianzan==null){
				 res="../../dist/img/点赞.png";
			}else{
				 res="../../dist/img/点赞(1).png";
			}
			data.put("res", res);
			//查询收藏情况
			String re="";
			Integer strategy_id=id;
			Collection collection=collectionService.selectByUser_idAndId(user_id, strategy_id);
			if(collection==null){
				re="../../dist/img/收藏.png";
			}else{
				re="../../dist/img/收藏(1).png";
			}
			data.put("re", re);
			return  data;
			//return imageArray;
			}
		
		@RequestMapping(value="/search")
		@ResponseBody
		public Object Search(String keyword) {
			Map<String,Object> data=new HashMap<String,Object>();
			Set<String> expectedNature = new HashSet<String>() {{
	            add("ns");
	            //add("v");add("vd");add("vn");add("vf");
	            //add("vx");add("vi");add("vl");add("vg");
	            //add("nt");add("nz");add("nw");add("nl");
	            //add("ng");add("userDefine");add("wh");
	        }};
	        //String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
	        Result result = ToAnalysis.parse(keyword); //分词结果的一个封装，主要是一个List<Term>的terms
	        System.out.println(result.getTerms());

	        List<Term> terms = result.getTerms(); //拿到terms
	        System.out.println(terms.size());

	        for(int i=0; i<terms.size(); i++) {
	            String word = terms.get(i).getName(); //拿到词
	            String natureStr = terms.get(i).getNatureStr(); //拿到词性
	            if(expectedNature.contains(natureStr)) {
	                System.out.println(word + ":" + natureStr);
	                List<Strategy> strategy=strategyService.SearchWithKey(word);
	                data.put("strategy", strategy);
	            }
	        }
			return data;
		}
		
		
		@RequestMapping(value="/praise")
		@ResponseBody
		public Object Praise(Integer id,Integer user_id){
			Map<String,Object> data=new HashMap<String,Object>();
			Integer strategy_id=id;
			Dianzan dianzan=dianzanService.selectByIdAndUser_id(id, user_id);
			Integer x=0;
			String res="";
			if(dianzan==null){
				x=1;
			dianzanService.insertD(user_id,strategy_id);
			//Integer num=dianzanService.countNum(strategy_id);
			strategyService.PraiseById(id,x);
			 res="../../dist/img/点赞(1).png";
			}else{
				x=-1;
				dianzanService.deleteD(user_id,strategy_id);
			//Integer num=dianzanService.countNum(strategy_id);
				strategyService.PraiseById(id,x);
				 res="../../dist/img/点赞.png";
				
			}
			Strategy strategy=strategyService.SelectStrategyById(id);
			data.put("res",res);
			data.put("strategy",strategy );
			return data;
		}	
		
		@RequestMapping(value="/collection")
		@ResponseBody
		public Object Collection(Integer id,Integer user_id){
			Map<String,Object> data=new HashMap<String,Object>();
			Integer strategy_id=id;
			Collection collection=collectionService.selectByUser_idAndId(user_id, strategy_id);
			Integer y=0;
			String re="";
			if(collection==null){
			y=1;
			Date d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date=sdf.format(d);
			collectionService.insertCollect(user_id,strategy_id, date);
			//Integer num=collectionService.countNum(strategy_id);
			strategyService.CollectById(id,y);
			 re="../../dist/img/收藏(1).png";
			}else{
				y=-1;
				collectionService.deleteCollect(user_id, strategy_id);
				//Integer num=collectionService.countNum(strategy_id);
				strategyService.CollectById(id,y);
				 re="../../dist/img/收藏.png";
				}
			Strategy strategy=strategyService.SelectStrategyById(id);
			data.put("re",re);
			data.put("strategy",strategy);
			return data;
		}
		@RequestMapping(value="/adds")
		@ResponseBody
		public void addStrategy(Integer id,String user_name,String title,
				String content,String location,String pics){
			System.out.println(pics);
			//System.out.println(pics.length());
			if(pics.startsWith("[")){
				pics=pics.substring(1);
			}
			if(pics.endsWith("]")){
				pics=pics.substring(0, pics.length()-1);
			}
			String[] imagesList=pics.split(",");
			ArrayList<String> images=new ArrayList<String>();
			for(String temp:imagesList){
				temp=temp.replace("\"", "");
				temp=temp.replace("wxfile://", "");
				images.add(temp);
			}
			//System.out.println(images);
			Integer user_id=id;
			//System.out.println(location);
			String[] locationpart=location.split("：");
			String[] placepart=locationpart[1].split("市");
			String place=placepart[0]+"市";
			Date d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date=sdf.format(d);
			Integer dianzan=0;
			Integer shoucang=0;
			String cover="http://localhost:8090/MyWe/upload/"+images.get(0);
			//System.out.println(cover);
			//System.out.println(images.size());
			strategyService.InsertStrategy(user_id, user_name, title, date, place, content, dianzan, shoucang, cover);
			Strategy strategy=strategyService.selectLatest();
			Integer p_id=strategy.getId();
			if(images.get(1)!=null){
			int i;
			for(i=1;i<images.size();i++){
			String image="http://localhost:8090/MyWe/upload/"+images.get(i);
			//System.out.println(image);
			//System.out.println(images.get(i));
			strategyService.InsertS_photo(p_id, image);
		}
	}
			
		}
		@RequestMapping(value="/UserCollection")
		@ResponseBody
		public Object selectUserCollection(Integer user_id){
			List<Strategy> strategys=strategyService.selectUser_collection(user_id);
			return strategys;
		}
		
		@RequestMapping(value="/UserPublic")
		@ResponseBody
		public Object selectUserPublic(Integer user_id){
			List<Strategy> strategys=strategyService.selectUser_public(user_id);
			return strategys;
		}
}
			
