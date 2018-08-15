package com.superhero.netctoos.logInmag.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.superhero.netctoos.bean.LogInBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.logInmag.queryservice.ILogInQueryService;
import com.superhero.netctoos.loginfomag.queryservice.ILoginfoQueryService;
import com.superhero.netctoos.util.DateCast;

@RequestMapping(value="/logIn")
@Controller
public class LogInController {
	@Resource
	private ILogInQueryService logInQueryServiceImpl;
	
	@RequestMapping("/write")
	public void register(HttpServletResponse res,HttpServletRequest req,String page,String limit) throws Exception{
		ObjectMapper om=new ObjectMapper();
		
		Date startTime=DateCast.utilDate(req.getParameter("startTime"));
		Date endTime=DateCast.utilDate(req.getParameter("endTime"));
System.out.println(startTime+"  "+endTime);
		PageBean pager=new PageBean();
		pager.setLimit(Integer.parseInt(limit));
		pager.setPage(Integer.parseInt(page));
		PageBean pager1=new PageBean();
		pager1=logInQueryServiceImpl.getLogInBeanByTime(startTime, endTime, pager);
		
		
			om.writeValue(res.getWriter(), pager1);
	}

}
