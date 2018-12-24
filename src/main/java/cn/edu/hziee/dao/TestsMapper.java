package cn.edu.hziee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.edu.hziee.model.Tests;

@Mapper
public interface TestsMapper {
    int deleteByPrimaryKey(Integer tsId);

    int insert(Tests record);

    int insertSelective(Tests record);

    Tests selectByPrimaryKey(Integer tsId);

    int updateByPrimaryKeySelective(Tests record);

    int updateByPrimaryKey(Tests record);
    
    List<Tests> selectAll();
    
    List<Tests> selectByName(String tsName);
}