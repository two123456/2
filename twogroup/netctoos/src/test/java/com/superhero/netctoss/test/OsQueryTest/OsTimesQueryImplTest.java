package com.superhero.netctoss.test.OsQueryTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.superhero.netctoos.bean.OstimesBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.osdaymag.queryservice.IOsDayQueryService;
import com.superhero.netctoos.osmonthmag.queryservice.IOsMonthQueryService;
import com.superhero.netctoos.ostimesmag.handleservice.IOsTimesHandleService;
import com.superhero.netctoos.ostimesmag.queryservice.IOsTimesQueryService;
import com.superhero.netctoos.util.DateCast;

/**
 * 按月查询账务账单测试
 * 
 * @author wyr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OsTimesQueryImplTest {
	@Resource
	private IOsTimesQueryService osTimesQueryServiceImpl;
	@Resource
	private IOsTimesHandleService osTimesHandleServiceImpl;

	@Test
	public void getOsMBeanByItem() {
		PageBean page = new PageBean(1, 2);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("osAccount", "张");
		PageBean bean = osTimesQueryServiceImpl.getPageBeanByOsAndMonth(page, map);
		System.out.println(bean.getData());
	}

	@Test
	public void saveOsTimesBean() {
		OstimesBean bean = new OstimesBean();
		bean.setCost(1998);
		bean.setEnterTime(DateCast.sqlDateChange("2018-08-12"));
		System.out.println("---------------------------" + DateCast.sqlDateChange("2018-08-12"));

		bean.setOsAccount("张三");
		bean.setOutTime(new Date());
		bean.setServerIp("192.1.1.2");
		bean.setTariffCombo("包年");
		bean.setValidTime(1212);
		osTimesHandleServiceImpl.saveOsTimesBean(bean);
	}
}
