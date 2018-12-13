package cn.edu.hziee.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import cn.edu.hziee.dao.EmsMapper;
import cn.edu.hziee.model.Ems;
import cn.edu.hziee.service.TestRoomService;

@Service
public class TestRoomServiceImpl implements TestRoomService {
	
	@Autowired
	EmsMapper emsMapper;

	@Override
	public Ems addTestRoom(Ems ems) {
		emsMapper.insert(ems);
		return ems;
	}

	@Override
	public Ems getTestRoomInfoById(Integer erId) {
		return emsMapper.selectByPrimaryKey(erId);
	}

	@Override
	public int deleteTestRoom(Integer erId) {
		return emsMapper.deleteByPrimaryKey(erId);
	}

	@Override
	public List<Ems> searchTestRoom(Integer erTsid) {
		return emsMapper.selectByTsid(erTsid);
	}

	@Override
	public int updateTestRoom(Ems ems) {
		return emsMapper.updateByPrimaryKeySelective(ems);
	}

	@Override
	public List<Ems> searchTestRoomByKeys(Date begin, Date end, int status, String tsName) {
		return emsMapper.selectByKeys(begin, end, status, tsName);
	}

}
