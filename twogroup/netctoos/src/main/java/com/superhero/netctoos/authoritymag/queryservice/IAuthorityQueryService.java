package com.superhero.netctoos.authoritymag.queryservice;

import com.superhero.netctoos.bean.PageBean;

public interface IAuthorityQueryService {
	/**
	 * 获取所有权限
	 * @param page
	 * @return
	 */
	public PageBean getAllAuthority(PageBean page);
}
