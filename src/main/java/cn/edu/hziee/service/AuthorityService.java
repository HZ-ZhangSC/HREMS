package cn.edu.hziee.service;



import java.util.List;


import cn.edu.hziee.model.Authority;
public interface AuthorityService {
	List<Authority> searchAuthorityAll();
	
	Authority searchAuthorityById(Integer id);
         
}
