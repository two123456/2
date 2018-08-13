package com.superhero.netctoos.accountbillmag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.superhero.netctoos.bean.AccountBillBean;
import com.superhero.netctoos.bean.AccountBillYearBean;
import com.superhero.netctoos.bean.PageBean;

public interface AccountBillMapper {

	/**
	 * 根据月份和账务账号查询账务账单费用
	 * 
	 * @param page
	 * @param month
	 * @return
	 */
	public List<AccountBillYearBean> getPageBeanByItem(@Param("p") PageBean page, @Param("m") Map<String, Object> map);

	/**
	 * 根据月份和账务账号查询账务账单费用的数量
	 * 
	 * @param page
	 * @param month
	 * @return
	 */
	public int getCountByItem(@Param("p") PageBean page, @Param("m") Map<String, Object> map);

	/**
	 * 根据年份和账务账号名字精确查询月账单集合（连表，精确查询）
	 * 
	 * @param year
	 * @param accountName
	 * @return
	 */

	public List<AccountBillBean> listByAccountAndYear();
}
