package org.fkit.serviceimpl;


import java.util.List;

import org.fkit.domain.Level;
import org.fkit.mapper.LevelMapper;
import org.fkit.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("levelService")
public class LevelServiceimpl implements LevelService {
	@Autowired
	private LevelMapper levelMapper;
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	@Override
	public List<Level> selectLevelA(Integer a){
		return levelMapper.selectLevelA(a);
	}
	public List<Level> selectLevelB(Integer c,Integer b){
		return levelMapper.selectLevelB(c,b);
	}
}
