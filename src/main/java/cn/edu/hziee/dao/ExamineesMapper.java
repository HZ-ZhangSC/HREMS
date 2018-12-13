package cn.edu.hziee.dao;

import cn.edu.hziee.model.Examinees;

public interface ExamineesMapper {
    int deleteByPrimaryKey(Integer eEid);

    int insert(Examinees record);

    int insertSelective(Examinees record);

    Examinees selectByPrimaryKey(Integer eEid);

    int updateByPrimaryKeySelective(Examinees record);

    int updateByPrimaryKey(Examinees record);
}