package com.superhero.netctoos.osyearmag.handleservice;

import com.superhero.netctoos.bean.OsyearBean;

public interface IOsYearHandleService {
	/**
	 * 增加年账单
	 * @param osyear
	 */
	public void saveOsYearBean(OsyearBean osyear);
}
