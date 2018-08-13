package com.superhero.netctoos.serverRecordmag.queryservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.superhero.netctoos.bean.ServerBean;
import com.superhero.netctoos.bean.ServiceRecordBean;

/***
 *  服务控制业务层接口
 * @author gongtao
 *
 */
public interface IServerRecordService {
	/***
	 * 
	 * @param day
	 * @return
	 */  
	public List<ServiceRecordBean> listByDate(Map map);
}
