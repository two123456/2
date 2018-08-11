package com.superhero.netctoos.logdailymag.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.logdailymag.queryservice.ILogdailyQueryService;


@RequestMapping(value="/logDaily")
@Controller
public class LogDailyController {
	@Resource
	private ILogdailyQueryService logdailyQueryServiceImpl;
	
	@RequestMapping("/write")
	public void register(String page,String limit) throws Exception{
//		ObjectMapper om=new ObjectMapper();
//		Date startTime=req.ge 
			
//		PageBean pager=logdailyQueryServiceImpl.getLogDailyByTime(startTime, endTime, page);
			
		
//			om.writeValue(res.getWriter(), pager);
	}
}
