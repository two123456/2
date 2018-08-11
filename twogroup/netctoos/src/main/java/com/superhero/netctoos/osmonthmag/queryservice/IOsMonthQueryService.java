package com.superhero.netctoos.osmonthmag.queryservice;

import java.util.Map;

import com.superhero.netctoos.bean.PageBean;

public interface IOsMonthQueryService {
	/**
	 * 根据账务账号，月份，业务账号查询业务账单（月）
	 * @param page
	 * @param map
	 * @return
	 */
	public PageBean getPageBeanByAccountAndMonth(PageBean page,Map<String, Object> map);
	
}
