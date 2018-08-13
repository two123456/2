package com.superhero.netctoss.test.OsQueryTest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.osdaymag.queryservice.IOsDayQueryService;
import com.superhero.netctoos.osmonthmag.queryservice.IOsMonthQueryService;

/**
 * 按月查询账务账单测试
 * @author wyr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class OsMonthQueryImplTest {
	@Resource
	private IOsMonthQueryService osMonthQueryServiceImpl;
	@Test
	public void getOsMBeanByItem() {
		PageBean page = new PageBean(1, 2);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("osAccount", "张");
		map.put("account", "张三");
		map.put("month", "2018-08-13");
		PageBean bean = osMonthQueryServiceImpl.getPageBeanByAccountAndMonth(page, map);
		System.out.println(bean.getData());
	}
}
