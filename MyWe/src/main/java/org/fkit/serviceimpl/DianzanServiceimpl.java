package org.fkit.serviceimpl;

import org.fkit.domain.Dianzan;
import org.fkit.mapper.DianzanMapper;
import org.fkit.service.DianzanService;
import org.fkit.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("dianzanService")
public class DianzanServiceimpl implements DianzanService{
	@Autowired
	private DianzanMapper dianzanMapper;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	@Override
	public void insertD(Integer user_id,Integer strategy_id){
		dianzanMapper.insertD(user_id, strategy_id);
	}
	public void deleteD(Integer user_id,Integer strategy_id){
		dianzanMapper.deleteD(user_id,strategy_id);
	}
	public Dianzan selectByIdAndUser_id(Integer id,Integer user_id){
		return dianzanMapper.selectByIdAndUser_id(id, user_id);
	}
}
