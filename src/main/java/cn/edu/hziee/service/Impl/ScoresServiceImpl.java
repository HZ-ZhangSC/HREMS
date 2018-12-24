package cn.edu.hziee.service.Impl;

import java.util.List;

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
	public Scores searchScoresInfoByEid(Integer eid) {
		return ScoresMapper.selectByKh(eid);
	}
	
	@Override
	public int insertScore(Scores score){
		return ScoresMapper.insert(score);
	}
	
	@Override
	public int updateScore(Scores score){
		return ScoresMapper.updateByPrimaryKey(score);
	}
	
	@Override
	public int deleteScoresInfoByEid(Integer eid) {
		return ScoresMapper.deleteByKh(eid);
	}

	@Override
	public List<Scores> searchAllScores() {
		return ScoresMapper.selectAll();
	}
}
