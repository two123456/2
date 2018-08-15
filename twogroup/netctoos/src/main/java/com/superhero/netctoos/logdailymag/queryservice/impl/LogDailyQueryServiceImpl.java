package com.superhero.netctoos.logdailymag.queryservice.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.logdailymag.dao.ILogDailyDao;
import com.superhero.netctoos.logdailymag.queryservice.ILogdailyQueryService;
@Service
public class LogDailyQueryServiceImpl implements ILogdailyQueryService {
@Resource
	private ILogDailyDao logDailyDaoImpl;
	@Override
	public PageBean getLogDailyByTime(Date startTime, Date endTime, PageBean page) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		return logDailyDaoImpl.getLogDailyByTime(map, page);
	}

}
