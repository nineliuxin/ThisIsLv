package org.fkit.service;

import java.util.List;

import org.fkit.domain.Gather;

public interface GatherService {
		void insertGather(String title,Integer user_id,String user_name,
				String date,String content,String travel_city,String travel_date,
				String sex,String images,Integer focus,Integer joiner,String connection,String con_status);
		List<Gather> showHot();
		List<Gather> show();
		Gather selectGather(Integer id);
		void updateFocus(Integer count,Integer gather_id);
		void updateJoiner(Integer count,Integer gather_id);
		List<Gather> selectGatherList(Integer user_id);
		List<Gather> SearchWithKey(String Keyword);
		List<Gather> selectKeyword(String Keyword);
}
