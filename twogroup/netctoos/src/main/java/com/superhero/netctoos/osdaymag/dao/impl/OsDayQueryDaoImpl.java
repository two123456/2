package com.superhero.netctoos.osdaymag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.annotation.DataSource;
import com.superhero.netctoos.bean.OsdayBean;
import com.superhero.netctoos.osdaymag.dao.IOsDayQueryDao;
import com.superhero.netctoos.osdaymag.mapper.OsDayQueryMapper;
/***
 * 按天查询账务账单持久层实现类（读）
 * @author wyr
 *
 */
@Repository
public class OsDayQueryDaoImpl implements IOsDayQueryDao {
	
	@Resource
	private OsDayQueryMapper om;
	@Override
	@DataSource("read")
	public int countOsDayQueryByParams(Map params) {
		// TODO Auto-generated method stub
		return om.countOsDayQueryByParams(params);
	}

	@Override
	@DataSource("read")
	public List<OsdayBean> listOsDayQueryByParams(Map params) {
		// TODO Auto-generated method stub
		return om.listOsDayQueryByParams(params);
	}

}
