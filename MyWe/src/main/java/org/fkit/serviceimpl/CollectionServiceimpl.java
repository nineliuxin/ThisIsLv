package org.fkit.serviceimpl;

import org.fkit.domain.Collection;
import org.fkit.mapper.CollectionMapper;
import org.fkit.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("collectionService")
public class CollectionServiceimpl implements CollectionService{
	@Autowired
	private CollectionMapper collectionMapper;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	@Override
	public Collection selectByUser_idAndId(Integer user_id,Integer strategy_id){
		return collectionMapper.selectByUser_idAndId(user_id, strategy_id);
	}
	public void insertCollect(Integer user_id,Integer strategy_id,String date) {
		collectionMapper.insertCollect(user_id, strategy_id, date);
	}
	public void deleteCollect(Integer user_id,Integer strategy_id){
		collectionMapper.deleteCollect(user_id, strategy_id);
	}
}
