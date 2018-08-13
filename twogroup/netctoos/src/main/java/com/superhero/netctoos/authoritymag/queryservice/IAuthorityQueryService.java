package com.superhero.netctoos.authoritymag.queryservice;
import java.util.Map;

import com.superhero.netctoos.bean.AuthorityBean;
import com.superhero.netctoos.bean.PageBean;
/**
 * 权限管理读取 业务层接口
 * @author Administrator
 *
 */
public interface IAuthorityQueryService {
	/**
	 * 获取所有权限
	 * @param page
	 * @return
	 */
	public PageBean getAllAuthority(Map params,PageBean page);
	/**
	 * 根据权限ID得到权限信息
	 * @param id id
	 * @return 权限信息
	 */
	AuthorityBean getAuthorityById(Long id);
	
	
}
