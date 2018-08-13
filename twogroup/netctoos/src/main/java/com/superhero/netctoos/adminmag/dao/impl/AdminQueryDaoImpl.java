package com.superhero.netctoos.adminmag.dao.impl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.superhero.netctoos.adminmag.dao.IAdminQueryDao;
import com.superhero.netctoos.adminmag.mapper.AdminMapper;
import com.superhero.netctoos.bean.AdminBean;
/**
 * 管理员管理读取 持久层实现类
 * @author Administrator
 *
 */
@Repository
public class AdminQueryDaoImpl implements IAdminQueryDao{
 
	@Resource
	private AdminMapper admin;
	@Override
	public AdminBean getAdminBeanById(Long id) {
		// TODO Auto-generated method stub
		return admin.getAdminBeanById(id);
	}
	@Override
	public List<AdminBean> listAdminByparams(Map params) {
		// TODO Auto-generated method stub
		return admin.listAdminByparams(params);
	}
	@Override
	public int countpage(Map params) {
		// TODO Auto-generated method stub
		return admin.countpage(params);
	}

}
