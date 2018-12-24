package cn.edu.hziee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hziee.model.Tests;
import cn.edu.hziee.service.TestService;
import cn.edu.hziee.utils.ResultData;

@RestController
@RequestMapping("test")
public class TestInfoController {
	
	
	@Autowired
	
	TestService testService;
	
	private static final Logger log = LoggerFactory.getLogger(TestInfoController.class);

	//添加考试信息，即发布考试报名
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String addTest(@RequestBody Tests test) {
		ResultData<Tests> resData = new ResultData<Tests>();
		Tests testInfo = testService.addTestInfo(test);
		resData.setStatus(true);
		resData.setData(test);
		resData.setMsg("添加考试成功");
		log.info("考试添加成功");
		return resData.toString();
	}
	
	//删除考场
		@RequestMapping(value="/delete",method=RequestMethod.GET)
		public String deleteTestRoom(@RequestParam Integer tsId){
			ResultData<Tests> resData = new ResultData<Tests>();
			int flag = testService.deleteTestInfo(tsId);
			if(flag==1){
				resData.setStatus(true);
				resData.setData(null);
				resData.setMsg("考试删除成功");
				log.info("考试删除成功");
				return resData.toString();
			}else{
				resData.setStatus(false);
				resData.setData(null);
				resData.setMsg("考试删除失败");
				log.info("考试删除失败");
				return resData.toString();
			}
		}
	
		//根据考试id查询考试信息
		@RequestMapping(value="/searchByTsid",method=RequestMethod.GET)
		public String searchTestInfo(@RequestParam("tsid") Integer tsid){
			ResultData<Tests> resData = new ResultData<Tests>();
			Tests testInfo = testService.searchTestInfoById(tsid);
			if(testInfo!=null){
				resData.setStatus(true);
				resData.setData(testInfo);
				resData.setMsg("考试查询成功");
				log.info("考试查询成功");
				return resData.toString();
			}else{
				resData.setStatus(false);
				resData.setData(null);
				resData.setMsg("考场查询失败");
				log.info("考场查询失败");
				return resData.toString();
			}
		}
		
		//编辑考试信息
		//更新考试名称、考场容量、考试时间、考试描述、状态等
		@RequestMapping(value="/update",method=RequestMethod.POST)
		public String updateTestRoom(@RequestBody Tests test){
			ResultData<Tests> resData = new ResultData<Tests>();
			int flat = testService.updateTestInfo(test);
			Tests testInfo = testService.searchTestInfoById(test.getTsId());
			if(flat==1){
				resData.setStatus(true);
				resData.setData(testInfo);
				resData.setMsg("考试信息更新成功");
				log.info("考试信息更新成功");
				return resData.toString();
			}else{
				resData.setStatus(false);
				resData.setData(null);
				resData.setMsg("考试信息更新失败");
				log.info("考试信息更新失败");
				return resData.toString();
			}
		}
		//查询考试信息
		@RequestMapping(value="/searchAll",method=RequestMethod.GET)
		public String searchAll(){
			ResultData<List<Tests>> resData = new ResultData<List<Tests>>();
			List<Tests> testinfo = testService.searchTestsInfoAll();
			resData.setStatus(true);
			resData.setData(testinfo);
			resData.setMsg("信息获取成功");
			return resData.toString();
		}
}
