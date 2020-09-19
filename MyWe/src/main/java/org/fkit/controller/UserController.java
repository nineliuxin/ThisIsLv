package org.fkit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fkit.domain.Gather;
import org.fkit.domain.Strategy;
import org.fkit.domain.User;
import org.fkit.domain.Userfocus;
import org.fkit.service.GatherService;
import org.fkit.service.StrategyService;
import org.fkit.service.UserService;
import org.fkit.service.UserfocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@Autowired
	@Qualifier("userfocusService")
	private UserfocusService userfocusService;
	@Autowired
	@Qualifier("strategyService")
	private StrategyService strategyService;
	@Autowired
	@Qualifier("gatherService")
	private GatherService gatherService;
	@RequestMapping(value="/adduser")
	@ResponseBody
	public Object AddUser(String openid,String username,String img){
		String open_id=openid;
		Map<String,Object> b=new HashMap<String,Object>();
		User user1=userService.selectUserByOpenid(open_id);
		if(user1==null){
		Integer focus=0;
		Integer fans=0;
		userService.InsertUser(openid, username, img,focus,fans);
		User user2=userService.selectUserByOpenid(open_id);
		Integer uid=user2.getId();
		b.put("uid", uid);
	}else{
		Integer uid=user1.getId();
		b.put("uid",uid);
	}
		return b;
	}
	@RequestMapping(value="/show")
	@ResponseBody
	public Object userShow(Integer id){
		Map<String,Object> data=new HashMap<String,Object>();
		User user=userService.selectUserById(id);
		Integer focus=user.getFocus();
		Integer fans=user.getFans();
		data.put("focus", focus);
		data.put("fans", fans);
		return data;
	}
	@RequestMapping(value="/lookuser")
	@ResponseBody
	public Object lookUser(Integer id,Integer uid){
		Map<String,Object> data=new HashMap<String,Object>();
		User user=userService.selectUserById(id);
		String user_img=user.getUser_img();
		String user_name=user.getUser_name();
		Integer focus=user.getFocus();
		Integer fans=user.getFans();
		Integer placeCount=strategyService.selectPlaceCount(id);
		List<Strategy> strategys=strategyService.selectStrategyByUser_id(id);
		Integer Scount=strategys.size();
		//String level="";
		//判断用户查看另一个用户是否关注此用户
		String text;
		Userfocus userfocus=userfocusService.selectFocus(uid, id);
		if(userfocus== null){
			text="关注Ta";
		}else{
			text="已关注";
		}
		data.put("text",text);
		data.put("user_img",user_img);
		data.put("user_name",user_name);
		data.put("focus", focus);
		data.put("fans",fans);
		data.put("placeCount",placeCount);
		data.put("Scount",Scount);
		data.put("strategys",strategys);
		return data;
		
		
	}
	@RequestMapping(value="/lookuserG")
	@ResponseBody
	public Object LookUserGather(Integer user_id){
		List<Gather> gatherList=gatherService.selectGatherList(user_id);
		return gatherList;
	}
	@RequestMapping(value="/userFocus")
	@ResponseBody
	public Object MakeUserFocus(Integer id,Integer uid){
		Map<String,Object> data=new HashMap<String,Object>();
		Userfocus userfocus=userfocusService.selectFocus(uid, id);
		String text;
		if(userfocus==null){
			userfocusService.insertFocus(id, uid);
			int x=1;
			int y=1;
			userService.updateFans(id, x);
			userService.updateFocus(uid, y);
			text="已关注";
		}else{
			userfocusService.deleteFocus(id, uid);
			int x=-1;
			int y=-1;
			userService.updateFans(id, x);
			userService.updateFocus(uid, y);
			text="关注Ta";
		}
		User user=userService.selectUserById(id);
		Integer focus=user.getFocus();
		Integer fans=user.getFans();
		data.put("text", text);
		data.put("focus", focus);
		data.put("fans",fans);
		return data;
	}
}
