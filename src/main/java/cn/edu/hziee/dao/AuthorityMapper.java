package cn.edu.hziee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.edu.hziee.model.Authority;
@Mapper
public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer auId);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer auId);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
    
    List<Authority> selectAll();
}