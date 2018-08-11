package com.superhero.netctoos.logInmag.queryservice.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.logInmag.dao.ILogInDao;
import com.superhero.netctoos.logInmag.queryservice.ILogInQueryService;

@Service
public class LogInQueryServiceImpl implements ILogInQueryService {
@Resource
	private ILogInDao logInDaoImpl;

	@Override
	public PageBean getLogInBeanByTime(Date startTime, Date endTime, PageBean page) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		return logInDaoImpl.getLogInBeanByTime(map, page);
	}
}
