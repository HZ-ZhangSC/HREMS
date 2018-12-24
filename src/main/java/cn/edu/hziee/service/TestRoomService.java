package cn.edu.hziee.service;

import java.util.Date;
import java.util.List;

import cn.edu.hziee.model.Ems;

public interface TestRoomService {

	Ems addTestRoom(Ems ems);

	Ems searchTestRoomInfoById(Integer erId);

	int deleteTestRoom(Integer erId);

	List<Ems> searchTestRoom(Integer erTsId);

	int updateTestRoom(Ems ems);

	List<Ems> searchTestRoomByKeys(Date begin, Date end, int status, String tsName);

	List<Ems> searchAllTestRoom();

}