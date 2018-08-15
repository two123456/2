package com.superhero.netctoos.authoritymag.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.superhero.netctoos.bean.AuthorityBean;
/**
 * 权限管理读取 持久层接口
 * @author Administrator
 *
 */
public interface IAuthorityQueryDao {
	/**
	 * 分页显示所有权限
	 * @param page
	 * @return
	 */
	List<AuthorityBean>listAuthorityByparams(Map params);
	
	/**
	 * 根据ID得到权限信息
	 * @param id id
	 * @return 权限信息
	 */
	AuthorityBean getAuthorityById(Long id);
	
	/***
	 * 统计所有权限
	 * @return
	 */
	int countpage (Map params);
	
}
