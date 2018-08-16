package com.superhero.netctoss.test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.superhero.netctoos.adminmag.handleservice.IAdminHandleService;
import com.superhero.netctoos.adminmag.queryservice.IAdminQueryService;
import com.superhero.netctoos.annotation.MyLog;
import com.superhero.netctoos.bean.AdminBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.enmu.OperateLogEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class AdminServiceImplTest {
    
	@Resource
	private IAdminQueryService AdminDaoImpl;
	@Resource
	private IAdminHandleService AdminRepository;
	
	
	@Test
	public void saveAdmin() {
		AdminBean admin = new AdminBean();
		admin.setAdminName("李四");
		admin.setAdminNum("jack");
		admin.setAdminPwd("123");
		admin.setAdminPhone("1354012619");
		admin.setAdminMail("5156684@136.com");
		AdminRepository.saveAdminBean(admin);
	}
	
	@Test
	public void deleteAdmin() {
		AdminBean admin = AdminDaoImpl.getAdminBeanById(2L);
		AdminRepository.deleteAdminBean(admin);		
	}
	
	@Test
	public void updateAdmin() {
		AdminBean admin = AdminDaoImpl.getAdminBeanById(3L);
		admin.setAdminName("令狐冲");
		admin.setAdminNum("linlin");
		admin.setAdminPwd("456");
		admin.setAdminPhone("13539716190");
		admin.setAdminMail("51168234@136.com");
		AdminRepository.updateAdminBean(admin);
	}
	
	@Test
	public void getAdminById() {
		AdminBean admin = AdminDaoImpl.getAdminBeanById(3L);
		System.out.println(admin);
	}
	
	@Test
	public void getAdminBeanByName() {
		PageBean page=new PageBean(1,3);
		Map params = new HashMap<>();
		params.put("adminName", "张");
        page=AdminDaoImpl.getAdminBeanByName(params, page);
        System.out.println(page);
	}
}
