package com.superhero.netctoos.accoutinfomag.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.accoutinfomag.dao.IAccountInfoDao;
import com.superhero.netctoos.accoutinfomag.mapper.AccountInfoQueryMapper;
import com.superhero.netctoos.bean.AccountInfoBean;
import com.superhero.netctoos.bean.PageBean;

@Repository
public class AccountInfoDaoImpl implements IAccountInfoDao {
	@Resource
	private AccountInfoQueryMapper mapper;

	@Override
	public AccountInfoBean getAccountInfoBeanById(Long id) {
		// TODO Auto-generated method stub
		return mapper.getAccountInfoBeanById(id);
	}

	@Override
	public PageBean listAccountInfoBeanByItem(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count = mapper.countAccountInfoBeanByItem(map);
		PageBean page = new PageBean();
		List<AccountInfoBean> list = new ArrayList<>();
		if (count != 0) {
			list = mapper.listAccountInfoBeanByItem(map);
		}
		page.setCount(count);
		page.setData(list);
		return page;
	}

}
