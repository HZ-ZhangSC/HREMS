package cn.edu.hziee.service;

import java.util.List;

import cn.edu.hziee.model.Examinees;
public interface ExamineesService {

	Examinees addExameeInfo(Examinees examee);

	int deleteExameeInfo(Integer eEid);

	Examinees searchExameeByeEid(Integer eid);

	List<Examinees> searchExameeBySid(Integer sid);

	int updateExameeInfo(Examinees examee);

	Examinees searchHistoryTestsBySid(Integer sid);

	List<Examinees> searchExameeAll();

	List<Examinees> searchExameeBySname(String sName);

}