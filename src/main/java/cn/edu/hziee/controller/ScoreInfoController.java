package cn.edu.hziee.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

import cn.edu.hziee.model.Examinees;
import cn.edu.hziee.model.Scores;
import cn.edu.hziee.model.Student;
import cn.edu.hziee.model.Teachers;
import cn.edu.hziee.service.ExamineesService;
import cn.edu.hziee.service.ScoresService;
import cn.edu.hziee.service.StudentService;
import cn.edu.hziee.utils.ResultData;

@RestController
@RequestMapping("/score")
public class ScoreInfoController {

	@Autowired
	ScoresService scoresService;

	@Autowired
	ExamineesService examineesService;

	@Autowired
	StudentService studentService;

	//查询
	@RequestMapping(value="/getScore",method=RequestMethod.POST)
	public String selectR(@RequestBody Scores scores,HttpSession session)throws Exception{
		ResultData<Scores> resData = new ResultData<Scores>();
		Scores stu = scoresService.searchScoresInfoByEid(scores.getScEid());  
		resData.setStatus(true);
		resData.setData(stu);
		resData.setMsg("查询成功");
		System.out.println(stu);
		System.out.println(resData);
		return resData.toString();
	}

	//查询
	@RequestMapping(value="/searchAll",method=RequestMethod.GET)
	public String selectAll()throws Exception{
		ResultData<List<Scores>> resData = new ResultData<List<Scores>>();
		List<Scores> stu = scoresService.searchAllScores();  
		resData.setStatus(true);
		resData.setData(stu);
		resData.setMsg("查询成功");
		System.out.println(stu);
		System.out.println(resData);
		return resData.toString();
	}

	//查询
	//			@Cacheable(value = "teacherInfocache")
	//			@RequestMapping(value="/getScore",method=RequestMethod.POST)
	//			public String selectR(@RequestBody Scores scores,HttpSession session)throws Exception{
	//				Teachers tea = (Teachers) session.getAttribute("teaInfo");
	//				Student student = (Student) session.getAttribute("stuInfo");
	//				ResultData<Scores> resData = new ResultData<Scores>();
	//				if(tea!=null){
	//					Scores stu = scoresService.searchScoresInfoByEid(scores.getScEid());
	//					System.out.println(scores);
	//					resData.setStatus(true);
	//					resData.setData(stu);
	//					resData.setMsg("查询成功");
	//				}else if(student!=null){
	//					Scores stu = scoresService.searchScoresInfoByEid(scores.getScEid());
	//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	//					Calendar calendar = Calendar.getInstance();  
	//				    Date date = calendar.getTime();  
	//				    if(stu.getScDate().before(date)){
	//				    	resData.setStatus(true);
	//						resData.setData(stu);
	//						resData.setMsg("查询成功");
	//				    }
	//				}else{
	//					resData.setStatus(false);
	//					resData.setData(null);
	//					resData.setMsg("查询失败");
	//				}
	//				return resData.toString();
	//			}

	//插入成绩
	//	@Cacheable(value = "teacherInfocache")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String setScore(@RequestBody Scores s) throws Exception{
		//		Teachers tea = (Teachers) session.getAttribute("teaInfo");
		Scores score = new Scores();
		ResultData<Scores> resData = new ResultData<Scores>();
		Examinees stu = examineesService.searchExameeByeEid(s.getScEid());
		Student person = studentService.getStudentInfoById(stu.geteSid());
//		String sid = String.valueOf(stu.geteSid());
//		String tid = String.valueOf(stu.geteTid());
//		int scId = Integer.parseInt(sid+tid);
		score.setScSid(stu.geteSid());
		score.setScName(stu.geteTnm());
		score.setScSname(stu.geteName());
		score.setScEid(stu.geteEid());
		score.setScSc(s.getScSc());
		score.setScCs(person.getsClass());
		score.setScTid(stu.geteTid());
//		score.setScId(scId);
		scoresService.insertScore(score);
		if(scoresService.searchScoresInfoByEid(s.getScEid())!=null){
			resData.setStatus(true);
			resData.setData(score);
			resData.setMsg("插入成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("插入失败");
			return resData.toString();
		}
	}


	//更新成绩
	//	@Cacheable(value = "teacherInfocache")
	@RequestMapping(value="/updateScore",method=RequestMethod.POST)
	public String updateS(@RequestBody Scores score,HttpSession session)throws Exception{
		Teachers tea = (Teachers) session.getAttribute("teaInfo");
		ResultData<Scores> resData = new ResultData<Scores>();
		if(tea!=null){
			Scores stu = scoresService.searchScoresInfoByEid(score.getScEid());
			stu.setScSc(score.getScSc());
			scoresService.updateScore(stu);
			resData.setStatus(true);
			resData.setData(stu);
			resData.setMsg("更新成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("更新成功");
			return resData.toString();
		}
	}

	//删除成绩
	//	@Cacheable(value = "teacherInfocache")
	@RequestMapping(value="/deleteScore",method=RequestMethod.POST)
	public String deleteScore(@RequestBody Scores score,HttpSession session) throws Exception{
		Teachers tea = (Teachers) session.getAttribute("teaInfo");
		ResultData<Scores> resData = new ResultData<Scores>();
		if(tea!=null){
			scoresService.deleteScoresInfoByEid(score.getScEid());
			resData.setStatus(true);
			resData.setData(null);
			resData.setMsg("删除成功");
			return resData.toString();
		}else{
			resData.setStatus(false);
			resData.setData(null);
			resData.setMsg("删除失败");
			return resData.toString();
		}
	}

}

