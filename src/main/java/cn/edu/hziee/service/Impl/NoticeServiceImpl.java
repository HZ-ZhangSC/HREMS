package cn.edu.hziee.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hziee.dao.NoticeMapper;
import cn.edu.hziee.model.Notice;
import cn.edu.hziee.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeMapper noticemapper;

	@Override
	public List<Notice> selectAll() {
		List<Notice> notices=noticemapper.selectAll();
		return notices;
	}

	@Override
	public void addNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticemapper.insert(notice);
	}
	
}
