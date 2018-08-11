package com.superhero.netctoos.tariffmag.queryservice.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.TariffBean;
import com.superhero.netctoos.tariffmag.dao.ITariffQueryDao;
import com.superhero.netctoos.tariffmag.queryservice.ITariffQueryService;

/***
 * 资费业务层实现类
 * @author gongtao
 *
 */
@Service
public class TariffQueryServiceimpl implements ITariffQueryService {
   @Resource
	private ITariffQueryDao tariff;
	
	@Override
	public TariffBean getTariffById(Long id) {
		// TODO Auto-generated method stub
		return tariff.getTariffById(id);
	}

	@Override
	public PageBean findAll(Map params, PageBean page) {
		// TODO Auto-generated method stub
		int totalRows=tariff.countpage(params);
		if (totalRows>0) {
			params.put("index",page.getIndex());
			params.put("rows",page.getLimit());
			List<TariffBean> datas=tariff.listTariffByparams(params);
			page.setCount(totalRows);
			page.setData(datas);			
		}
		return page;
	}



}
