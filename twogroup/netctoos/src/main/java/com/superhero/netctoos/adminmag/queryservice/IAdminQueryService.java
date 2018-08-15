package com.superhero.netctoos.adminmag.queryservice;
import java.util.Map;
import com.superhero.netctoos.bean.AdminBean;
import com.superhero.netctoos.bean.PageBean;
/**
 * 管理员读取 持久层接口
 * @author Administrator
 *
 */
public interface IAdminQueryService {
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
	public PageBean getAdminBeanByName(Map params,PageBean page);

}
