package com.superhero.netctoos.logdailymag.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.logdailymag.queryservice.ILogdailyQueryService;
import com.superhero.netctoos.util.DateCast;


@RequestMapping(value="/logDaily")
@Controller
public class LogDailyController {
	@Resource
	private ILogdailyQueryService logDailyQueryServiceImpl;
	
	@RequestMapping("/write")
	public void register(HttpServletResponse res,HttpServletRequest req,String page,String limit) throws Exception{
		ObjectMapper om=new ObjectMapper();
		
		Date startTime=DateCast.sqlDateChange(req.getParameter("keyword[startDate]"));
		Date endTime=DateCast.sqlDateChange(req.getParameter("keyword[endDate]"));

		PageBean pager=new PageBean();
		pager.setLimit(Integer.parseInt(limit));
		pager.setPage(Integer.parseInt(page));
		PageBean pager1=new PageBean();
		pager1=logDailyQueryServiceImpl.getLogDailyByTime(startTime, endTime, pager);
			
		
			om.writeValue(res.getWriter(), pager1);
	}
}
