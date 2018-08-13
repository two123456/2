package com.superhero.netctoos.ostimesmag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.annotation.DataSource;
import com.superhero.netctoos.bean.OstimesBean;
import com.superhero.netctoos.ostimesmag.handleservice.IOsTimesHandleService;
import com.superhero.netctoos.ostimesmag.repository.IOsTimesRepository;
/***
 * 按月查询业务 业务层实现类(写)
 * @author wyr
 *
 */
@Service
public class OsTimesHandleServiceImpl implements IOsTimesHandleService {
	@Resource
	private IOsTimesRepository osTimesRepositoryImpl;
	@Override
	@DataSource("write")
	public void saveOsTimesBean(OstimesBean osday) {
		// TODO Auto-generated method stub
		osTimesRepositoryImpl.save(osday);
	}
}
