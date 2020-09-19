package org.fkit.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Userfocus;

public interface UserfocusMapper {
		@Select("select * from userfocus where focus_user=#{uid} and user_focus=#{id}")
		Userfocus selectFocus(@Param("uid")Integer uid,
				@Param("id")Integer id);
		@Insert("insert into userfocus(user_focus,focus_user)values(#{id},#{uid})")
		void insertFocus(@Param("id")Integer id,
				@Param("uid")Integer uid);
		@Delete("delete from userfocus where user_focus=#{id} and focus_user=#{uid}")
		void deleteFocus(@Param("id")Integer id,
				@Param("uid")Integer uid);
}
