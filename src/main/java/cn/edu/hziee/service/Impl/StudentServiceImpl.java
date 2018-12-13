package cn.edu.hziee.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hziee.dao.StudentMapper;
import cn.edu.hziee.model.Student;
import cn.edu.hziee.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentMapper StudentMapper;

	@Override
	public Student getStudentInfoById(Integer sid) {
		return StudentMapper.selectByPrimaryKey(sid);
	}

}
