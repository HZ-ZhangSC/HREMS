package cn.edu.hziee.service;

import java.util.List;

import cn.edu.hziee.model.Notice;

public interface NoticeService {
	
	List<Notice> selectAll();
	
	void addNotice(Notice notice);
}
