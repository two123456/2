package com.superhero.netctoos.osyearmag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.annotation.DataSource;
import com.superhero.netctoos.bean.OsyearBean;
import com.superhero.netctoos.osyearmag.handleservice.IOsYearHandleService;
import com.superhero.netctoos.osyearmag.repositry.IOsYearRepository;
/***
 * 添加年业务 业务层实现类(写)
 * @author wyr
 *
 */
@Service
public class OsYearHandleServiceImpl implements IOsYearHandleService {
	@Resource
	private IOsYearRepository osYearRepository;
	@Override
	@DataSource("write")
	public void saveOsYearBean(OsyearBean osyear) {
		// TODO Auto-generated method stub
		osYearRepository.save(osyear);
	}

}
