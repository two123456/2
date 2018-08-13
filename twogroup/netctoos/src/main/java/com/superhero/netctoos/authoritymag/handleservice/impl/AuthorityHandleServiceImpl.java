package com.superhero.netctoos.authoritymag.handleservice.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.authoritymag.handleservice.IAuthorityHandleService;
import com.superhero.netctoos.authoritymag.repository.IAuthorityRepository;
import com.superhero.netctoos.bean.AuthorityBean;
/**
 * 权限管理写入 业务层实现类
 * @author Administrator
 *
 */
@Service
public class AuthorityHandleServiceImpl implements IAuthorityHandleService{
	
	@Resource
    private IAuthorityRepository auth;
	
	@Override
	public void saveAuthority(AuthorityBean authority) {
		// TODO Auto-generated method stub
		auth.save(authority);
	}

	@Override
	public void deleteAuthority(AuthorityBean authority) {
		// TODO Auto-generated method stub
		auth.delete(authority);
	}

}
