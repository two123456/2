package com.superhero.netctoss.test;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.superhero.netctoos.authoritymag.handleservice.IAuthorityHandleService;
import com.superhero.netctoos.authoritymag.queryservice.IAuthorityQueryService;
import com.superhero.netctoos.bean.AuthorityBean;
import com.superhero.netctoos.bean.PageBean;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class AuthorityServiceImplTest {

	@Resource
	private IAuthorityHandleService authorityRepository;
	@Resource
	private IAuthorityQueryService IauthorityDao;
	
	@Test
	public void saveAuthority() {
		AuthorityBean  authority=new AuthorityBean();
		authority.setAuthorityName("修改");
		authorityRepository.saveAuthority(authority);
	}
	
	@Test
	public void deleteAuthority() {
		AuthorityBean authority = IauthorityDao.getAuthorityById(2L);
		authorityRepository.deleteAuthority(authority);
								
	}
	@Test
	public void getAuthorityById() {
		AuthorityBean authority = IauthorityDao.getAuthorityById(3L);
		System.out.println(authority);
	}
	
	@Test
	public void getAllAuthority() {
		PageBean page=new PageBean(1,3);
		Map params = new HashMap<>();
      page=IauthorityDao.getAllAuthority(params, page);
 System.out.println(page);
}
}