package org.fkit.service;

import java.util.List;

import org.fkit.domain.Strategy;
import org.fkit.domain.Strategy_photo;

public interface StrategyService {
		List<Strategy> show();
		List<Strategy> showOther();
		Strategy SelectStrategyById(Integer id);
		List<Strategy> SearchWithKey(String keyword);
		void PraiseById(Integer id,Integer x);
		void CollectById(Integer id,Integer y);
		List<Strategy_photo> Selectphoto(Integer id);
		void InsertStrategy(Integer user_id,String user_name,String title,
				String date,String place,String content,Integer dianzan,Integer shoucang,String cover);
		void InsertS_photo(Integer p_id,String image);
		Strategy selectLatest();
		List<Strategy>  selectUser_collection(Integer user_id);
		List<Strategy> selectUser_public(Integer user_id);
		List<Strategy> selectStrategyByUser_id(Integer id);
		Integer selectPlaceCount(Integer id);
}
