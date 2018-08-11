package com.superhero.netctoos.logInmag.queryservice;

import java.util.Date;
import java.util.List;

import com.superhero.netctoos.bean.LogInBean;
import com.superhero.netctoos.bean.PageBean;

public interface ILogInQueryService {
  /**
   * 根据时间来查询登陆日志信息
   * @param startTime 起始时间
   * @param endTime 结束时间
   * @return 登录日志集合
   */
	PageBean getLogInBeanByTime(Date startTime,Date endTime);
}
