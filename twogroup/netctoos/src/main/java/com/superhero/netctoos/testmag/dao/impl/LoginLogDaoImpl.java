package com.superhero.netctoos.testmag.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.testmag.dao.ILoginLogDao;
import com.superhero.netctoos.testmag.mapper.LoginMapper;

@Repository
public class LoginLogDaoImpl implements ILoginLogDao{
	@Resource
	private LoginMapper loginMapper;
	
	@Override
	public int getLoginLogById() {
		// TODO Auto-generated method stub
		return loginMapper.getLoginLogById();
	}

}
