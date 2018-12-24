package cn.edu.hziee.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

import cn.edu.hziee.model.Ems;

@Mapper
public interface EmsMapper {
	int deleteByPrimaryKey(Integer erId);

	int insert(Ems record);

	int insertSelective(Ems record);

	Ems selectByPrimaryKey(Integer erId);

	int updateByPrimaryKeySelective(Ems record);

	int updateByPrimaryKey(Ems record);

	List<Ems> selectByTsid(Integer erTsid);

	List<Ems> selectByKeys(@Param("begin") Date begin, @Param("end") Date end,
			 @Param("status") int status, @Param("tsName") String tsName);

	List<Ems> selectAll();


}