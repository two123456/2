package com.superhero.netctoos.tariffmag.dao;

import java.util.List;
import java.util.Map;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.TariffBean;
/***
 * 资费持久层接口
 * @author gongtao
 *
 */
public interface ITariffQueryDao {
   /**
    * 根据资费id查询资费信息
    * @param id 资费id
    * @return 资费对象
    */
	TariffBean getTariffById(Long id);
	/***
	 * 分页显示资费
	 * @param params
	 * @return
	 */
	List<TariffBean>listTariffByparams(Map params);
	/***
	 * 统计所有资费
	 * @return
	 */
	int countpage (Map params);
}
