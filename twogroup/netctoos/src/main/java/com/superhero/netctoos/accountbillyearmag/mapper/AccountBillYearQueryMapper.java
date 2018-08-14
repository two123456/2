package com.superhero.netctoos.accountbillyearmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.bean.AccountBillYearBean;
import com.superhero.netctoos.bean.PageBean;

public interface AccountBillYearQueryMapper {

	
	public int getCountByItem(@Param("p") PageBean page, @Param("m") Map<String, Object> map);

	@Select("<script>"
			+ "SELECT aby.id AS idaby.year_time AS yearTime,aby.user_name AS userName,osy.os_account AS accunt ,osy.server_ip AS serverIp\r\n" + 
			"FROM t_osyear osy ,t_account_bill_year aby"
			+ "<where>"
			+ "osy.account=aby.account"
			+ "<if test='m.account != null and m.account !=\"\" '>"
			+ "and osy.account=#{m.account}"
			+ "</if>"
			+ "<if test='m.year != null and m.account !=\\\"\\\" '>"
			+ ""
			+ "</if>"
			+ "</where>"
			+ "<script>")
	public List<AccountBillYearBean> getPageBeanByItem(@Param("p") PageBean page, @Param("m") Map<String, Object> map);
}
