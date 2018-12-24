package cn.edu.hziee.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hziee.dao.TestsMapper;
import cn.edu.hziee.model.Tests;

@Service
public class TestServiceImpl implements cn.edu.hziee.service.TestService {
	
	@Autowired
	TestsMapper testsMapper;

	@Override
	public Tests searchTestInfoById(Integer er_tsid) {
		return testsMapper.selectByPrimaryKey(er_tsid);
	}

	@Override
	public Tests addTestInfo(Tests test) {
		 testsMapper.insertSelective(test);
		return test;
	}

	@Override
	public int deleteTestInfo(Integer tsId) {
		return testsMapper.deleteByPrimaryKey(tsId);
	}


	@Override
	public int updateTestInfo(Tests test) {
		return testsMapper.updateByPrimaryKeySelective(test);
	}

	@Override
	public List<Tests> searchTestInfoByName(String tsname) {
		return testsMapper.selectByName(tsname);
	}

	@Override
	public List<Tests> searchTestsInfoAll() {
		return testsMapper.selectAll();
	}


}
