package com.superhero.netctoos.adminmag.handleservice.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.adminmag.handleservice.IAdminHandleService;
import com.superhero.netctoos.adminmag.repository.IAdminRepository;
import com.superhero.netctoos.annotation.MyLog;
import com.superhero.netctoos.bean.AdminBean;
import com.superhero.netctoos.enmu.OperateLogEnum;
/**
 * 管理员管理写入 持久层实现类
 * @author Administrator
 *
 */
@Service
public class AdminHandleServiceImpl implements IAdminHandleService{
 
	@Resource
	private IAdminRepository ad;
	@MyLog(menuName="管理员",operateType=OperateLogEnum.UPDATE)
	@Override
	public void updateAdminBean(AdminBean admin) {
		// TODO Auto-generated method stub
		ad.saveAndFlush(admin);
	}
	@MyLog(menuName="管理员",operateType=OperateLogEnum.DELETE)
	@Override
	public void deleteAdminBean(AdminBean admin) {
		// TODO Auto-generated method stub
		ad.delete(admin);
	}
	@MyLog(menuName="管理员",operateType=OperateLogEnum.SAVE)
	@Override
	public void saveAdminBean(AdminBean admin) {
		// TODO Auto-generated method stub
		ad.save(admin);
	}

}
