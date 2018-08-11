package com.superhero.netctoos.testmag.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.annotation.DataSource;

@Mapper
public interface LoginMapper {
	@Select("select count(*) from t_login_log")
	@ResultType(Integer.class)
	@DataSource("read")
	public int getLoginLogById();
}
