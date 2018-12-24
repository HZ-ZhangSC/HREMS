package cn.edu.hziee.service.Impl;

import java.util.List ;

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
	public Student searchStudentInfoById(Integer sid) {
		return StudentMapper.selectByPrimaryKey(sid);
	}

	@Override
	public String addStudentInfo(Student stu) {
			StudentMapper.insert(stu);
			return "success";
	}
	@Override
	public List<Student> searchStudentInfoByName(String sName) {
		return StudentMapper.selectByName(sName);
	}
	@Override
	public List<Student> searchStudentInfoAll() {
		return StudentMapper.selectAll();
	}
	@Override
	public String updateStudentInfo(Student stu) {
			StudentMapper.updateByPrimaryKeySelective(stu);
			return "success";
	}
	@Override
	public String updatePassword(Student stu){
		    StudentMapper.updatePassword(stu);
		    return "success";
	}
	@Override
	public Student getStudentInfoById(Integer sid) {
		return StudentMapper.selectByPrimaryKey(sid);
	}
	
	@Override
	public int updateInfoById(Student student){
		return StudentMapper.updateByPrimaryKey(student);
	}

}
