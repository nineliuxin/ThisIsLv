package org.fkit.serviceimpl;

import org.fkit.domain.User;
import org.fkit.mapper.DianzanMapper;
import org.fkit.mapper.UserMapper;
import org.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("userService")
public class UserServiceimpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	@Override
	public User selectUser(String user_name){
		return userMapper.selectUser(user_name);
	}
	public User selectUserByOpenid(String open_id){
		return userMapper.selectUserByOpenid(open_id);
	}
	public User selectUserById(Integer id){
		return userMapper.selectUserById(id);
	}
	public void InsertUser(String openid,String username,String img,Integer focus,Integer fans){
		userMapper.InsertUser(openid, username, img,focus, fans);
	}
	public void updateFans(Integer id,Integer x){
		userMapper.updateFans(id,x);
	}
	public void updateFocus(Integer uid,Integer y){
		userMapper.updateFocus(uid,y);
	}
}
