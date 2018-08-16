package com.superhero.netctoss.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.superhero.netctoos.adminmag.handleservice.IAdminHandleService;
import com.superhero.netctoos.annotation.MyLog;
import com.superhero.netctoos.annotation.MyLogin;
import com.superhero.netctoos.bean.AdminBean;
import com.superhero.netctoos.enmu.LoginEnum;
import com.superhero.netctoos.enmu.OperateLogEnum;
import com.superhero.netctoos.testmag.dao.ILoginLogDao;
import com.superhero.netctoos.testmag.repository.LoginRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class LoginLogTest {
	
	@Resource
	private ILoginLogDao loginLogDaoImpl;
	@Resource
	private LoginRepository loginRepositoryImpl;
	@Resource
	private IAdminHandleService adminHandleServiceImpl;
	
	@MyLog(menuName="用户管理",operateType=OperateLogEnum.SAVE)
	@Test
	public void testGetLoginLogById() {
		System.out.println("1234");
	}
	@Test
	@MyLogin(operateType=LoginEnum.LOGIN)
	public void test() {
		AdminBean admin=new AdminBean();
		
		adminHandleServiceImpl.saveAdminBean(admin);
	}
}
