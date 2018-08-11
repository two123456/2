package com.superhero.netctoos.accountbillmag.queryservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.superhero.netctoos.bean.AccountBillBean;
import com.superhero.netctoos.bean.PageBean;

public interface IAccountbillQueryService {

	/**
	 * 根据月份和账务账号查询账务账单费用
	 * @param page
	 * @param month
	 * @return
	 */
	public PageBean getPageBeanByItem(PageBean page, Map<String, Object> map);
	/**
	 * 根据年份和账务账号名字精确查询月账单集合（连表，精确查询）
	 * @param year
	 * @param accountName
	 * @return
	 */
	public List<AccountBillBean> listByAccountAndYear(Date year,String accountName);
}
