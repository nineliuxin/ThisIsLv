package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Focus;
import org.fkit.domain.Gather;

public interface FocusMapper {
		@Select("select * from focus where user_id=#{user_id} and gather_id=#{gather_id}")
		Focus selectByUser_idAndId(@Param("user_id")Integer user_id,
				@Param("gather_id")Integer gather_id);
		@Insert("insert into focus (gather_id,user_id)values(#{gather_id},#{user_id})")
		void insertFocus(@Param("gather_id")Integer gather_id,
				@Param("user_id")Integer user_id);
		@Select("select count(*) from focus where gather_id=#{gather_id}")
		Integer SelectCount(@Param("gather_id")Integer gather_id);
		@Delete("delete from focus where user_id=#{user_id} and gather_id=#{gather_id}")
		void deleteFocus(@Param("gather_id")Integer gather_id,
				@Param("user_id")Integer user_id);
		@Select("select * from focus,gather,user where gather.id=focus.gather_id and user.id=gather.user_id and focus.user_id=#{user_id}")
		List<Gather> selectGatherFocus(@Param("user_id")Integer user_id);
}
