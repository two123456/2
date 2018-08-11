package com.superhero.netctoos.osmonthmag.handleservice;

import com.superhero.netctoos.bean.OsmonthBean;

public interface IOsMonthHandleService {
	/**
	 * 增加业务账单（月）
	 * @param osMonth
	 */
	public void saveOsMonthBean(OsmonthBean osMonth);
}
