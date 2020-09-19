package org.fkit.serviceimpl;

import java.util.List;

import org.fkit.domain.Strategy;
import org.fkit.domain.Strategy_photo;
import org.fkit.mapper.StrategyMapper;
import org.fkit.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("strategyService")
public class StrategyServiceimpl implements StrategyService{
	@Autowired
	private StrategyMapper strategyMapper;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	@Override
	public List<Strategy> show(){
		return strategyMapper.show();
	}
	public List<Strategy> showOther(){
		return strategyMapper.showOther();
	}
	public Strategy SelectStrategyById(Integer id){
		return strategyMapper.SelectStrategyById(id);
	}
	public List<Strategy> SearchWithKey(String keyword){
		return strategyMapper.SearchWithKey(keyword);
	}
	public void PraiseById(Integer id,Integer x){
		strategyMapper.PraiseById(id,x);
	}
	public void CollectById(Integer id,Integer y){
		strategyMapper.CollectById(id, y);
	}
	public List<Strategy_photo> Selectphoto(Integer id){
		return strategyMapper.Selectphoto(id);
	}
	public void InsertStrategy(Integer user_id,String user_name,String title,
			String date,String place,String content,Integer dianzan,Integer shoucang,String cover){
		strategyMapper.InsertStrategy(user_id, user_name, title, date, place, content, dianzan, shoucang, cover);	
	}
	public void InsertS_photo(Integer p_id,String image){
		strategyMapper.InsertS_photo(p_id,image);
	}
	public Strategy selectLatest(){
		return strategyMapper.selectLatest();
	}
	public List<Strategy> selectUser_collection(Integer user_id){
		return strategyMapper.selectUser_collection(user_id);
	}
	public List<Strategy>selectUser_public(Integer user_id){
		return strategyMapper.selectUser_public(user_id);
	}
	public List<Strategy> selectStrategyByUser_id(Integer id){
		return strategyMapper.selectStrategyByUser_id(id);
	}
	public Integer selectPlaceCount(Integer id){
		return strategyMapper.selectPlaceCount(id);
	}
}
