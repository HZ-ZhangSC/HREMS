package cn.edu.hziee.controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

import cn.edu.hziee.model.Authority;
import cn.edu.hziee.model.Student;
import cn.edu.hziee.model.Teacherauthority;
import cn.edu.hziee.service.AuthorityService;
import cn.edu.hziee.service.TeacherauthorityService;
import cn.edu.hziee.utils.Md5;
import cn.edu.hziee.utils.ResultData;

@RestController
@RequestMapping("/TeacherAuthority")
public class TeacherauthorityController {
	@Autowired
	TeacherauthorityService teacherauthorityService;
	@Autowired
	AuthorityService authorityService;
	private static final Logger log = LoggerFactory.getLogger(TeacherauthorityController.class);
	
	//查询所有的教师信息
	@RequestMapping(value="/selectAll",method=RequestMethod.GET)
	public String selectAll(){
		ResultData<List<Teacherauthority>> resData = new ResultData<List<Teacherauthority>>();
		List<Teacherauthority> ta= teacherauthorityService.searchTeacherauthorityAll();
		List<Teacherauthority> ta1= new ArrayList();
		for(Teacherauthority attribute : ta) {
            Teacherauthority obj = attribute;
            String message = obj.getTaContent();
            String[] as = message.split(",");
    		String a="";
    		for(int i =0;i<as.length;i++){
    			Authority au = authorityService.searchAuthorityById(Integer.parseInt(as[i]));
    			a=a+au.getAuName()+" ";
    		}
    		obj.setTaContent(a);
    		ta1.add(obj);
         }
		resData.setData(ta);
		return resData.toString();
	}
	
	//根据id查询老师信息
	@RequestMapping(value="/selectById",method=RequestMethod.GET)	
	public String selectById(@RequestParam("id")Integer id){
		ResultData<String> resData = new ResultData<String>();
		Teacherauthority ta = teacherauthorityService.searchTeacherauthorityById(id);
		String message=ta.getTaContent();
		String[] as = message.split(",");
     	String a="";
		for(int i =0;i<as.length;i++){
			Authority au = authorityService.searchAuthorityById(Integer.parseInt(as[i]));
			a=a+au.getAuName()+" ";
		}
		resData.setStatus(true);
		resData.setData(a);
		resData.setMsg("信息获取成功");
		return resData.toString();
	}
	
	

}
