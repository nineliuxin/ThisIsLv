package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Gather;
import org.fkit.domain.Member;

public interface MemberMapper {
		@Select("select * from member where gather_id=#{gather_id} and member_id=#{member_id}")
		Member selectByG_idAndM_id(@Param("gather_id")Integer gather_id,
				@Param("member_id")Integer member_id);
		@Insert("insert into member(gather_id,member_id)values(#{gather_id},#{member_id})")
		void insertMember(@Param("gather_id")Integer gather_id,
				@Param("member_id")Integer member_id);
		@Delete("delete from member where member_id=#{member_id} and gather_id=#{gather_id}")
		void deleteJoiner(@Param("gather_id")Integer gather_id,
				@Param("member_id")Integer member_id);
		@Select("select count(*) from member where gather_id=#{gather_id}")
		Integer SelectCount(@Param("gather_id")Integer gather_id);
		@Select("select * from gather,user,member where member.gather_id=gather.id and user.id=gather.user_id and member_id=#{user_id}")
		List<Gather> selectGatherJoiner(@Param("user_id")Integer user_id);
}
