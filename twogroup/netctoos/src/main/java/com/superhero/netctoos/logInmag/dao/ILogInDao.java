package com.superhero.netctoos.logInmag.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.superhero.netctoos.bean.LogInBean;
import com.superhero.netctoos.bean.PageBean;
/**
 * 登陆日志持久层读取接口
 * @author xiasuiying
 *
 */
public interface ILogInDao {
	/**
	   * 根据时间来查询登陆日志信息
	   * @param startTime 起始时间
	   * @param endTime 结束时间
	   * @return 登录日志集合
	   */
	PageBean getLogInBeanByTime(Map map,PageBean page);
}
