package org.fkit.service;

import java.util.List;

import org.fkit.domain.Level;

public interface LevelService {
	List<Level> selectLevelA(Integer a);
	List<Level> selectLevelB(Integer c,Integer b);
}
