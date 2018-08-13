package com.superhero.netctoos.adminmag.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.superhero.netctoos.bean.AdminBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.RoleBean;
/**
 * 管理员管理读取 持久层接口
 * @author Administrator
 *
 */
public interface IAdminQueryDao {
	/**
	 * 根据id查询管理员信息
	 * @param id
	 * @return
	 */
	public AdminBean getAdminBeanById(Long id);
	/**
	 * 按管理员姓名模糊查询
	 * @param page
	 * @param adminName
	 * @return
	 */
	List<AdminBean>listAdminByparams(Map params);
	
	/**
	 * 统计所有管理员
	 * @param params
	 * @return
	 */
	int countpage (Map params);
}
