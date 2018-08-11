package com.superhero.netctoos.ostimesmag.queryservice;

import java.util.Map;

import com.superhero.netctoos.bean.PageBean;

public interface IOsTimesQueryService {
	
	/**
	 * 根据业务账号，月份查询业务账单（次）
	 * @param page
	 * @param map
	 * @return
	 */
	public PageBean getPageBeanByOsAndMonth(PageBean page,Map<String, Object> map);
}
