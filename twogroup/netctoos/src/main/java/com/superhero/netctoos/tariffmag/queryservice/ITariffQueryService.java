package com.superhero.netctoos.tariffmag.queryservice;

import com.superhero.netctoos.bean.TariffBean;

public interface ITariffQueryService {
	/**
	 * 根据资费id查询资费信息
	 * @param id 资费id
	 * @return 资费对象
	 */
	TariffBean getTariffById(Long id);
}
