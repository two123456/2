package com.superhero.netctoos.accoutinfomag.handleservice;

import java.util.List;

import com.superhero.netctoos.bean.AccountBillBean;
import com.superhero.netctoos.bean.AccountInfoBean;

public interface IAccountInfoHandleService {
	/**
	 * 修改个人信息
	 * @param accountinfo
	 */
	public void updateAccountInfoBean(AccountInfoBean accountinfo);
	

	/**
	 * 添加账务账号
	 * @param AccountInfoBean 用户账务对象
	 */
	public void saveAccountInfoBean(AccountInfoBean accountinfo);
	/**
	 * 删除账务账号
	 * @param AccountInfoBean 账务账号对象
	 */
	public void deleteAccountInfoBean(AccountInfoBean accountinfo);
	/**
	 * 批量增加账务账号
	 * @param list
	 */
	public void saveAccountInfoBeanList(List<AccountInfoBean> list);
	
	
	
	
	
}
