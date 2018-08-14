package com.superhero.netctoos.accountbillmag.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.accountbillmag.dao.IAccountBillDao;
import com.superhero.netctoos.accountbillmag.mapper.AccountBillMapper;
import com.superhero.netctoos.bean.AccountBillBean;
import com.superhero.netctoos.bean.PageBean;

/**
 * 账务账单持久层实现类
 * @author yt
 *
 */
@Repository
public class AccountBillDaoImpl implements IAccountBillDao {

	@Resource
	private AccountBillMapper mapper;
	
	@Override
	public PageBean getPageBeanByItem(PageBean page, Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public List<AccountBillBean> listByAccountAndYear(Date year, String accountName) {
		
		return mapper.listByAccountAndYear();
	}

	

}
