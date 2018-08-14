package com.superhero.netctoos.accountbillyearmag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.accountbillyearmag.handleservice.IAccountBillYearHandleService;
import com.superhero.netctoos.accountbillyearmag.repository.AccountBillYearRepository;
import com.superhero.netctoos.bean.AccountBillYearBean;

@Service
public class AccountBillYearHandleServiceImpl implements IAccountBillYearHandleService {

	@Resource
	private AccountBillYearRepository accountyear;
	
	@Override
	public void saveAccountBillYearBean(AccountBillYearBean accountBillYear) {
		accountyear.save(accountBillYear);

	}

}
