package com.superhero.netctoos.osmonthmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.annotation.DataSource;
import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.osmonthmag.dao.IOsMonthQueryDao;
import com.superhero.netctoos.osmonthmag.mapper.OsMonthQueryMapper;
/**
 * 按月查询账务账单持久层实现类（读）
 * @author wyr
 *
 */
@Repository
public class OsmonthQueryDaoImpl implements IOsMonthQueryDao {
	@Resource
	private OsMonthQueryMapper om;
	
	@Override
	@DataSource("read")
	public int countOsMonthQueryByParams(Map params) {
		// TODO Auto-generated method stub
		return om.countOsDayQueryByParams(params);
	}

	@Override
	@DataSource("read")
	public List<OsmonthBean> listOsMonthQueryByParams(Map params) {
		// TODO Auto-generated method stub
		return om.listOsDayQueryByParams(params);
	}

}
