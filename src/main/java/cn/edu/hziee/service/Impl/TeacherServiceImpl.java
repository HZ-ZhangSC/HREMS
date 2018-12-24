package cn.edu.hziee.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import cn.edu.hziee.dao.TeachersMapper;
import cn.edu.hziee.model.Teachers;
import cn.edu.hziee.service.TeacherService;


@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	TeachersMapper TeachersMapper;
	@Override
	public Teachers searchTeacherInfoById(Integer tid) {
		return TeachersMapper.selectByPrimaryKey(tid);
	}
	@Override
	public String addTeacherInfo(Teachers tea) {
			TeachersMapper.insert(tea);
			return "success";
	}
	@Override
	public List<Teachers> searchTeacherInfoAll() {
		return TeachersMapper.selectAll();
	}
	@Override
	public List<Teachers> searchTeacherInfoByName(String tName) {
		return TeachersMapper.selectByName(tName);
	}
	@Override
	public String updateTeacherInfo(Teachers tea) {
			TeachersMapper.updateByPrimaryKey(tea);
			return "success";
	}
	@Override
	public String updatePassword(Teachers tea) {
			TeachersMapper.updatePassword(tea);
			return "success";
	}
	@Override
	public String updateRt(Teachers tea) {
			TeachersMapper.updateRt(tea);
			return "success";
	}
}
