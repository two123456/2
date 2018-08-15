package com.superhero.netctoos.loginfomag.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.superhero.netctoos.bean.LogInfoBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.loginfomag.queryservice.ILoginfoQueryService;
import com.superhero.netctoos.util.DateCast;

@RequestMapping(value="/loginfo")
@Controller
public class LoginfoController {
	@Resource
	private ILoginfoQueryService loginfoQueryServiceImpl;
	
	@RequestMapping("/write")
	public void register(HttpServletResponse res,HttpServletRequest req) throws Exception{
		ObjectMapper om=new ObjectMapper();

		Long dailyId=Long.parseLong(req.getParameter("id"));
		

		
		LogInfoBean logInfo=loginfoQueryServiceImpl.getLogInfoByLogDailyId(dailyId);
			
		
			om.writeValue(res.getWriter(), logInfo.getDailyInfo());
	}
}
