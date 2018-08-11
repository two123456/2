package com.superhero.netctoos.accountbillyearmag.queryservice;

import java.util.Map;

import com.superhero.netctoos.bean.PageBean;

public interface IAccountBillYearQueryService {
	/**
	 * 根据真实姓名，年份查询年账单
	 * @param page
	 * @param map
	 * @return
	 */
	public PageBean getAccountBillYearByItem(PageBean page,Map<String, Object> map);
}
