package com.superhero.netctoos.osyearmag.queryservice;

import java.util.Map;

import com.superhero.netctoos.bean.PageBean;

public interface IOsYearQueryService {
	/**
	 * 根据年和账务账号模糊查询
	 * @param page
	 * @param map
	 * @return
	 */
	public PageBean getOsYearByOsAndYear(PageBean page,Map<String, Object> map);
}
