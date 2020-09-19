package org.fkit.service;

import org.fkit.domain.Dianzan;

public interface DianzanService {
		void insertD(Integer user_id,Integer strategy_id);
		void deleteD(Integer user_id,Integer strategy_id);
		Dianzan selectByIdAndUser_id(Integer id,Integer user_id);
}
