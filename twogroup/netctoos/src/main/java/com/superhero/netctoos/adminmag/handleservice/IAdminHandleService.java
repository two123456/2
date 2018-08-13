package com.superhero.netctoos.adminmag.handleservice;

import com.superhero.netctoos.bean.AdminBean;
/**
 * 管理员管理写入 持久层接口
 * @author Administrator
 *
 */
public interface IAdminHandleService {
	
	/**
	 * 修改管理员
	 * @param admin
	 */
	public void updateAdminBean(AdminBean admin);
	/**
	 * 删除管理员
	 * @param admin
	 */
	public void deleteAdminBean(AdminBean admin);
	/**
	 * 添加管理员
	 * @param admin
	 */
	public void saveAdminBean(AdminBean admin);
}
