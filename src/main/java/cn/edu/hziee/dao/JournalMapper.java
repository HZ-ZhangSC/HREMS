package cn.edu.hziee.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.edu.hziee.model.Journal;
@Mapper
public interface JournalMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(Journal record);

    int insertSelective(Journal record);

    Journal selectByPrimaryKey(Integer jId);

    int updateByPrimaryKeySelective(Journal record);

    int updateByPrimaryKey(Journal record);
}