package com.superhero.netctoos.rolemag.queryservice;



import com.superhero.netctoos.bean.PageBean;

public interface IRoleQuerySerivce {
	/**
	 * 分页查询显示角色信息
	 * @param page 页码
	 * @param roleName 角色名称
	 * @return 分页对象
	 */
	PageBean  getRole(PageBean page, String roleName);
}
