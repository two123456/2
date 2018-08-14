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
import com.superhero.netctoos.util.DateCast;
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
			cd.setTime(DateCast.sqlDateChange((String)map.get("time")));
		    cd.set(Calendar.HOUR_OF_DAY, 0);
		    cd.set(Calendar.MINUTE, 0);
		    cd.set(Calendar.SECOND, 0);
			System.out.println(formatter.format(cd.getTime()));//当前时间当天的开始时间
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("startTime", formatter.format(cd.getTime()));
	    cd.set(Calendar.HOUR_OF_DAY, 23);
	    cd.set(Calendar.MINUTE, 59);
	    cd.set(Calendar.SECOND, 59);
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
