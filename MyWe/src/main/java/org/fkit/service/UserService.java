package org.fkit.service;

import org.fkit.domain.User;

public interface UserService {
		User selectUser(String user_name);
		User selectUserById(Integer id);
		User selectUserByOpenid(String open_id);
		void InsertUser(String openid,String username,String img,Integer focus,Integer fans);
		void updateFans(Integer id,Integer x);
		void updateFocus(Integer uid,Integer y);
}
