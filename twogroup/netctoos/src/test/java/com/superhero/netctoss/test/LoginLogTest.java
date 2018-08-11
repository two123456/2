package com.superhero.netctoss.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.superhero.netctoos.testmag.dao.ILoginLogDao;
import com.superhero.netctoos.testmag.repository.LoginRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class LoginLogTest {
	
	@Resource
	private ILoginLogDao loginLogDaoImpl;
	@Resource
	private LoginRepository loginRepositoryImpl;
	@Test
	public void testGetLoginLogById() {
		System.out.println(loginLogDaoImpl.getLoginLogById());
	}
	@Test
	public void test() {
		System.out.println(loginRepositoryImpl.findAll());
	}
}
