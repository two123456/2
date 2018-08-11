package com.superhero.netctoos.rolemag.handleservice;

import java.util.List;

import com.superhero.netctoos.bean.RoleBean;

public interface IRoleHandleService {
	/**
	 * 添加角色
	 * @param role 角色对象
	 */
	void saveRole(RoleBean role);
	/**
	 * 删除角色
	 * @param role 角色对象
	 */
	void deleteRole(RoleBean role);
	/**
	 * 修改角色信息
	 * @param role 角色对象
	 */
	void updateRole(RoleBean role);
}
