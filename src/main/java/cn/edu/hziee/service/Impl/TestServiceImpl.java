package cn.edu.hziee.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hziee.dao.TestsMapper;
import cn.edu.hziee.model.Tests;

@Service
public class TestServiceImpl implements cn.edu.hziee.service.TestService {
	
	@Autowired
	TestsMapper testsMapper;

	@Override
	public Tests getTestInfoById(Integer er_tsid) {
		return testsMapper.selectByPrimaryKey(er_tsid);
	}

}
