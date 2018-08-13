package com.superhero.netctoos.accountbillyearmag.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.accountbillmag.mapper.AccountBillMapper;
import com.superhero.netctoos.accountbillyearmag.dao.IAccountBillYearQueryDao;
import com.superhero.netctoos.bean.AccountBillYearBean;
import com.superhero.netctoos.bean.PageBean;

@Repository
public class AccountBillYearQueryDaoImpl implements IAccountBillYearQueryDao {
	@Resource
	private AccountBillMapper mapper;

	@Override
	public PageBean getAccountBillYearByItem(PageBean page, Map<String, Object> map) {
		int count = mapper.getCountByItem(page, map);
		List<AccountBillYearBean> list = new ArrayList<>();
		if (count != 0) {
			list = mapper.getPageBeanByItem(page, map);
		}
		PageBean pagebean = new PageBean();
		pagebean.setCode(count);
		pagebean.setData(list);

		return pagebean;
	}

}
