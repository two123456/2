package com.superhero.netctoos.logdailymag.handleservice;

import com.superhero.netctoos.bean.LogDailyBean;

public interface ILogdailyHandleService {
	/**
	 * 新增操作日志
	 * @param logDaily
	 */
	public void saveLogdailyBean(LogDailyBean logDaily);
}
