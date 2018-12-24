package cn.edu.hziee.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.edu.hziee.model.Manager;
@Mapper
public interface ManagerMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}