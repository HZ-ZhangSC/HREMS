package cn.edu.hziee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.edu.hziee.model.Notice;
@Mapper
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer noId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
    
    List<Notice> selectAll();
}