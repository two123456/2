package com.superhero.netctoos.ostimesmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.annotation.DataSource;
import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.bean.OstimesBean;
import com.superhero.netctoos.ostimesmag.dao.IOsTimesQueryDao;
import com.superhero.netctoos.ostimesmag.mapper.OsTimesQueryMapper;
/**
 * 按月份查询业务账单 持久层实现类
 * @author wwvu
 *
 */
@Repository
public class OsTimesQueryDaoImpl implements IOsTimesQueryDao {
	@Resource
	private OsTimesQueryMapper otm;
	@Override
	@DataSource("read")
	public int countOsTimesQueryByParams(Map params) {
		// TODO Auto-generated method stub
		return otm.countOsTimesQueryByParams(params);
	}

	@Override
	@DataSource("read")
	public List<OstimesBean> listOsTimesQueryByParams(Map params) {
		// TODO Auto-generated method stub
		return otm.listOsTimesQueryByParams(params);
	}

}
