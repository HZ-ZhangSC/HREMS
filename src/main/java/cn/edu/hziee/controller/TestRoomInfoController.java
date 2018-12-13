package cn.edu.hziee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Matchers.intThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.edu.hziee.model.Ems;
import cn.edu.hziee.model.Tests;
import cn.edu.hziee.service.StudentService;
import cn.edu.hziee.service.TestRoomService;
import cn.edu.hziee.service.TestService;
import cn.edu.hziee.utils.ResultData;

@RestController
@RequestMapping("/testRoom")
//考场管理
public class TestRoomInfoController {

	@Autowired
	StudentService studentService;

	@Autowired
	TestRoomService testRoomService;

	@Autowired
	TestService testService;

	private static final Logger log = LoggerFactory.getLogger(TestRoomInfoController.class);



	//添加考场
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addTestRoom(@RequestBody Ems ems){
		ResultData<Ems> resData = new ResultData<Ems>();
		Ems testRoom = testRoomService.addTestRoom(ems);
		if(testRoomService.getTestRoomInfoById(testRoom.getErId())!=null){
			resData.setStatus(true);
			resData.setData(testRoom);
			resData.setMsg("考场添加成功");
			log.info("考场: "+testRoom.getErName()+" 考试时间："+testRoom.getErTime()+"==>添加");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考场添加失败");
			log.info("考场添加失败");
			return resData.toString();
		}
	}

	//删除考场
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteTestRoom(@RequestParam Integer erId){
		ResultData<Ems> resData = new ResultData<Ems>();
		int flag = testRoomService.deleteTestRoom(erId);
		if(flag==1){
			resData.setStatus(true);
			resData.setData(null);
			resData.setMsg("考场删除成功");
			log.info("考场删除成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考场删除失败");
			log.info("考场删除失败");
			return resData.toString();
		}
	}

	//根据考试id查询考场
	@Cacheable(value="EMSCashe")
	@RequestMapping(value="/searchByTsid",method=RequestMethod.GET)
	public String searchTestRoom(@RequestParam("Tsid") Integer tsid){
		ResultData<List<Ems>> resData = new ResultData<List<Ems>>();
		List<Ems> testRooms = testRoomService.searchTestRoom(tsid);
		if(testRooms!=null){
			resData.setStatus(true);
			resData.setData(testRooms);
			resData.setMsg("考场查询成功");
			log.info("考场查询成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考场查询失败");
			log.info("考场查询失败");
			return resData.toString();
		}
	}


	//根据考试时间、考试状态、以及考试名称等查询考场,前端所有参数都要传过来
	@Cacheable(value="EMSCashe")
	@RequestMapping(value="/searchByKeys",method=RequestMethod.GET)
	public String searchTestRoomByKeys(@RequestParam("begin") String begin,@RequestParam("end") String end, 
			@RequestParam("status") int status, @RequestParam("tsName") String tsName) throws ParseException{
		ResultData<List<Ems>> resData = new ResultData<List<Ems>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = sdf.parse(begin);;
		Date endDate = sdf.parse(end);
		List<Ems> testRooms = testRoomService.searchTestRoomByKeys(beginDate,endDate,status,tsName);
		if(testRooms!=null){
			resData.setStatus(true);
			resData.setData(testRooms);
			resData.setMsg("考场查询成功");
			log.info("考场查询成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考场查询失败");
			log.info("考场查询失败");
			return resData.toString();
		}
	}


	//编辑考场信息
	//更新考试名称、考场容量、考试时间、考试教室
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateTestRoom(@RequestBody Ems ems){
		ResultData<Ems> resData = new ResultData<Ems>();
		int flat = testRoomService.updateTestRoom(ems);
		Ems testRoom = testRoomService.getTestRoomInfoById(ems.getErId());
		if(flat==1){
			resData.setStatus(true);
			resData.setData(testRoom);
			resData.setMsg("考场信息更新成功");
			log.info("考场信息更新成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考场信息更新失败");
			log.info("考场信息更新失败");
			return resData.toString();
		}
	}

}
