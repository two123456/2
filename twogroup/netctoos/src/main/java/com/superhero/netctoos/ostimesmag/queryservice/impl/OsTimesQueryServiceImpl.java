package com.superhero.netctoos.ostimesmag.queryservice.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.bean.OstimesBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.ostimesmag.dao.IOsTimesQueryDao;
import com.superhero.netctoos.ostimesmag.queryservice.IOsTimesQueryService;
/***
 * 按月查询业务账单（次）
 * @author wwvu
 *
 */
@Service
public class OsTimesQueryServiceImpl implements IOsTimesQueryService {
	@Resource
	private IOsTimesQueryDao osTimesQueryDaoImpl;
	@Override
	public PageBean getPageBeanByOsAndMonth(PageBean page, Map<String, Object> map) {
		Calendar cd =  Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			cd.setTime(new Date());
			cd.set(GregorianCalendar.DAY_OF_YEAR, 1);
			System.out.println(formatter.format(cd.getTime()));//当前时间当月的第一天
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("startTime", formatter.format(cd.getTime()));
		cd.add(Calendar.YEAR, 1);
        cd.set(Calendar.DAY_OF_YEAR, 0);
        System.out.println(formatter.format(cd.getTime())); // 当前时间当月的最后一天
		map.put("endTime", formatter.format(cd.getTime()));
		int totalRows = osTimesQueryDaoImpl.countOsTimesQueryByParams(map);
		
		System.out.println("进入了！"+totalRows);
		if(totalRows > 0) {
			map.put("index", page.getIndex());
			map.put("rows", page.getLimit());
			List<OstimesBean> datas = osTimesQueryDaoImpl.listOsTimesQueryByParams(map);
			page.setCount(totalRows);
			page.setData(datas);
		}
		return page;
	}

}
