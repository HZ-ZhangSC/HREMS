package cn.edu.hziee.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.edu.hziee.model.Scores;

@Mapper
public interface ScoresMapper {
    int deleteByPrimaryKey(Integer scId);

    int insert(Scores record);

    int insertSelective(Scores record);

    Scores selectByPrimaryKey(Integer scId);

    int updateByPrimaryKeySelective(Scores record);

    int updateByPrimaryKey(Scores record);

	Scores selectByKh(Integer scEid);
}