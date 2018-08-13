package com.superhero.netctoos.rolemag.queryservice;
import java.util.Map;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.RoleBean;
/**
 * 角色管理写入 业务层接口
 * @author Administrator
 *
 */
public interface IRoleQueryService {
	/**
	 * 分页查询显示角色信息
	 * @param page 页码
	 * @param roleName 角色名称
	 * @return 分页对象
	 */
	PageBean  getRole(Map params,PageBean page, String roleName);
	/**
	 * 根据角色ID得到角色信息
	 * @param id 角色id
	 * @return 角色信息
	 */
	RoleBean getRoleById(Long id);
}
