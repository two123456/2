package com.superhero.netctoos.loginfomag.dao;

import com.superhero.netctoos.bean.LogInfoBean;

public interface ILogInfoDao {
	/**
	 * 根据管理日志id查询日志内容
	 * @param logDaylyId
	 * @return
	 */
	public LogInfoBean getLogInfoByLogDailyId(Long logDaylyId);
}
