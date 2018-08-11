package com.superhero.netctoos.osmag.queryservice;

import java.util.Map;

import com.superhero.netctoos.bean.PageBean;

public interface IOsQueryService {
	/**
	 * 根据账务账号姓名，业务账号查询（需要连表业务账号，账务账号，服务器，资费）
	 * @param map
	 * @return
	 */
	public PageBean getOsBeanByItem(Map<String, Object> map);

}
