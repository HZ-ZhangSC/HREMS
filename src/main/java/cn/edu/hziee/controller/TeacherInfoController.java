package cn.edu.hziee.controller;

import java.io.UnsupportedEncodingException;  

import java.security.NoSuchAlgorithmException;
import java.util.List;

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
import cn.edu.hziee.model.Teachers;
import cn.edu.hziee.service.TeacherService;
import cn.edu.hziee.utils.Md5;
import cn.edu.hziee.utils.ResultData;

@RestController
@RequestMapping("/teacher")
public class TeacherInfoController {

	@Autowired
	TeacherService teacherService;
	
	private static final Logger log = LoggerFactory.getLogger(TeacherInfoController.class);

	//登录 传入tId和tPwd
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public String login(@RequestBody Teachers tea,HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
			ResultData<Teachers> resData = new ResultData<Teachers>();
			Integer tid = tea.gettId();
			String password = tea.gettPwd();
			Teachers teaInfo = teacherService.searchTeacherInfoById(tid);
			Md5 md5 = new Md5();
			if(md5.checkpassword(password,teaInfo.gettPwd())){
				resData.setStatus(true);
				resData.setData(teaInfo);
				resData.setMsg("教师登录成功");
				log.info("教师: "+teaInfo.gettId()+" "+teaInfo.gettName()+"==>登录");
				session.setAttribute("teaInfo", teaInfo);
				return resData.toString();
			}else{
				resData.setStatus(false);
				resData.setData(null);
				resData.setMsg("密码错误");
				return resData.toString();
			}		
		}

	//获得登录教师的信息
	@RequestMapping(value="/getLoginTeacherInfo",method=RequestMethod.GET)
	public String login(HttpSession session) {
		ResultData<Teachers> resData = new ResultData<Teachers>();
		//System.out.println(session.getAttribute("teaInfo"));
		if(session.getAttribute("teaInfo") != null){
			Teachers teaInfo = (Teachers) session.getAttribute("teaInfo");
			resData.setStatus(true);
			resData.setData(teaInfo);
			resData.setMsg("登录教师信息获取成功");
			log.info("获取登录教师信息成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("获取登录用户信息失败");
			return resData.toString();
		}		
	}

	//退出登录
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session){
		ResultData<Teachers> resData = new ResultData<Teachers>();
		Teachers tea = (Teachers) session.getAttribute("teaInfo");
		log.info("教师: "+tea.gettId()+" "+tea.gettName()+"==>登出");
		session.removeAttribute("teaInfo");
		//System.out.println(session.getAttribute("teaInfo"));
		resData.setStatus(true);
		resData.setData(null);
		resData.setMsg("登出成功");
		return resData.toString();
	}
	@Cacheable(value = "teacherInfocache")
	@RequestMapping(value="/searchByid",method=RequestMethod.GET)
	public String searchByid(@RequestBody Integer data)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Teachers> resData = new ResultData<Teachers>();
		Teachers teaInfo = teacherService.searchTeacherInfoById(data);
		resData.setStatus(true);
		resData.setData(teaInfo);
		resData.setMsg("信息获取成功");
		return resData.toString();
	}
//	@Cacheable(value = "teacherInfocache")
	@RequestMapping(value="/searchAll",method=RequestMethod.GET)
	public String searchAll(){
		ResultData<List<Teachers>> resData = new ResultData<List<Teachers>>();
		List<Teachers> teaInfo = teacherService.searchTeacherInfoAll();
		resData.setStatus(true);
		resData.setData(teaInfo);
		resData.setMsg("信息获取成功");
		return resData.toString();
	}
	
	//根据名字查询老师名字
	@Cacheable(value = "teacherInfocache")
	@RequestMapping(value="/searchByName",method=RequestMethod.GET)
	public String searchByname(@RequestBody String data)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<List<Teachers>> resData = new ResultData<List<Teachers>>();
		List<Teachers> teaInfo = teacherService.searchTeacherInfoByName(data);
		resData.setStatus(true);
		resData.setData(teaInfo);
		resData.setMsg("信息获取成功");
		return resData.toString();
	}
	
	//添加老师
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addstudent(@RequestBody Teachers tea)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Teachers> resData = new ResultData<Teachers>();
		Md5 md5 = new Md5();
		tea.settPwd(md5.EncodeByMd5("123456"));
		String message = teacherService.addTeacherInfo(tea);
		resData.setStatus(true);
		resData.setData(null);
		resData.setMsg("添加成功");
		return resData.toString();
	}
	
	//跟新老师信息
	@RequestMapping(value="/update",method=RequestMethod.POST)//管理员修改用
	public String updateteacher(@RequestBody Teachers tea)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Teachers> resData = new ResultData<Teachers>();
		Md5 md5 = new Md5();
		tea.settPwd(md5.EncodeByMd5(tea.gettPwd()));
		String message = teacherService.updateTeacherInfo(tea);
		resData.setStatus(true);
		resData.setData(null);
		resData.setMsg("修改成功");
		return resData.toString();
	}
	
	//更新密码
	@RequestMapping(value="/updatePassword",method=RequestMethod.POST)//教师用的修改密码
	public String updatePassword(@RequestBody Teachers tea)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Teachers> resData = new ResultData<Teachers>();
		Md5 md5 = new Md5();
		tea.settPwd(md5.EncodeByMd5(tea.gettPwd()));
		String message = teacherService.updatePassword(tea);
		resData.setStatus(true);
		resData.setData(null);
		resData.setMsg("修改成功");
		return resData.toString();
	}
	@RequestMapping(value="/reset",method=RequestMethod.POST)//重置密码
	public String resetPassword(@RequestBody Teachers tea)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Teachers> resData = new ResultData<Teachers>();
		Md5 md5 = new Md5();
		tea.settPwd(md5.EncodeByMd5("123456"));
		String message = teacherService.updatePassword(tea);
		resData.setStatus(true);
		resData.setData(null);
		resData.setMsg("修改成功");
		return resData.toString();
	}
	@RequestMapping(value="/updateRt",method=RequestMethod.POST)//权限等级修改
	public String resetRt(@RequestBody Teachers tea)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Teachers> resData = new ResultData<Teachers>();
		String message = teacherService.updateRt(tea);
		resData.setStatus(true);
		resData.setData(null);
		resData.setMsg("修改成功");
		return resData.toString();
	}
}
