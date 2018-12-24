package cn.edu.hziee.controller;

import java.util.List; 
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hziee.model.Ems;
import cn.edu.hziee.model.Examinees;
import cn.edu.hziee.model.Tests;
import cn.edu.hziee.service.ExamineesService;
import cn.edu.hziee.service.TestRoomService;
import cn.edu.hziee.service.TestService;
import cn.edu.hziee.utils.ResultData;

@RestController
@RequestMapping("examee")
//考生信息和考试报名
public class ExamineesInfoController {

	@Autowired
	ExamineesService examineesService;

	@Autowired
	TestRoomService testRoomService;

	@Autowired
	TestService testService;

	private static final Logger log = LoggerFactory.getLogger(ExamineesInfoController.class);

	//考试报名，即添加考生信息
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addExameeInfo(@RequestBody Examinees examee) {
		ResultData<Examinees> resData = new ResultData<Examinees>();
		Examinees exameeInfo = new Examinees();
		Tests tests = testService.searchTestInfoById(examee.geteTid());
		//考试姓名
		exameeInfo.seteName(examee.geteName());
		//考生学号
		exameeInfo.seteSid(examee.geteSid());
		//考试名称
		exameeInfo.seteTnm(tests.getTsName());
		//考试时间
		exameeInfo.seteTime(tests.getTsDate());
		//考试id
		exameeInfo.seteTid(examee.geteTid());
		//通过考试id获取当前考试的所有考场信息
		List<Ems> testRoomList = testRoomService.searchTestRoom(examee.geteTid());
		Random random = new Random();
		//随机读取某个考场信息
		Ems testRoom = testRoomList.get(random.nextInt(testRoomList.size()));
		String eEid=null;
		if(testRoom.getErNum()<testRoom.getErCp()){
			//考试座位
			exameeInfo.setePlace(Integer.toString(testRoom.getErNum()+1));
			//教室
			exameeInfo.seteClass(testRoom.getErName());
			//生成考号
			eEid = examee.geteTid() + ""+testRoom.getErId()+""+(testRoom.getErNum()+1);
		}else{
			//随机读取某个考场信息
			testRoom = testRoomList.get(random.nextInt(testRoomList.size()));
		}
		int erId = testRoom.getErId();
		int erNum = testRoom.getErNum();
		Ems ems = new Ems();
		ems.setErId(erId);
		ems.setErNum(erNum+1);
		//更新选中考场的信息
		testRoomService.updateTestRoom(ems);
		exameeInfo.seteEid(Integer.parseInt(eEid));//学生准考证号
		Examinees temp = examineesService.addExameeInfo(exameeInfo);
		Examinees data = examineesService.searchExameeByeEid(Integer.parseInt(eEid));
		temp.seteEid(Integer.parseInt(eEid));
		if(data!=null){
			resData.setStatus(true);
			resData.setData(temp);
			resData.setMsg("考生考试报名成功");
			log.info("考生考试报名成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考生考试报名失败");
			log.info("考生考试报名失败");
			return resData.toString();
		}	
	}

	//删除考生信息
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteExameeInfo(@RequestParam Integer eEid){
		ResultData<Examinees> resData = new ResultData<Examinees>();
		int flag = examineesService.deleteExameeInfo(eEid);
		if(flag==1){
			resData.setStatus(true);
			resData.setData(null);
			resData.setMsg("考生报名信息删除成功");
			log.info("报名信息删除成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考生报名信息删除失败");
			log.info("考生报名信息删除失败");
			return resData.toString();
		}
	}

	//查询所有考生信息
	//@Cacheable(value="ExamineeCashe")
	@RequestMapping(value="/searchAll",method=RequestMethod.GET)
	public String searchExameeAll(){
		ResultData<List<Examinees>> resData = new ResultData<>();
		List<Examinees> examees = examineesService.searchExameeAll();
		if(examees!=null){
			resData.setStatus(true);
			resData.setData(examees);
			resData.setMsg("考试报名信息查询成功");
			log.info("考生报名信息查询成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考生报名信息查询失败");
			log.info("考生报名信息查询失败");
			return resData.toString();
		}
	}

	//根据考号查询考试报名信息
	@Cacheable(value="ExamineeCashe")
	@RequestMapping(value="/searchByeEid",method=RequestMethod.GET)
	public String searchExameeByeEid(@RequestParam("eEid") Integer eEid){
		ResultData<Examinees> resData = new ResultData<Examinees>();
		Examinees examee = examineesService.searchExameeByeEid(eEid);
		if(examee!=null){
			resData.setStatus(true);
			resData.setData(examee);
			resData.setMsg("考试报名信息查询成功");
			log.info("考生报名信息查询成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考生报名信息查询失败");
			log.info("考生报名信息查询失败");
			return resData.toString();
		}
	}

	//根据考生学号查询报名信息
	@Cacheable(value="ExamineeCashe")
	@RequestMapping(value="/searchBySid",method=RequestMethod.GET)
	public String searchExameeBySid(@RequestParam("sid") Integer sid){
		ResultData<List<Examinees>> resData = new ResultData<>();
		List<Examinees> examee = examineesService.searchExameeBySid(sid);
		if(examee!=null){
			resData.setStatus(true);
			resData.setData(examee);
			resData.setMsg("考试报名信息查询成功");
			log.info("考生报名信息查询成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考生报名信息查询失败");
			log.info("考生报名信息查询失败");
			return resData.toString();
		}
	}

	//根据考生姓名查询报名信息
	//@Cacheable(value="ExamineeCashe")
	@RequestMapping(value="/searchBySname",method=RequestMethod.GET)
	public String searchExameeBySid(@RequestParam("sName") String sName){
		ResultData<List<Examinees>> resData = new ResultData<>();
		List<Examinees> examee = examineesService.searchExameeBySname(sName);
		if(examee!=null){
			resData.setStatus(true);
			resData.setData(examee);
			resData.setMsg("考试报名信息查询成功");
			log.info("考生报名信息查询成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考生报名信息查询失败");
			log.info("考生报名信息查询失败");
			return resData.toString();
		}
	}

	//修改考生报名信息
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateTestRoom(@RequestBody Examinees examee){
		ResultData<Examinees> resData = new ResultData<Examinees>();
		int flat = examineesService.updateExameeInfo(examee);
		Examinees exameeInfo = examineesService.searchExameeByeEid(examee.geteEid());
		if(flat==1){
			resData.setStatus(true);
			resData.setData(exameeInfo);
			resData.setMsg("考生考试信息更新成功");
			log.info("考生考试信息更新成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("考生考试信息更新失败");
			log.info("考生考试信息更新失败");
			return resData.toString();
		}
	}

}
