package cn.edu.hziee.service;

import java.util.List;

import cn.edu.hziee.model.Scores;

public interface ScoresService {

	Scores searchScoresInfoByEid(Integer eid) ;

	int insertScore(Scores score);

	int updateScore(Scores score);

	int deleteScoresInfoByEid(Integer scEid);

	List<Scores> searchAllScores();


}
