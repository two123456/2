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
import com.superhero.netctoos.osyearmag.queryservice.IOsYearQueryService;

/**
 * 按月查询账务账单测试
 * @author wyr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class OsYearQueryImplTest {
	@Resource
	private IOsYearQueryService osYearQueryServiceImpl;
	@Test
	public void getOsMBeanByItem() {
		PageBean page = new PageBean(1, 2);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("osAccount", "张");
		map.put("Account", "张三");
		PageBean bean = osYearQueryServiceImpl.getOsYearByOsAndYear(page, map);
		System.out.println(bean.getData());
	}
}
