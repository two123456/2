package com.superhero.netctoos.accountbillmag.queryservice.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.superhero.netctoos.accountbillmag.dao.IAccountBillDao;
import com.superhero.netctoos.accountbillmag.queryservice.IAccountbillQueryService;
import com.superhero.netctoos.bean.AccountBillBean;
import com.superhero.netctoos.bean.PageBean;

/**
 * 
 * @author 00
 *
 */
@Service
public class AccountbillQueryServiceImpl implements IAccountbillQueryService{
	
	@Resource
	private IAccountBillDao dao;
	
	@Override
	public PageBean getPageBeanByItem(PageBean page, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.getPageBeanByItem(page, map);
	}

	@Override
	public List<AccountBillBean> listByAccountAndYear(Date year, String accountName) {
		// TODO Auto-generated method stub
		return dao.listByAccountAndYear(year, accountName);
	}

}
