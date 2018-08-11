package com.superhero.netctoos.logInmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author xiasuiying
 *
 */
public interface LogInMapper {

	int countLogIn(@Param("params")Map map);
	List<?> getLogInBeanByStartTimeAndEndTime(@Param("params")Map map);
}
