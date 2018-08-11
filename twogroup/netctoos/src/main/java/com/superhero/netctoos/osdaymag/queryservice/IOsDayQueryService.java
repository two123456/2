package com.superhero.netctoos.osdaymag.queryservice;

import java.util.Map;

import com.superhero.netctoos.bean.PageBean;

public interface IOsDayQueryService {

	/**
	 * 根据账务账号，业务账号，日期查询
	 * @param page
	 * @param map
	 * @return
	 */
	public PageBean getOsDayBeanByItem(PageBean page, Map<String, Object> map);
}
