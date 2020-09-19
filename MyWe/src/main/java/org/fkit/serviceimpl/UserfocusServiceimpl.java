package org.fkit.serviceimpl;


import org.fkit.domain.Userfocus;
import org.fkit.mapper.UserfocusMapper;
import org.fkit.service.UserfocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userfocusService")
public class UserfocusServiceimpl implements UserfocusService{
	@Autowired
	private UserfocusMapper userfocusMapper;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	@Override
	public Userfocus selectFocus(Integer uid,Integer id){
		return userfocusMapper.selectFocus(uid, id);
	}
	public void insertFocus(Integer id,Integer uid){
		userfocusMapper.insertFocus(id, uid);
	}
	public void deleteFocus(Integer id,Integer uid){
		userfocusMapper.deleteFocus(id, uid);
	}
}
