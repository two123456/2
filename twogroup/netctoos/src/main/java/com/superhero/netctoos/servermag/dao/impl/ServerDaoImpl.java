package com.superhero.netctoos.servermag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.ServerBean;
import com.superhero.netctoos.servermag.dao.IServerDao;
import com.superhero.netctoos.servermag.mapper.ServerMapper;

@Repository
public class ServerDaoImpl implements IServerDao {
    @Resource 
	private ServerMapper server;

	@Override
	public List<ServerBean> listServerByparams(Map params) {
		// TODO Auto-generated method stub
		return server.listServerByparams(params);
	}

	@Override
	public int countpagebean(Map params) {
		// TODO Auto-generated method stub
		return server.countpagebean(params);
	}
	



}
