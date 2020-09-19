package org.fkit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.domain.User;

public interface UserMapper {
		@Select("select * from user where user_name=#{user_name}")
		User selectUser(@Param("user_name")String user_name);
		@Select("select * from user where open_id=#{open_id}")
		User selectUserByOpenid(@Param("open_id")String open_id);
		@Select("select * from user where id=#{id}")
		User selectUserById(@Param("id")Integer id);
		@Insert("insert into user(open_id,user_name,user_img)values(#{openid},#{username},#{img},#{focus},#{fans})")
		void InsertUser(@Param("openid")String openid,
				@Param("username")String username,
				@Param("img")String img,
				@Param("focus")Integer focus,
				@Param("fans")Integer fans);
		@Update("update user set fans=fans+#{x} where id=#{id}")
		void updateFans(@Param("id")Integer id,
				@Param("x")Integer x);
		@Update("update user set focus=focus+#{y} where id=#{uid}")
		void updateFocus(@Param("uid")Integer uid,
				@Param("y")Integer y);
}
