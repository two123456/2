package com.superhero.netctoos.accoutinfomag.handleservice.impl;

import java.util.List;

import com.superhero.netctoos.accoutinfomag.handleservice.IAccountInfoHandleService;
import com.superhero.netctoos.accoutinfomag.repository.IAccountInfoRepository;
import com.superhero.netctoos.bean.AccountInfoBean;

public class AccountInfoHandleServiceImpl implements IAccountInfoHandleService{
	private IAccountInfoRepository account;
	@Override
	public void updateAccountInfoBean(AccountInfoBean accountinfo) {
		account.saveAndFlush(accountinfo);
		
	}

	@Override
	public void saveAccountInfoBean(AccountInfoBean accountinfo) {
		// TODO Auto-generated method stub
		account.save(accountinfo);
	}

	@Override
	public void deleteAccountInfoBean(AccountInfoBean accountinfo) {
		// TODO Auto-generated method stub
		account.delete(accountinfo);
	}

	@Override
	public void saveAccountInfoBeanList(List<AccountInfoBean> list) {
		// TODO Auto-generated method stub
		account.save(list);
	}

}
