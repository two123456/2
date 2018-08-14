package com.superhero.netctoos.osmag.queryservice.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.osmag.dao.IOsQueryDao;
import com.superhero.netctoos.osmag.queryservice.IOsQueryService;

@Service
public class OsQueryServiceImpl implements IOsQueryService {

	@Resource
	private IOsQueryDao osQueryDaoImpl;

	@Override
	public PageBean getOsBeanByItem(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return osQueryDaoImpl.getOsBeanByItem(map);
	}

}
