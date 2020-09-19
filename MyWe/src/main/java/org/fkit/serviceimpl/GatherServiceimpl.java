package org.fkit.serviceimpl;

import java.util.List;

import org.fkit.domain.Gather;
import org.fkit.mapper.GatherMapper;
import org.fkit.service.GatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("gatherService")
public class GatherServiceimpl implements GatherService{
	@Autowired
	private GatherMapper gatherMapper;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	@Override
	public  void insertGather(String title,Integer user_id,String user_name,
			String date,String content,String travel_city,String travel_date,
			String sex,String images,Integer focus,Integer joiner,String connection,String con_status){
		gatherMapper.insertGather(title,user_id,user_name,date,content,travel_city,travel_date,sex,images,focus,joiner,connection,con_status);
	}
	public List<Gather>showHot(){
		return gatherMapper.showHot();
	}
	public List<Gather> show(){
		return gatherMapper.show();
	}
	public Gather selectGather(Integer id){
		return gatherMapper.selectGather(id);
	}
	public void updateFocus(Integer count,Integer gather_id){
		gatherMapper.updateFocus(count, gather_id);
	}
	public void updateJoiner(Integer count,Integer gather_id){
		gatherMapper.updateJoiner(count, gather_id);
	}
	public List<Gather> selectGatherList(Integer user_id){
		return gatherMapper.selectGatherList(user_id);
	}
	public List<Gather> SearchWithKey(String Keyword){
		return gatherMapper.SearchWithKey(Keyword);
	}
	public List<Gather> selectKeyword(String Keyword){
		return gatherMapper.selectKeyword(Keyword);
	}
}
