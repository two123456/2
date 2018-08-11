package com.superhero.netctoos.loginfomag.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.bean.LogInfoBean;
import com.superhero.netctoos.loginfomag.dao.ILogInfoDao;
import com.superhero.netctoos.loginfomag.mapper.LoginfoMapper;
@Repository
public class LogInfoDaoImpl implements ILogInfoDao {
@Resource
	private LoginfoMapper logInfoMapper;
	@Override
	public LogInfoBean getLogInfoByLogDailyId(Long logDaylyId) {
		// TODO Auto-generated method stub
		return logInfoMapper.getLogInfoById(logDaylyId);
	}

}
