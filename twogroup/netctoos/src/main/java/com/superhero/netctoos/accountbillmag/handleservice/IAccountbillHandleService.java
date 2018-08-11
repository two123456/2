package com.superhero.netctoos.accountbillmag.handleservice;

import com.superhero.netctoos.bean.AccountBillBean;
/***
 * 账务账单持久层接口
 * @author wwvu
 *
 */
public interface IAccountbillHandleService {
	/**
	 * 增加账务账单
	 * @param accountbill
	 */
	public void saveAccountbillBean(AccountBillBean accountbill);
	
	/**
	 * 修改账务账单支付状态
	 * @param accountbill
	 */
	public void updateAccountbillBean(AccountBillBean accountbill);
}
