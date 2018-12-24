package cn.edu.hziee.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hziee.dao.ExamineesMapper;
import cn.edu.hziee.model.Examinees;
import cn.edu.hziee.service.ExamineesService;

@Service
public class ExamineesServiceImpl implements ExamineesService {
	
	@Autowired
	ExamineesMapper examineesMapper;

	@Override
	public Examinees addExameeInfo(Examinees examee) {
		examineesMapper.insert(examee);
		return examee;
	}

	@Override
	public int deleteExameeInfo(Integer eEid) {
		return examineesMapper.deleteByPrimaryKey(eEid);
	}

	@Override
	public Examinees searchExameeByeEid(Integer eEid) {
		return examineesMapper.selectByPrimaryKey(eEid);
	}

	@Override
	public List<Examinees> searchExameeBySid(Integer sid) {
		return examineesMapper.selectBySid(sid);
	}

	@Override
	public int updateExameeInfo(Examinees examee) {
		return examineesMapper.updateByPrimaryKey(examee);
	}

	@Override
	public Examinees searchHistoryTestsBySid(Integer sid) {
		return examineesMapper.selectHistoryTestsBySid(sid);
	}

	@Override
	public List<Examinees> searchExameeAll() {
		return examineesMapper.selectAll();
	}

	@Override
	public List<Examinees> searchExameeBySname(String sName) {
		return examineesMapper.selectBySname(sName);
	}

}