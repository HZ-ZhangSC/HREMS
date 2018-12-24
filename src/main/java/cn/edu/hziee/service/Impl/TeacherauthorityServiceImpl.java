package cn.edu.hziee.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hziee.dao.TeacherauthorityMapper;
import cn.edu.hziee.model.Teacherauthority;
import cn.edu.hziee.service.TeacherauthorityService;

@Service
public class TeacherauthorityServiceImpl implements TeacherauthorityService{
	@Autowired
	TeacherauthorityMapper TeacherauthorityMapper;

	@Override
	public List<Teacherauthority> searchTeacherauthorityAll() {
		return TeacherauthorityMapper.selectAll();
	}

	@Override
	public Teacherauthority searchTeacherauthorityById(Integer id) {
		return TeacherauthorityMapper.selectByPrimaryKey(id);
	}
	

}
