package com.superhero.netctoos.serverRecordmag.queryservice.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.ServerBean;
import com.superhero.netctoos.bean.ServiceRecordBean;
import com.superhero.netctoos.serverRecordmag.dao.IServerRecordDao;
import com.superhero.netctoos.serverRecordmag.queryservice.IServerRecordService;
import com.superhero.netctoos.util.DateCast;

/***
 * 服务控制业务层实现类
 * @author gongtao
 *
 */
@Service  
public class ServerRecordServiceImpl implements IServerRecordService{
    @Resource
	private IServerRecordDao iserverRecordDaoimpl;
	
	@Override
	public List<ServiceRecordBean> listByDate(Map map) {
		// TODO Auto-generated method stub
		
		return iserverRecordDaoimpl.listByDate(map);
	}

}
