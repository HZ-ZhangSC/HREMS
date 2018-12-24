package cn.edu.hziee.service.Impl;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import cn.edu.hziee.dao.ManagerMapper;
import cn.edu.hziee.model.Manager;
import cn.edu.hziee.model.Student;
import cn.edu.hziee.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	ManagerMapper ManagerMapper;

	@Override
	public Manager searchManagerInfoById(Integer mid) {
		return ManagerMapper.selectByPrimaryKey(mid);
	}
	@Override
	public String addManagerInfo(Manager man){ 
			ManagerMapper.insert(man);
			return "success";
	}

}
