package com.superhero.netctoos.logdailymag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LogdailyMapper {
	int countLogDaily(@Param("params")Map map);
	List<?> getLogDailyBeanByStartTimeAndEndTime(@Param("params")Map map);
}
