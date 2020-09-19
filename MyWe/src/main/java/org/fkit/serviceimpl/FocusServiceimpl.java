package org.fkit.serviceimpl;

import java.util.List;

import org.fkit.domain.Focus;
import org.fkit.domain.Gather;
import org.fkit.mapper.FocusMapper;
import org.fkit.service.FocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("focusService")
public class FocusServiceimpl implements FocusService{
	@Autowired
	private FocusMapper focusMapper;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	@Override
	public Focus selectByUser_idAndId(Integer user_id,Integer gather_id){
		return focusMapper.selectByUser_idAndId(user_id, gather_id);
	}
	public void insertFocus(Integer gather_id,Integer user_id){
		focusMapper.insertFocus(gather_id, user_id);
	}
	public Integer SelectCount(Integer gather_id){
		return focusMapper.SelectCount(gather_id);
	}
	public void deleteFocus(Integer gather_id,Integer user_id){
		focusMapper.deleteFocus(gather_id, user_id);
	}
	public List<Gather> selectGatherFocus(Integer user_id){
		return focusMapper.selectGatherFocus(user_id);
	}
}
