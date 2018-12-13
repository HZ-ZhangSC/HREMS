package cn.edu.hziee.dao;

import cn.edu.hziee.model.Authority;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer auId);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer auId);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
}