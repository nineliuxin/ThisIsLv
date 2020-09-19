package org.fkit.service;

import org.fkit.domain.Collection;

public interface CollectionService {
	Collection selectByUser_idAndId(Integer user_id,Integer strategy_id);
	void insertCollect(Integer user_id,Integer strategy_id,String date);
	void deleteCollect(Integer user_id,Integer strategy_id);
}
