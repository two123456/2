package com.superhero.netctoos.osdaymag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.annotation.DataSource;
import com.superhero.netctoos.bean.OsdayBean;
import com.superhero.netctoos.osdaymag.handleservice.IOsDayHandleService;
import com.superhero.netctoos.osdaymag.repository.OsDayHandleRepository;

/***
 * 按天查询账务账单写持久层
 * @author wyr
 *
 */
@Service
public class OsDayHandleServiceImpl implements IOsDayHandleService{
	@Resource
	private OsDayHandleRepository osDayHaneDaoImpl; 
	@Override
	@DataSource("write")
	public void saveOsDayBean(OsdayBean osday) {
		// TODO Auto-generated method stub
		osDayHaneDaoImpl.save(osday);
	}

}
