package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.domain.Strategy;
import org.fkit.domain.Strategy_photo;

public interface  StrategyMapper {
	@Select("select * from strategy,user where user.id=strategy.user_id and dianzan>=50")
	List<Strategy> show();
	@Select("select * from strategy,user where user.id=strategy.user_id and dianzan<50 order by strategy.id desc")
	List<Strategy> showOther();
	@Select("select * from strategy,user where strategy.id=#{id} and user.id=strategy.user_id")
	Strategy SelectStrategyById(Integer id);
	@Select("select * from strategy_photo where id=#{id}")
	List<Strategy_photo> Selectphoto(Integer id);
	@Select("select * from strategy where match(title,content) against (#{keyword} IN BOOLEAN MODE)")
	List<Strategy> SearchWithKey(String keyword);
	@Update("update strategy set dianzan=dianzan+#{x} where id=#{id}")
	void PraiseById(@Param("id")Integer id,
			@Param("x")Integer x);
	@Update("update strategy set shoucang=shoucang+#{y} where id=#{id}")
	void CollectById(@Param("id")Integer id,
			@Param("y")Integer y);
	@Insert("insert into strategy(user_id,user_name,title,date,place,content,dianzan,shoucang,cover)values(#{user_id},#{user_name},#{title},#{date},#{place},#{content},#{dianzan},#{shoucang},#{cover})")
	void InsertStrategy(@Param("user_id")Integer user_id,
			@Param("user_name")String user_name,
			@Param("title")String title,
			@Param("date")String date,
			@Param("place")String place,
			@Param("content")String content,
			@Param("dianzan")Integer dianzan,
			@Param("shoucang")Integer shoucang,
			@Param("cover")String cover);
	@Insert("insert into strategy_photo(id,image)values(#{p_id},#{image})")
	void InsertS_photo(@Param("p_id")Integer p_id,
			@Param("image")String images);
	@Select("select * from strategy where id=(select max(id) from strategy);")
	Strategy selectLatest();
	@Select("select * from strategy,user,collection where user.id=strategy.user_id and collection.user_id=#{user_id} and collection.strategy_id=strategy.id")
	List<Strategy> selectUser_collection(@Param("user_id")Integer user_id);
	@Select("select * from strategy,user where user_id=#{user_id} and user.id=strategy.user_id order by strategy.id desc")
	List<Strategy> selectUser_public(@Param("user_id")Integer user_id);
	@Select("select * from strategy,user where user.id=strategy.user_id and strategy.user_id=#{id}")
	List<Strategy> selectStrategyByUser_id(@Param("id")Integer id);
	@Select("select count(distinct place) from strategy,user where user.id=strategy.user_id and strategy.user_id=#{id}")
	Integer selectPlaceCount(@Param("id")Integer id);
}
