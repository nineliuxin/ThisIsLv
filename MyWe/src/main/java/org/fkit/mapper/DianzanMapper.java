package org.fkit.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Dianzan;

public interface DianzanMapper {
		@Insert("insert into dianzan(user_id,strategy_id)values(#{user_id},#{strategy_id})")
		void insertD(@Param("user_id")Integer user_id,
				@Param("strategy_id")Integer strategy_id);
		@Delete("delete from dianzan where user_id=#{user_id} and strategy_id=#{strategy_id}")
		void deleteD(@Param("user_id")Integer user_id,
				@Param("strategy_id")Integer strategy_id);
		@Select("select * from dianzan where strategy_id=#{id} and user_id=#{user_id}")
		Dianzan selectByIdAndUser_id(@Param("id")Integer id,
				@Param("user_id")Integer user_id);
}
