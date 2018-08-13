package com.superhero.netctoos.loginfomag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.LogInfoBean;
import com.superhero.netctoos.loginfomag.handleservice.ILoginfoHandleService;
import com.superhero.netctoos.loginfomag.repository.ILogInfoRepository;
@Service
public class LogInfoHandleServiceImpl implements ILoginfoHandleService {
@Resource
	private ILogInfoRepository logInfoRepository;
	@Override
	public void saveLogInfoBean(LogInfoBean logInfo) {
		// TODO Auto-generated method stub
		logInfoRepository.save(logInfo);
	}

}
