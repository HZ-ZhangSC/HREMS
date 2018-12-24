package cn.edu.hziee.controller;
import java.io.UnsupportedEncodingException; 

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hziee.model.Manager;
import cn.edu.hziee.model.Student;
import cn.edu.hziee.service.ManagerService;
import cn.edu.hziee.service.StudentService;
import cn.edu.hziee.utils.Md5;
import cn.edu.hziee.utils.ResultData;
@RestController
@RequestMapping("/manager")
public class ManagerInfoController {
	@Autowired
	ManagerService managerService;
	
	private static final Logger log = LoggerFactory.getLogger(ManagerInfoController.class);



	//登录 传入mId和mPwd
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestBody Manager manager,HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Manager> resData = new ResultData<Manager>();
		Integer mzid = manager.getmZid();
		String password = manager.getmPwd();
		Manager manInfo = managerService.searchManagerInfoById(mzid);
		Md5 md5 = new Md5();
		if(md5.checkpassword(password,manInfo.getmPwd())){
			resData.setStatus(true);
			resData.setData(manInfo);
			resData.setMsg("管理员登录成功");
			log.info("管理员: "+manInfo.getmId()+" "+manInfo.getmName()+"==>登录");
			session.setAttribute("manInfo", manInfo);
			System.out.print(session.getAttribute("manInfo"));
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("登录失败");
			return resData.toString();
		}		
	}
	
		//退出登录
		@RequestMapping(value="/logout",method=RequestMethod.GET)
		public String logout(HttpSession session){
			ResultData<Manager> resData = new ResultData<Manager>();
			Manager man = (Manager) session.getAttribute("manInfo");
			log.info("管理员: "+man.getmId()+" "+man.getmName()+"==>登出");
			session.removeAttribute("manInfo");
			resData.setStatus(true);
			resData.setData(null);
			resData.setMsg("登出成功");
			return resData.toString();
		}
		
		//添加学生
		@RequestMapping(value="/add",method=RequestMethod.GET)
		public String addstudent(@RequestBody Manager manager,HttpServletRequest request)throws NoSuchAlgorithmException, UnsupportedEncodingException{
			ResultData<Manager> resData = new ResultData<Manager>();
			Md5 md5 = new Md5();
			manager.setmPwd(md5.EncodeByMd5("123456"));
			String message = managerService.addManagerInfo(manager);
			resData.setStatus(true);
			resData.setData(null);
			resData.setMsg("添加成功");
			return resData.toString();
		}
		
		//获得登录管理员信息
		@RequestMapping(value="/getLoginManagerInfo",method=RequestMethod.GET)
		public String getLogin(HttpSession session) {
			ResultData<Manager> resData = new ResultData<Manager>();
			if(session.getAttribute("manInfo") != null){
				Manager manageInfo = (Manager) session.getAttribute("manInfo");
				resData.setStatus(true);
				resData.setData(manageInfo);
				resData.setMsg("登录管理员信息获取成功");
				log.info("获取管理员信息成功");
				return resData.toString();
			}else{
				resData.setStatus(false);
				resData.setData(null);
				resData.setMsg("获取登录用户信息失败");
				return resData.toString();
			}		
		}

		
}
