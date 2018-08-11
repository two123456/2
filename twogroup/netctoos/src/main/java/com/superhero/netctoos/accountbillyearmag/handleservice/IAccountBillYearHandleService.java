package com.superhero.netctoos.accountbillyearmag.handleservice;

import com.superhero.netctoos.bean.AccountBillYearBean;
/**
 * 账务账号年业务接口
 * @author Shinelon
 *
 */
public interface IAccountBillYearHandleService {

	/**
	 * 增加年账单
	 * @param accountBillYear
	 */
	public void saveAccountBillYearBean(AccountBillYearBean accountBillYear);
}
