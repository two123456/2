package com.superhero.netctoos.loginfomag.queryservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.LogInfoBean;
import com.superhero.netctoos.loginfomag.dao.ILogInfoDao;
import com.superhero.netctoos.loginfomag.queryservice.ILoginfoQueryService;
@Service
public class LoginfoQueryServiceImpl implements ILoginfoQueryService {
@Resource
	private ILogInfoDao logInfoDaoImpl;
	@Override
	public LogInfoBean getLogInfoByLogDailyId(Long logDaylyId) {
		// TODO Auto-generated method stub
		return logInfoDaoImpl.getLogInfoByLogDailyId(logDaylyId);
	}

}
