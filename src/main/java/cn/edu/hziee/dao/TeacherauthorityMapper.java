package cn.edu.hziee.dao;

import cn.edu.hziee.model.Teacherauthority;

public interface TeacherauthorityMapper {
    int deleteByPrimaryKey(Integer taLevel);

    int insert(Teacherauthority record);

    int insertSelective(Teacherauthority record);

    Teacherauthority selectByPrimaryKey(Integer taLevel);

    int updateByPrimaryKeySelective(Teacherauthority record);

    int updateByPrimaryKey(Teacherauthority record);
}