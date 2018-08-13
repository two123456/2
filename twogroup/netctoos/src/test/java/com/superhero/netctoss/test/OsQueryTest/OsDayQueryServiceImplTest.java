package com.superhero.netctoss.test.OsQueryTest;
/**
 * 按天查询账务账单测试
 * @author wyr
 *
 */

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.osdaymag.queryservice.IOsDayQueryService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class OsDayQueryServiceImplTest {
	@Resource
	private IOsDayQueryService osDayQueryServiceImpl;
	@Test
	public void getOsDayBeanByItem() {
		PageBean page = new PageBean(1, 2);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("osAccount", "张");
		PageBean bean = osDayQueryServiceImpl.getOsDayBeanByItem(page, map);
		System.out.println(bean.getData());
	}
}
