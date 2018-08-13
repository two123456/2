package com.superhero.netctoss.test;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.RoleBean;
import com.superhero.netctoos.rolemag.handleservice.IRoleHandleService;
import com.superhero.netctoos.rolemag.queryservice.IRoleQueryService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class RoleServiceImplTest {
    
	@Resource
	private IRoleHandleService RoleRepository;
	@Resource
	private IRoleQueryService RoleDaoImpl;
	
	@Test
	public void saveRole() {
		RoleBean role = new RoleBean();
		role.setRoleName("普通管理员");
		role.setRoleType(3);
		RoleRepository.saveRole(role);
	}
	
	@Test
	public void deleteRole() {
		RoleBean role = RoleDaoImpl.getRoleById(2L);
		RoleRepository.deleteRole(role);		
	}
	
	@Test
	public void getRoleById() {
		RoleBean role = RoleDaoImpl.getRoleById(1L);
		System.out.println(role);
	}
	
	@Test
	public void updateRole() {
		RoleBean role = RoleDaoImpl.getRoleById(1L);
		role.setRoleName("普通管理员");
		role.setRoleType(2);
		RoleRepository.updateRole(role);
	}
	
	@Test
	public void getRole() {
		PageBean page=new PageBean(1,3);
		Map params = new HashMap<>();
        page=RoleDaoImpl.getRole(params, page, "普通管理员");
        System.out.println(page);
	}
}
