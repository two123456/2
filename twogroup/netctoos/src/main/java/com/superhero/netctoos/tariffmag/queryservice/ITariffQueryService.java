package com.superhero.netctoos.tariffmag.queryservice;

import java.util.Map;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.TariffBean;

public interface ITariffQueryService {
	/**
	 * 根据资费id查询资费信息
	 * @param id 资费id
	 * @return 资费对象
	 */
	TariffBean getTariffById(Long id);
	/***
	 * 显示所有资费
	 * @param page
	 * @return
	 */
	public PageBean findAll(Map params ,PageBean page);
}
