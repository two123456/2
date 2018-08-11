package com.superhero.netctoos.authoritymag.handleservice;

import com.superhero.netctoos.bean.AuthorityBean;

public interface IAuthorityHandleService {
	/**
	 * 添加权限
	 * @param authority 权限对象
	 */
	void saveAuthority(AuthorityBean authority);  
	/**
	 * 删除权限
	 * @param authority 权限对象信息
	 */
	void deleteAuthority(AuthorityBean authority);
}
