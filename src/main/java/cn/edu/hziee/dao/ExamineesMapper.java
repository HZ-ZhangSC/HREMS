package cn.edu.hziee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.edu.hziee.model.Examinees;

@Mapper
public interface ExamineesMapper {
	int deleteByPrimaryKey(Integer eEid);

    int insert(Examinees record);

    int insertSelective(Examinees record);

    Examinees selectByPrimaryKey(Integer eEid);

    int updateByPrimaryKeySelective(Examinees record);

    int updateByPrimaryKey(Examinees record);

	List<Examinees> selectBySid(Integer sid);

	Examinees selectHistoryTestsBySid(Integer sid);

	List<Examinees> selectAll();

	List<Examinees> selectBySname(String sName);
}