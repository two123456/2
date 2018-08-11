package com.superhero.netctoss.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.servermag.queryservice.IServerQueryService;

/***
 * 服务器测试类
 * @author gongtao
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class ServerServiceimplTest {
     @Resource
	 private IServerQueryService iserver;
	
	@Test
	public void getServiceAll() {
		 PageBean page=new PageBean(1,2);
			Map params = new HashMap<>();
			page=iserver.getServiceAll(page, params);
	   System.out.println(page);
	}
}
