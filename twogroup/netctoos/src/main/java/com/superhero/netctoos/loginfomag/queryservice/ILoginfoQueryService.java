package com.superhero.netctoos.loginfomag.queryservice;

import com.superhero.netctoos.bean.LogInfoBean;

public interface ILoginfoQueryService {
	/**
	 * 根据管理日志id查询日志内容
	 * @param logDaylyId
	 * @return
	 */
	public LogInfoBean getLogInfoByLogDailyId(Long logDaylyId);

}
