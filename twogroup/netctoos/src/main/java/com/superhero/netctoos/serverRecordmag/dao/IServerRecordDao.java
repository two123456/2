package com.superhero.netctoos.serverRecordmag.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.superhero.netctoos.bean.ServerBean;
import com.superhero.netctoos.bean.ServiceRecordBean;

/***
 * 服务控制持久接口
 * @author gongtao
 *
 */
public interface IServerRecordDao {
	/***   
	 * 
	 * @param day
	 * @return
	 */
	public List<ServiceRecordBean> listByDate(Map map);

}
