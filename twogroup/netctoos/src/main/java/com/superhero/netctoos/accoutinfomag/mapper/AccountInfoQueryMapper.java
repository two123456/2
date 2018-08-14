package com.superhero.netctoos.accoutinfomag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.bean.AccountInfoBean;

public interface AccountInfoQueryMapper {
	/**
	 * 根据账务账号id查询实体bean
	 * 
	 * @param id
	 *            账务账号id
	 * @return
	 */
	@Select("SELECT id AS id ,user_name AS userName,account AS accountingNum,case account_state WHEN '0' THEN '开通' WHEN '1' THEN '暂停' WHEN '-1' THEN '禁用' ELSE '' END as numState,user_address as address\r\n"
			+ "FROM t_account_info \r\n")
	public AccountInfoBean getAccountInfoBeanById(Long id);

	/**
	 * 根据账务账号 ，姓名条件查询
	 * 
	 * @param map
	 * @return
	 */
	/*@Select("<script>"
			+ "SELECT id AS id ,user_name AS userName,account AS accountingNum,case account_state WHEN '0' THEN '开通' WHEN '1' THEN '暂停' WHEN '-1' THEN '禁用' ELSE '' END as numState,user_address as address\r\n"
			+ "FROM t_account_info " + "<where>" + "<if test='m.account != null and m.account !=\"\" '>"
			+ "and accountingNum=#{m.accont}" + "</if>" + "<if test='m.userName != null and m.userName !=\"\" '>"
			+ "and userName =#{m.userName}" + "</if>" + "</where>" + "limt m.index,m.rows" + "</script>")*/
	public List<AccountInfoBean> listAccountInfoBeanByItem(@Param("m") Map<String, Object> map);

	/**
	 * 根据账务账号 ，姓名条件查询
	 * 
	 * @param map
	 * @return
	 */
	/*@Select("<script>" + "SELECT count(*)" + "FROM t_account_info " + "<where>"
			+ "<if test='m.account != null and m.account !=\"\" '>" + "and accountingNum=#{m.accont}" + "</if>"
			+ "<if test='m.userName != null and m.userName !=\"\" '>" + "and userName =#{m.userName}" + "</if>"
			+ "</where>")*/
	public int countAccountInfoBeanByItem(@Param("m") Map<String, Object> map);
}
