package com.superhero.netctoos.osdaymag.queryservice.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.OsdayBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.osdaymag.dao.IOsDayQueryDao;
import com.superhero.netctoos.osdaymag.queryservice.IOsDayQueryService;
import com.superhero.netctoos.util.DateCast;

/***
 * 按天查询账务账单业务层实现类（读）
 * @author wyr
 *
 */
@Service
public class OsDayQueryServiceImpl implements IOsDayQueryService {
	
	@Resource
	private IOsDayQueryDao osDayQueryDaoImpl;
	@Override
	public PageBean getOsDayBeanByItem(PageBean page, Map<String, Object> map) {
		Calendar cd =  Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			cd.setTime(new Date());
			cd.set(GregorianCalendar.DAY_OF_MONTH, 1);
			System.out.println(formatter.format(cd.getTime()));//当前时间当月的第一天
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("startTime", formatter.format(cd.getTime()));
		cd.add(Calendar.MONTH, 1);
        cd.set(Calendar.DAY_OF_MONTH, 0);
        System.out.println(formatter.format(cd.getTime())); // 当前时间当月的最后一天
		map.put("endTime", formatter.format(cd.getTime()));
		int totalRows = osDayQueryDaoImpl.countOsDayQueryByParams(map);
		
		System.out.println("进入了！"+totalRows);
		if(totalRows > 0) {
			map.put("index", page.getIndex());
			map.put("rows", page.getLimit());
			List<OsdayBean> datas = osDayQueryDaoImpl.listOsDayQueryByParams(map);
			page.setCount(totalRows);
			page.setData(datas);
		}
		return page;
	}

}
