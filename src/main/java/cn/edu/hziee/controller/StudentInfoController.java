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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.hziee.model.Manager;
import cn.edu.hziee.model.Student;
import cn.edu.hziee.model.Teachers;
import cn.edu.hziee.service.StudentService;
import cn.edu.hziee.utils.Md5;
import cn.edu.hziee.utils.ResultData;

@RestController
@RequestMapping("/student")
public class StudentInfoController {

	@Autowired
	StudentService studentService;
	
	private static final Logger log = LoggerFactory.getLogger(StudentInfoController.class);



	//登录 传入sId和sPwd
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestBody Student student,HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Student> resData = new ResultData<Student>();
		Integer sid = student.getsId();
		String password = student.getsPwd();
		Student stuInfo = studentService.searchStudentInfoById(sid);
		Md5 md5 = new Md5();
		if(md5.checkpassword(password,stuInfo.getsPwd())){
			resData.setStatus(true);
			resData.setData(stuInfo);
			resData.setMsg("学生登录成功");
			log.info("学生: "+stuInfo.getsId()+" "+stuInfo.getsName()+"==>登录");
			session.setAttribute("stuInfo", stuInfo);
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("密码错误");
			return resData.toString();
		}		
	}
	
	//获得登录学生的信息
	@RequestMapping(value="/loginStudent",method=RequestMethod.GET)
	public String loginStu(HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Student> resData = new ResultData<Student>();
		Student stu = (Student) session.getAttribute("stuInfo");
		resData.setStatus(true);
		resData.setData(stu);
		resData.setMsg("get成功");
		return resData.toString();
	}
	
		//退出登录
		@RequestMapping(value="/studentlogout",method=RequestMethod.GET)
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
	//根据学号查询学生信息
	@RequestMapping(value="/searchByid",method=RequestMethod.GET)
	public String searchByid(@RequestBody Integer data)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Student> resData = new ResultData<Student>();
		Student stuInfo = studentService.searchStudentInfoById(data);
		resData.setStatus(true);
		resData.setData(stuInfo);
		resData.setMsg("信息获取成功");
		return resData.toString();
	}
	@RequestMapping(value="/searchAll",method=RequestMethod.GET)
	public String searchAll(){
		ResultData<List<Student>> resData = new ResultData<List<Student>>();
		List<Student> stuInfo = studentService.searchStudentInfoAll();
		resData.setStatus(true);
		resData.setData(stuInfo);
		resData.setMsg("信息获取成功");
		return resData.toString();
	}
	@RequestMapping(value="/searchByName",method=RequestMethod.POST)
	public String searchByName(@RequestBody Student stu)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<List<Student>> resData = new ResultData<List<Student>>();
		List<Student> stuInfo = studentService.searchStudentInfoByName(stu.getsName());
		resData.setStatus(true);
		resData.setData(stuInfo);
		resData.setMsg("信息获取成功");
		return resData.toString();
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addstudent(@RequestBody Student student)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Student> resData = new ResultData<Student>();
		Md5 md5 = new Md5();
		student.setsPwd(md5.EncodeByMd5("123456"));
		String message = studentService.addStudentInfo(student);
		resData.setStatus(true);
		resData.setData(null);
		resData.setMsg("添加成功");
		return resData.toString();
	}
	@RequestMapping(value="/updatePassword",method=RequestMethod.POST)//学生只能改密码
	public String updatestudent(@RequestBody Student student)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Student> resData = new ResultData<Student>();
		Md5 md5 = new Md5();
		student.setsPwd(md5.EncodeByMd5(student.getsPwd()));
		String message = studentService.updatePassword(student);
		resData.setStatus(true);
		resData.setData(null);
		resData.setMsg("修改成功");
		return resData.toString();
	}
	@RequestMapping(value="/reset",method=RequestMethod.POST)//重置密码
	public String reset() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Student> resData = new ResultData<Student>();
		Md5 md5 = new Md5();
		Student student = new Student();
		student.setsPwd(md5.EncodeByMd5("123456"));
		String message = studentService.updatePassword(student);
		resData.setStatus(true);
		resData.setData(null);
		resData.setMsg("修改成功");
		return resData.toString();
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)//管理员用的
	public String update(@RequestBody Student student)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		ResultData<Student> resData = new ResultData<Student>();
		String message = studentService.updateStudentInfo(student);
		resData.setStatus(true);
		resData.setData(null);
		resData.setMsg("修改成功");
		return resData.toString();
	}
}
