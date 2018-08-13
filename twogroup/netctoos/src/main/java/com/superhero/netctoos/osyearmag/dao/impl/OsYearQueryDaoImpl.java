package com.superhero.netctoos.osyearmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.annotation.DataSource;
import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.bean.OsyearBean;
import com.superhero.netctoos.osmonthmag.dao.IOsMonthQueryDao;
import com.superhero.netctoos.osmonthmag.mapper.OsMonthQueryMapper;
import com.superhero.netctoos.osyearmag.dao.IOsYearQueryDao;
import com.superhero.netctoos.osyearmag.mapper.OsYearQueryMapper;
/**
 * 按月查询账务账单持久层实现类（读）
 * @author wyr
 *
 */
@Repository
public class OsYearQueryDaoImpl implements IOsYearQueryDao {
	@Resource
	private OsYearQueryMapper om;

	@Override
	@DataSource("read")
	public int countOsYearQueryByParams(Map params) {
		// TODO Auto-generated method stub
		return om.countOsDayQueryByParams(params);
	}

	@Override
	@DataSource("read")
	public List<OsmonthBean> listOsYearQueryByParams(Map params) {
		// TODO Auto-generated method stub
		return om.listOsDayQueryByParams(params);
	}
	


}
