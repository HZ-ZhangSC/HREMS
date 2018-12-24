package cn.edu.hziee.service;
import java.util.List;

import cn.edu.hziee.model.Teachers;
public interface TeacherService {
	Teachers searchTeacherInfoById(Integer tid);
	
	List<Teachers> searchTeacherInfoByName(String tName);
	
	String addTeacherInfo(Teachers tea);
	
	List<Teachers> searchTeacherInfoAll();
	
	String updateTeacherInfo(Teachers tea);
	
	String updatePassword(Teachers tea);
	
	String updateRt(Teachers tea);
}
