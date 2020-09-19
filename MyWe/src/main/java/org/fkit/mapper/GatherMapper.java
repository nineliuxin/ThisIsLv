package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.domain.Gather;

public interface GatherMapper {
		@Insert("insert into gather"
				+ "(title,user_id,user_name,date,content,travel_city,travel_date,sex,images,focus,joiner,connection,con_status) values "
				+ "(#{title},#{user_id},#{user_name},#{date},#{content},#{travel_city},#{travel_date},#{sex},#{images},#{focus},#{joiner},#{connection},#{con_status})")
		void insertGather(@Param("title")String title,
				@Param("user_id")Integer user_id,
				@Param("user_name")String user_name,
				@Param("date")String date,
				@Param("content")String content,
				@Param("travel_city")String travel_city,
				@Param("travel_date")String travel_date,
				@Param("sex")String sex,
				@Param("images")String images,
				@Param("focus")Integer focus,
				@Param("joiner")Integer joiner,
				@Param("connection")String connection,
				@Param("con_status")String con_status);
		
		@Select("select * from gather,user where user.id=gather.user_id")
		List<Gather> showHot();
		@Select("select* from gather,user where user.id=gather.user_id and joiner<10 order by gather.id desc")
		List<Gather> show();
		@Select("select * from gather,user where gather.id=#{id} and gather.user_id=user.id")
		Gather selectGather(@Param("id")Integer id);
		@Update("update gather set focus=#{count} where id=#{gather_id}")
		void updateFocus(@Param("count")Integer count,
				@Param("gather_id")Integer gather_id);
		@Update("update gather set joiner=#{count} where id=#{gather_id}")
		void updateJoiner(@Param("count")Integer count,
				@Param("gather_id")Integer gather_id);
		@Select("select * from gather,user where user.id=gather.user_id and user_id=#{user_id}")
		List<Gather> selectGatherList(@Param("user_id")Integer user_id);
		@Select("select * from gather,user where match(travel_city) against (#{Keyword} IN BOOLEAN MODE) and user.id=gather.user_id ")
		List<Gather> SearchWithKey(@Param("Keyword")String Keyword);
		@Select("select * from gather,user where match(title,content)against(#{Keyword} IN BOOLEAN MODE) and user.id=gather.user_id")
		List<Gather> selectKeyword(@Param("Keyword")String Keyword);
}
