package cn.edu.hziee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import cn.edu.hziee.model.Student;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    List<Student> selectByName(String sName);
    List<Student> selectAll();
	int updatePassword(Student stu);
}