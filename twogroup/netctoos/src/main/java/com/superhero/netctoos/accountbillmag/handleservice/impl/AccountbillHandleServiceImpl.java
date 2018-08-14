package com.superhero.netctoos.accountbillmag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.accountbillmag.handleservice.IAccountbillHandleService;
import com.superhero.netctoos.accountbillmag.repository.AccountBillRepository;
import com.superhero.netctoos.bean.AccountBillBean;

@Service
public class AccountbillHandleServiceImpl implements IAccountbillHandleService {
	@Resource
	private AccountBillRepository accountBill;

	@Override
	public void saveAccountbillBean(AccountBillBean accountbill) {
		// TODO Auto-generated method stub
		accountBill.save(accountbill);
	}

	@Override
	public void updateAccountbillBean(AccountBillBean accountbill) {
		// TODO Auto-generated method stub
		accountBill.saveAndFlush(accountbill);
	}

}
