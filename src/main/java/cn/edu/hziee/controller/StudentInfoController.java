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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hziee.model.Scores;
import cn.edu.hziee.model.Student;
import cn.edu.hziee.service.ScoresService;
import cn.edu.hziee.service.StudentService;
import cn.edu.hziee.utils.Md5;
import cn.edu.hziee.utils.ResultData;

@RestController
@RequestMapping("/student")
public class StudentInfoController {

	@Autowired
	StudentService studentService;

	@Autowired
	ScoresService scoresService;

	private static final Logger log = LoggerFactory.getLogger(StudentInfoController.class);



	//登录 传入sId和sPwd
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestBody Student student,HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Student> resData = new ResultData<Student>();
		Integer sid = student.getsId();
		String password = student.getsPwd();
		Student stuInfo = studentService.getStudentInfoById(sid);
		Md5 md5 = new Md5();
		if(md5.checkpassword(password,stuInfo.getsPwd())){
			resData.setStatus(true);
			resData.setData(stuInfo);
			resData.setMsg("学生登录成功");
			log.info("学生: "+stuInfo.getsId()+" "+stuInfo.getsName()+"==>登录");
			HttpSession session = request.getSession(); //创建session
			session.setAttribute("stuInfo", stuInfo);
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("密码错误");
			return resData.toString();
		}		
	}

	//退出登录
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session){
		ResultData<Student> resData = new ResultData<Student>();
		Student stu = (Student) session.getAttribute("stuInfo");
		log.info("学生: "+stu.getsId()+" "+stu.getsName()+"==>登出");
		session.removeAttribute("stuInfo");
		resData.setStatus(true);
		resData.setData(null);
		resData.setMsg("登出成功");
		return resData.toString();
	}

	@Cacheable(value = "studentInfocache")
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(){
		ResultData<Student> resData = new ResultData<Student>();
		Student stuInfo = studentService.getStudentInfoById(16905836);
		resData.setStatus(true);
		resData.setData(stuInfo);
		resData.setMsg("学生信息获取成功成功");
		return resData.toString();
	}

	//查询成绩
	@RequestMapping(value="/getScore",method=RequestMethod.GET)
	public String selectScore(@RequestParam Integer scEid)throws Exception{
		ResultData<Scores> resData = new ResultData<Scores>();
		Scores stu = scoresService.getScoresInfoById(scEid);
		if(stu!=null){
			resData.setStatus(true);
			resData.setData(stu);
			resData.setMsg("查询成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("查询失败");
			return resData.toString();
		}
	}

}
