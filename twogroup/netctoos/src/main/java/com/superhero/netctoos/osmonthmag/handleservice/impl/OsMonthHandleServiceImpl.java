package com.superhero.netctoos.osmonthmag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.annotation.DataSource;
import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.osmonthmag.handleservice.IOsMonthHandleService;
import com.superhero.netctoos.osmonthmag.repository.IOsMonthRepository;
/***
 * 按月查询账单业务层实现类(写)
 * @author wyr
 *
 */
@Service
public class OsMonthHandleServiceImpl implements IOsMonthHandleService {
	@Resource
	private IOsMonthRepository osMonthDaoImpl;
	
	@Override
	@DataSource("write")
	public void saveOsMonthBean(OsmonthBean osMonth) {
		// TODO Auto-generated method stub
		osMonthDaoImpl.save(osMonth);
	}

}
