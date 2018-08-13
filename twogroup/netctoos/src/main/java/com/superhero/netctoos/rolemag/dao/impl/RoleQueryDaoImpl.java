package com.superhero.netctoos.rolemag.dao.impl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.superhero.netctoos.bean.RoleBean;
import com.superhero.netctoos.rolemag.dao.IRoleQueryDao;
import com.superhero.netctoos.rolemag.mapper.RoleMapper;
/**
 * 角色管理读取 持久层实现类
 * @author Administrator
 *
 */
@Repository
public class RoleQueryDaoImpl implements IRoleQueryDao{

	@Resource
	private RoleMapper ro;
	
	@Override
	public RoleBean getRoleById(Long id) {
		// TODO Auto-generated method stub
		return ro.getRoleById(id);
	}

	@Override
	public int countpage(Map params) {
		// TODO Auto-generated method stub
		return ro.countpage(params);
	}

	@Override
	public List<RoleBean> listRoleByparams(Map params) {
		// TODO Auto-generated method stub
		return ro.listRoleByparams(params);
	}
}
