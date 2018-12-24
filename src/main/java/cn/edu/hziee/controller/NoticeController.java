package cn.edu.hziee.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hziee.model.Notice;
import cn.edu.hziee.service.NoticeService;
import cn.edu.hziee.service.TeacherService;
import cn.edu.hziee.utils.ResultData;

@RestController
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	TeacherService teacherService;
	@Autowired
	NoticeService noticeService;

	private static final Logger log = LoggerFactory.getLogger(NoticeController.class);

	//公告查看
		@RequestMapping(value="/noticeout",method=RequestMethod.GET)
		public String noticeout(HttpServletRequest request,HttpServletResponse response){
		List<Notice> noticing = noticeService.selectAll();
		ResultData<List<Notice>> res=new ResultData<List<Notice>>();
		res.setData(noticing);
		return res.toString();
		}
		
		//公告录入
		@RequestMapping(value="/noticein",method=RequestMethod.POST)
		public String noticein(@RequestBody Notice not,HttpSession session)throws Exception{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		not.setNoDate(date);
		System.out.print(not);
		noticeService.addNotice(not);
		ResultData<Notice> resData = new ResultData<Notice>();
		resData.setMsg("录入成功");
		resData.setData(not);
		resData.setStatus(true);
		return resData.toString();
		}
	
	
}