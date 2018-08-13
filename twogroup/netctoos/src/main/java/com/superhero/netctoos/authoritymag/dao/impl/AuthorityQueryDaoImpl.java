package com.superhero.netctoos.authoritymag.dao.impl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.superhero.netctoos.authoritymag.dao.IAuthorityQueryDao;
import com.superhero.netctoos.authoritymag.mapper.AuthorityMapper;
import com.superhero.netctoos.bean.AuthorityBean;
import com.superhero.netctoos.bean.PageBean;
/**
 * 权限管理读取 持久层实现类
 * @author Administrator
 *
 */
@Repository
public class AuthorityQueryDaoImpl implements IAuthorityQueryDao{

	@Resource
	private AuthorityMapper auth;
	
    
	@Override
	public AuthorityBean getAuthorityById(Long id) {
		// TODO Auto-generated method stub
		return auth.getAuthorityById(id);
	}

	@Override
	public int countpage(Map params) {
		// TODO Auto-generated method stub
		return auth.countpage(params);
	}

	@Override
	public List<AuthorityBean> listAuthorityByparams(Map params) {
		// TODO Auto-generated method stub
		return auth.listAuthorityByparams(params);
	}
    
}
