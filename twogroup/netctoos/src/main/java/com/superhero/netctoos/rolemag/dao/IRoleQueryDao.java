package com.superhero.netctoos.rolemag.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.superhero.netctoos.bean.RoleBean;
/**
 * 角色管理读取 持久层接口
 * @author Administrator
 *
 */
public interface IRoleQueryDao {
	/**
	 * 分页查询显示角色信息
	 * @param page 页码
	 * @param roleName 角色名称
	 * @return 分页对象
	 */
	List<RoleBean>listRoleByparams(Map params);
	
	/**
	 * 根据角色ID得到角色信息
	 * @param id 角色id
	 * @return 角色信息
	 */
	RoleBean getRoleById(Long id);
	
	/**
	 * 统计所有角色
	 * @param params
	 * @return
	 */
	int countpage (@Param("params")Map params);
	
}
