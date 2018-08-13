package com.superhero.netctoos.logInmag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.LogInBean;
import com.superhero.netctoos.logInmag.handleservice.ILogInHandleService;
import com.superhero.netctoos.logInmag.repository.ILogInRepository;
@Service
public class LogInHandleServiceImpl implements ILogInHandleService {
@Resource
	private ILogInRepository logInRepository;
	@Override
	public void saveLogIn(LogInBean logIn) {
		// TODO Auto-generated method stub
		logInRepository.save(logIn);
	}

}
