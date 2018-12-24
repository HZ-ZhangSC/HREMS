package cn.edu.hziee.service;

import java.util.List;

import cn.edu.hziee.model.Tests;

public interface TestService {

	Tests searchTestInfoById(Integer er_tsid);

	Tests addTestInfo(Tests test);

	int deleteTestInfo(Integer tsId);

	int updateTestInfo(Tests test);
	
	List<Tests> searchTestsInfoAll();
	
	List<Tests> searchTestInfoByName(String tsname);


}
