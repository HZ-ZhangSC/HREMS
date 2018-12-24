package cn.edu.hziee.service;
import cn.edu.hziee.model.Manager;
public interface ManagerService {
	Manager searchManagerInfoById(Integer mid);
	
    String addManagerInfo(Manager man);
}
