package org.fkit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fkit.domain.Level;
import org.fkit.domain.Strategy;
import org.fkit.service.LevelService;
import org.fkit.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("level")
public class LevelController {
	@Autowired
	@Qualifier("levelService")
	private LevelService levelService;
	@Autowired
	@Qualifier("strategyService")
	private StrategyService strategyService;
	@RequestMapping(value="/show")
	@ResponseBody
	public Object ShowLevel(Integer uid){
		Integer id=uid;
		//ArrayList<String> dateList=new ArrayList<String>();
		List<Strategy> strategys=strategyService.selectStrategyByUser_id(id);
		for(int i=0;i<strategys.size();i++){
			String dt=strategys.get(i).getDate().split(" ")[0];
			//System.out.println(dt);
			strategys.get(i).setDate(dt);
			//System.out.println(strategys.get(i).getDate());
		}
		Map<String,Object> data=new HashMap<String,Object>();
		Integer cityCount=strategyService.selectPlaceCount(id);
		Integer level;
		int num=0;
		String x="display";
		String y="none";
		//判断等级
		//如果个数小于等于2，则为等级0，所有徽章全灰
		//如果个数大于2小于等于5，则为等级1，等级1徽章为亮
		//如果个数大于5小于等于8，则为等级2，等级1-2徽章为亮
		//如果个数大于8小于等于12，则为等级3，等级1-3徽章为亮
		//如果个数大于12小于等于16，则为等级4，等级1-4徽章为亮
		//如果个数大于16小于等于20，则为等级5，等级1-5徽章为亮
		//如果个数大于20，则为等级6，等级1-6徽章为亮
		List<Level> levellist_a;
		List<Level> levellist_b;
		if(cityCount<=2){
			int a=0;
			int b=6-a;
			int c=6+a;
			levellist_a=levelService.selectLevelA(a);
			levellist_b=levelService.selectLevelB(c,b);
			level=0;
			num=3-cityCount;
		}else if(cityCount>2 & cityCount<=5){
			int a=1;
			int b=6-a;
			int c=6+a;
			levellist_a=levelService.selectLevelA(a);
			levellist_b=levelService.selectLevelB(c,b);
			level=1;
			num=6-cityCount;
		}else if(cityCount>5 & cityCount<=8){
			int a=2;
			int b=6-a;
			int c=6+a;
			num=9-cityCount;
			levellist_a=levelService.selectLevelA(a);
			levellist_b=levelService.selectLevelB(c,b);
			level=2;
	}else if(cityCount>8 & cityCount<=12){
			int a=3;
			int b=6-a;
			int c=6+a;
			levellist_a=levelService.selectLevelA(a);
			levellist_b=levelService.selectLevelB(c,b);
			level=3;
			num=13-cityCount;
	}else if(cityCount>12 & cityCount<=16){
		int a=4;
		int b=6-a;
		int c=6+a;
		levellist_a=levelService.selectLevelA(a);
		levellist_b=levelService.selectLevelB(c,b);
		level=4;
		num=17-cityCount;
	}else if(cityCount>16 & cityCount<=20){
		int a=5;
		int b=6-a;
		int c=6+a;
		levellist_a=levelService.selectLevelA(a);
		levellist_b=levelService.selectLevelB(c,b);
		level=5;
		num=21-cityCount;
	}else{
	int a=6;
	int b=6-a;
	int c=6+a;
	levellist_a=levelService.selectLevelA(a);
	levellist_b=levelService.selectLevelB(c,b);
	level=6;
	x="none";
	y="display";
}
		ArrayList<String> picList=new ArrayList<String>();
		for(int i=0;i<levellist_a.size();i++){
			picList.add(levellist_a.get(i).getImg());
		}
		for(int i=0;i<levellist_b.size();i++){
			picList.add(levellist_b.get(i).getImg());
		}
		data.put("picList", picList);
		data.put("level", level);
		data.put("num", num);
		data.put("x", x);
		data.put("y", y);
		data.put("cityCount", cityCount);
		data.put("strategys", strategys);
		System.out.println(picList);
		System.out.println(level);
		return data;
}
	
}