package com.superhero.netctoos.tariffmag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.TariffBean;
import com.superhero.netctoos.tariffmag.dao.ITariffQueryDao;
import com.superhero.netctoos.tariffmag.mapper.TariffMapper;
/***
 * 资费持久层实现类
 * @author gongtao
 *
 */
@Repository
public class TariffQueryDaoimpl implements ITariffQueryDao {
 @Resource
	private TariffMapper tariff;
	
	@Override
	public TariffBean getTariffById(Long id) {
		// TODO Auto-generated method stub
		return tariff.getTariffById(id);
	}

	@Override
	public List<TariffBean> listTariffByparams(Map params) {
		// TODO Auto-generated method stub
		return tariff.listTariffByparams(params);
	}

	@Override
	public int countpage(Map params) {
		// TODO Auto-generated method stub
		return tariff.countpage(params);
	}



}
