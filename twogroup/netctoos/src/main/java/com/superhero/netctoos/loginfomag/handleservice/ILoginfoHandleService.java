package com.superhero.netctoos.loginfomag.handleservice;


import com.superhero.netctoos.bean.LogInfoBean;

public interface ILoginfoHandleService {

	/**
	 * 新增操作日志内容
	 * @param logInfo
	 */
	public void saveLogInfoBean(LogInfoBean logInfo);
}
