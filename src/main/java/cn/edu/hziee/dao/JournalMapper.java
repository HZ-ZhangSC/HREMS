package cn.edu.hziee.dao;

import cn.edu.hziee.model.Journal;

public interface JournalMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(Journal record);

    int insertSelective(Journal record);

    Journal selectByPrimaryKey(Integer jId);

    int updateByPrimaryKeySelective(Journal record);

    int updateByPrimaryKey(Journal record);
}