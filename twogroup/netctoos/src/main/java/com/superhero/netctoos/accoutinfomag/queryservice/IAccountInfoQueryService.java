package com.superhero.netctoos.accoutinfomag.queryservice;

import java.util.Map;

import com.superhero.netctoos.bean.AccountInfoBean;
import com.superhero.netctoos.bean.PageBean;

public interface IAccountInfoQueryService {
	/**
	 * 根据账务账号id查询实体bean
	 * @param id 账务账号id
	 * @return 
	 */
	public AccountInfoBean getAccountInfoBeanById(Long id);
	/**
	 * 根据账务账号 ，姓名条件查询
	 * @param map
	 * @return
	 */
	public PageBean listAccountInfoBeanByItem(Map<String, Object> map);
	
	
}
