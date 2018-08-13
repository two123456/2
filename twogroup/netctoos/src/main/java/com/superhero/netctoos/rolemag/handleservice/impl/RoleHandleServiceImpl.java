package com.superhero.netctoos.rolemag.handleservice.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.RoleBean;
import com.superhero.netctoos.rolemag.handleservice.IRoleHandleService;
import com.superhero.netctoos.rolemag.repository.IRoleRepository;
/**
 * 角色管理写入业务层实现类
 * @author Administrator
 *
 */
@Service
public class RoleHandleServiceImpl implements IRoleHandleService{

	@Resource
	private IRoleRepository ro;
	@Override
	public void saveRole(RoleBean role) {
		// TODO Auto-generated method stub
		ro.save(role);
	}

	@Override
	public void deleteRole(RoleBean role) {
		// TODO Auto-generated method stub
		ro.delete(role);
	}

	@Override
	public void updateRole(RoleBean role) {
		// TODO Auto-generated method stub
		ro.saveAndFlush(role);
	}
}
