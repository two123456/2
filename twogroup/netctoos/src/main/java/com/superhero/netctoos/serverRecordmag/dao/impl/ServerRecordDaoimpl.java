package com.superhero.netctoos.serverRecordmag.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.bean.ServerBean;
import com.superhero.netctoos.bean.ServiceRecordBean;
import com.superhero.netctoos.serverRecordmag.dao.IServerRecordDao;
import com.superhero.netctoos.serverRecordmag.mapper.IServerRecordMapper;

/***
 * 业务控制持久层实现类
 * @author gongtao
 *
 */
@Repository  
public class ServerRecordDaoimpl implements IServerRecordDao {
     @Resource
	private IServerRecordMapper serverrecord;
	
	@Override
	public List<ServiceRecordBean> listByDate(Map map) {
		// TODO Auto-generated method stub
		return serverrecord.listByDate(map);
	}

}
