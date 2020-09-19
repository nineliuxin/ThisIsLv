package org.fkit.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Collection;

public interface CollectionMapper {
		@Select("select * from collection where user_id=#{user_id} and strategy_id=#{strategy_id}")
		Collection selectByUser_idAndId(@Param("user_id")Integer user_id,
				@Param("strategy_id")Integer strategy_id);
		@Insert("insert into collection(user_id,strategy_id,date)values(#{user_id},#{strategy_id},#{date})")
		void insertCollect(@Param("user_id")Integer user_id,
				@Param("strategy_id")Integer strategy_id,
				@Param("date")String date);
		@Delete("delete from collection where user_id=#{user_id} and strategy_id=#{strategy_id}")
		void deleteCollect(@Param("user_id")Integer user_id,
		@Param("strategy_id")Integer strategy_id);
}
