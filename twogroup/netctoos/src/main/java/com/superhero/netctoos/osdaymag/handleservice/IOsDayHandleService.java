package com.superhero.netctoos.osdaymag.handleservice;

import com.superhero.netctoos.bean.OsdayBean;

public interface IOsDayHandleService {
	/**
	 * 增加业务账单（日）
	 * @param osday
	 */
	public void saveOsDayBean(OsdayBean osday);
}
