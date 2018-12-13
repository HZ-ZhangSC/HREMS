package cn.edu.hziee.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hziee.dao.ScoresMapper;
import cn.edu.hziee.model.Scores;
import cn.edu.hziee.service.ScoresService;

@Service
public class ScoresServiceImpl implements ScoresService{
	
	@Autowired
	ScoresMapper ScoresMapper;
	
	
	@Override
	public Scores getScoresInfoById(Integer eid) {
		return ScoresMapper.selectByKh(eid);
	}
}