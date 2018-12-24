package cn.edu.hziee.service;
import cn.edu.hziee.model.*;
import java.util.*;
public interface TeacherauthorityService {
	List<Teacherauthority> searchTeacherauthorityAll();
	
	Teacherauthority searchTeacherauthorityById(Integer id);

}
