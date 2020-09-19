package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Level;

public interface LevelMapper {
		@Select("select * from level limit 0,#{a}")
		List<Level> selectLevelA(@Param("a")Integer a);
		@Select("select * from level limit #{c},#{b}")
		List<Level> selectLevelB(@Param("c")Integer c,
				@Param("b")Integer b);
}
