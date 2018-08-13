package com.superhero.netctoos.ostimesmag.handleservice;

import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.bean.OstimesBean;

public interface IOsTimesHandleService {
	/**
	 * 增加业务详情（月/次）
	 * @param osMonth
	 */
	public void saveOsTimesBean(OstimesBean ostimes);
}
