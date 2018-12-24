package cn.edu.hziee.service.Impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hziee.dao.AuthorityMapper;
import cn.edu.hziee.model.Authority;
import cn.edu.hziee.service.AuthorityService;
  


@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	AuthorityMapper AuthorityMapper;
	
	
	@Override
	public List<Authority> searchAuthorityAll() {
		return AuthorityMapper.selectAll();
	}

	@Override
	public Authority searchAuthorityById(Integer id) {
		
		return AuthorityMapper.selectByPrimaryKey(id);
	}
	

}
