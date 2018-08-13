package com.superhero.netctoos.osyearmag.queryservice.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.bean.OsyearBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.osmonthmag.queryservice.IOsMonthQueryService;
import com.superhero.netctoos.osyearmag.dao.IOsYearQueryDao;
import com.superhero.netctoos.osyearmag.queryservice.IOsYearQueryService;
import com.superhero.netctoos.util.DateCast;
/***
 * 按月查询账务账单业务层实现类（读）
 * @author wyr
 *
 */
@Service
public class OsYearQueryServiceImpl implements IOsYearQueryService {
	@Resource
	private IOsYearQueryDao osYearQueryDaoImpl;
	
	@Override
	public PageBean getOsYearByAccountAndYear(PageBean page, Map<String, Object> map) {
		Calendar cd =  Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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
		int totalRows = osYearQueryDaoImpl.countOsYearQueryByParams(map);
		
		if(totalRows > 0) {
			map.put("index", page.getIndex());
			map.put("rows", page.getLimit());
			List<OsmonthBean> datas = osYearQueryDaoImpl.listOsYearQueryByParams(map);
			page.setCount(totalRows);
			page.setData(datas);
		}
		return page;
	}

	@Override
	public List<OsmonthBean> getOsyearByOsAndYear(Map<String, Object> map) {
		Calendar cd =  Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String year=  (String) map.get("year");
		Date osyear=DateCast.sqlDateChange(year);
		try {
			cd.setTime(osyear);
			cd.set(GregorianCalendar.DAY_OF_YEAR, 1);
			System.out.println(formatter.format(cd.getTime()));//当前时间当年的第一天
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("startTime", formatter.format(cd.getTime()));
		cd.add(Calendar.YEAR, 1);
        cd.set(Calendar.DAY_OF_YEAR, 0);
        System.out.println(formatter.format(cd.getTime())); // 当前时间当年的最后一天
		map.put("endTime", formatter.format(cd.getTime()));
		List<OsmonthBean> osyearByOsAndYear = osYearQueryDaoImpl.getOsyearByOsAndYear(map);
		return osyearByOsAndYear;
	}

}
