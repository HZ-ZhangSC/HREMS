package cn.edu.hziee.dao;

import cn.edu.hziee.model.Teachers;

public interface TeachersMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    Teachers selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Teachers record);

    int updateByPrimaryKey(Teachers record);
}