package com.superhero.netctoos.tariffmag.handleservice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.superhero.netctoos.bean.TariffBean;
import com.superhero.netctoos.tariffmag.handleservice.ITariffHandleService;
import com.superhero.netctoos.tariffmag.repository.ITariffrepository;

/***
 * 资费业务层实现类
 * @author gongtao
 *
 */
@Service
public class TariffServiceimpl implements ITariffHandleService {
    @Resource
	private ITariffrepository itariffrepository;
	
	@Override
	public void saveTariffBean(TariffBean tariff) {
		// TODO Auto-generated method stub
		itariffrepository.save(tariff);
	}

	@Override
	public void updateTariffBean(TariffBean tariff) {
		// TODO Auto-generated method stub
		itariffrepository.saveAndFlush(tariff);
		
	}

	@Override
	public void deleteTariffBean(TariffBean tariff) {
		// TODO Auto-generated method stub
		itariffrepository.delete(tariff);
	}

}
