package com.superhero.netctoos.logdailymag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.LogDailyBean;
import com.superhero.netctoos.logdailymag.handleservice.ILogdailyHandleService;
import com.superhero.netctoos.logdailymag.repository.ILogDailyRepository;
@Service
public class LogDailyHandleServiceInImpl implements ILogdailyHandleService {
 @Resource
	private ILogDailyRepository logDailyRepository;
	@Override
	public void saveLogdailyBean(LogDailyBean logDaily) {
		// TODO Auto-generated method stub
		logDailyRepository.save(logDaily);
	}

}
