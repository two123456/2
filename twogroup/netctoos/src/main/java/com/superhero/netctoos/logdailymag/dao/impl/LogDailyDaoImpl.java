package com.superhero.netctoos.logdailymag.dao.impl;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.logdailymag.dao.ILogDailyDao;
import com.superhero.netctoos.logdailymag.mapper.LogdailyMapper;
@Repository
public class LogDailyDaoImpl implements ILogDailyDao {
	@Resource
   private LogdailyMapper logdailyMapper;
	@Override
	public PageBean getLogDailyByTime(Map map, PageBean page) {
		// TODO Auto-generated method stub

		page.setCount(logdailyMapper.countLogDaily(map));
		map.put("page", (page.getPage()-1)*page.getLimit());
		map.put("each_Num",page.getLimit());
		page.setData(logdailyMapper.getLogDailyBeanByStartTimeAndEndTime(map));
		return page;
	}

}
