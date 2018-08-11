package com.superhero.netctoos.osdaymag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.OsdayBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.osdaymag.dao.IOsDayQueryDao;
import com.superhero.netctoos.osdaymag.queryservice.IOsDayQueryService;
/***
 * 按天查询账务账单业务层实现类（读）
 * @author wyr
 *
 */
@Service
public class OsDayQueryServiceImpl implements IOsDayQueryService {
	
	@Resource
	private IOsDayQueryDao oseDayQueryDaoImpl;
	@Override
	public PageBean getOsDayBeanByItem(PageBean page, Map<String, Object> map) {
		// TODO Auto-generated method stub
		int totalRows = oseDayQueryDaoImpl.countOsDayQueryByParams(map);
		if(totalRows > 0) {
//			map.put("index", page);
			map.put("rows", page.getLimit());
			List<OsdayBean> datas = oseDayQueryDaoImpl.listOsDayQueryByParams(map);
			page.setCount(totalRows);
			page.setData(datas);
		}
		return page;
	}

}
