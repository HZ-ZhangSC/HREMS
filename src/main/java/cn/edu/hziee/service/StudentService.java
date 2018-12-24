package cn.edu.hziee.service;

import java.util.List;

import cn.edu.hziee.model.Student;


public interface StudentService {

	Student searchStudentInfoById(Integer sid);
	
	List<Student> searchStudentInfoByName(String sName);
	
	List<Student> searchStudentInfoAll();
	
	String addStudentInfo(Student stu);
	
	String updateStudentInfo(Student stu);
	
	String updatePassword(Student stu);
	
	Student getStudentInfoById(Integer sid);

	int updateInfoById(Student stuInfo);

}
