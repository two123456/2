package com.superhero.netctoos.rolemag.queryservice.impl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.RoleBean;
import com.superhero.netctoos.rolemag.dao.IRoleQueryDao;
import com.superhero.netctoos.rolemag.queryservice.IRoleQueryService;
/**
 * 角色管理读取 业务层实现类
 * @author Administrator
 *
 */
@Service
public class RoleQueryServiceImpl implements IRoleQueryService{

	@Resource
	private IRoleQueryDao roleQueryDaoImpl;
	@Override
	public PageBean getRole(Map params,PageBean page) {
		int totalRows=roleQueryDaoImpl.countpage(params);
		if (totalRows>0) {
			params.put("index",page.getIndex());
			params.put("rows",page.getLimit());
			List <RoleBean> datas=roleQueryDaoImpl.listRoleByparams(params);
			page.setCount(totalRows);
			page.setData(datas);			
		}
		return page;
	}
	@Override
	public RoleBean getRoleById(Long id) {
		// TODO Auto-generated method stub
		return roleQueryDaoImpl.getRoleById(id);
	}

}
