package cn.edu.hziee.dao;

import cn.edu.hziee.model.Scores; 
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScoresMapper {

    int deleteByPrimaryKey(Integer scId);

    int insert(Scores record);

    int insertSelective(Scores record);

    Scores selectByPrimaryKey(Integer scId);

    int updateByPrimaryKeySelective(Scores record);

    int updateByPrimaryKey(Scores record);
    
    int deleteByKh(Integer eid);

	Scores selectByKh(Integer eid);

	List<Scores> selectAll();
}