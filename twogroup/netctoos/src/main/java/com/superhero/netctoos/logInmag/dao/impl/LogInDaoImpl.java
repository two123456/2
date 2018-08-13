package com.superhero.netctoos.logInmag.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.bean.LogInBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.logInmag.dao.ILogInDao;
import com.superhero.netctoos.logInmag.mapper.LogInMapper;

/**
 * 
 * @author xiasuiying
 *
 */
@Repository
public class LogInDaoImpl implements ILogInDao{
    @Resource
	private LogInMapper logInMapper;
	@Override
	public PageBean getLogInBeanByTime(Map map,PageBean page) {
		// TODO Auto-generated method stub
	
		page.setCount(logInMapper.countLogIn(map));
		map.put("page",(page.getPage()-1)*page.getLimit());
		map.put("each_Num", page.getLimit());
		page.setData(logInMapper.getLogInBeanByStartTimeAndEndTime(map));
		return page;
	}

}
