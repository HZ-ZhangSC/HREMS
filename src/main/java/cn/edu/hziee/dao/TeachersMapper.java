package cn.edu.hziee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.edu.hziee.model.Student;
import cn.edu.hziee.model.Teachers;
@Mapper
public interface TeachersMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    Teachers selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Teachers record);

    int updateByPrimaryKey(Teachers record);
    
    List<Teachers> selectAll();
    
    List<Teachers> selectByName(String tName);
    
    int updatePassword(Teachers record);
    int updateRt(Teachers record);
}