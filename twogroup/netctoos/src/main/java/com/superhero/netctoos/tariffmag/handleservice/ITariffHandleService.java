package com.superhero.netctoos.tariffmag.handleservice;

import com.superhero.netctoos.bean.TariffBean;

public interface ITariffHandleService {
	/**
	 * 增加资费
	 * @param tariff
	 */
	public void saveTariffBean(TariffBean tariff);
	/**
	 * 修改资费
	 * @param tariff
	 */
	public void updateTariffBean(TariffBean tariff);
	/**
	 * 删除资费
	 * @param tariff
	 */
	public void deleteTariffBean(TariffBean tariff);
}
