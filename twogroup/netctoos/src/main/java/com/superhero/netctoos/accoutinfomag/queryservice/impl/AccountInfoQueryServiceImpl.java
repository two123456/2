package com.superhero.netctoos.accoutinfomag.queryservice.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.accoutinfomag.dao.IAccountInfoDao;
import com.superhero.netctoos.accoutinfomag.queryservice.IAccountInfoQueryService;
import com.superhero.netctoos.bean.AccountInfoBean;
import com.superhero.netctoos.bean.PageBean;

@Service
public class AccountInfoQueryServiceImpl implements IAccountInfoQueryService {
	@Resource
	private IAccountInfoDao accountInfoDao;

	@Override
	public AccountInfoBean getAccountInfoBeanById(Long id) {
		// TODO Auto-generated method stub
		return accountInfoDao.getAccountInfoBeanById(id);
	}

	@Override
	public PageBean listAccountInfoBeanByItem(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return accountInfoDao.listAccountInfoBeanByItem(map);
	}

}
