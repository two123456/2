package com.superhero.netctoos.osmag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.OsBean;
import com.superhero.netctoos.osmag.handleservice.IOsHandleService;
import com.superhero.netctoos.osmag.repository.OsMagRepository;

@Service
public class OsHandleServiceImpl implements IOsHandleService {

	@Resource
	private OsMagRepository osmag;

	@Override
	public void saveOsBean(OsBean os) {
		// TODO Auto-generated method stub
		osmag.save(os);
	}

	@Override
	public void updateOsBean(OsBean os) {
		// TODO Auto-generated method stub
		osmag.saveAndFlush(os);
	}

	@Override
	public void deleteOsBean(OsBean os) {
		// TODO Auto-generated method stub
		osmag.delete(os);
	}

}
