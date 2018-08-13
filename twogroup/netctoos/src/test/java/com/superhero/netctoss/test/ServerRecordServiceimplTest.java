package com.superhero.netctoss.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.superhero.netctoos.bean.ServerBean;
import com.superhero.netctoos.bean.ServiceRecordBean;
import com.superhero.netctoos.serverRecordmag.dao.IServerRecordDao;
import com.superhero.netctoos.serverRecordmag.queryservice.IServerRecordService;
import com.superhero.netctoos.util.DateCast;

/***
 * 服务控制测试类
 * @author gongtao
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class ServerRecordServiceimplTest {
     @Resource
	private IServerRecordService iServerRecordDao;

     @Test
    public void listByDate() {
    	 Map<String, Date> params = new HashMap<String, Date>();
    	 params.put("day", new Date());
    	 
    	 
    	List<ServiceRecordBean> listByDate = iServerRecordDao.listByDate(params);
    	
    	System.out.println(listByDate);
    	
    	
    	
    }
}
