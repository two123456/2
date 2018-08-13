package com.superhero.netctoos.adminmag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.adminmag.dao.IAdminQueryDao;
import com.superhero.netctoos.adminmag.queryservice.IAdminQueryService;
import com.superhero.netctoos.bean.AdminBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.RoleBean;
@Service
public class AdminQueryServiceImpl implements IAdminQueryService{

	@Resource
	private IAdminQueryDao adminQueryDaoimpl;
	@Override
	public AdminBean getAdminBeanById(Long id) {
		// TODO Auto-generated method stub
		return adminQueryDaoimpl.getAdminBeanById(id);
	}

	@Override
	public PageBean getAdminBeanByName(Map params,PageBean page) {
		// TODO Auto-generated method stub
		int totalRows=adminQueryDaoimpl.countpage(params);
		if (totalRows>0) {
			params.put("index",page.getIndex());
			params.put("rows",page.getLimit());
			List <AdminBean> datas=adminQueryDaoimpl.listAdminByparams(params);
			page.setCount(totalRows);
			page.setData(datas);			
		}
		return page;
	}

}
