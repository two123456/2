package com.superhero.netctoos.logdailymag.queryservice;

import java.util.Date;
import java.util.List;

import com.superhero.netctoos.bean.LogDailyBean;
import com.superhero.netctoos.bean.PageBean;

public interface ILogdailyQueryService {
	/**
	 * 根据时间来查询操作日志数据
	 * @param startTime 起始时间
	 * @param endTime 结束时间
	 * @return 操作日志集合
	 */
	PageBean getLogDailyByTime(Date startTime,Date endTime);
}
