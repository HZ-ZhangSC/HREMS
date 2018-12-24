package cn.edu.hziee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.edu.hziee.model.Teacherauthority;
@Mapper
public interface TeacherauthorityMapper {
    int deleteByPrimaryKey(Integer taLevel);

    int insert(Teacherauthority record);

    int insertSelective(Teacherauthority record);

    Teacherauthority selectByPrimaryKey(Integer taLevel);

    int updateByPrimaryKeySelective(Teacherauthority record);

    int updateByPrimaryKey(Teacherauthority record);
    
    List<Teacherauthority> selectAll();
}