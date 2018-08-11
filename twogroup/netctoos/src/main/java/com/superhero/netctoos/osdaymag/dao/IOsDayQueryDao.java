package com.superhero.netctoos.osdaymag.dao;

import java.util.List;
import java.util.Map;

import com.superhero.netctoos.bean.OsdayBean;

/***
 * 按天查询账务账单持久层接口（读）
 * @author wyr 
 * 
 *
 */
public interface IOsDayQueryDao {
	/***
	 * 根据账务账号，业务账号，日期统计条数
	 * @param params
	 * @return
	 */
	int countOsDayQueryByParams(Map params);
	/***
	 * 根据账务账号，业务账号，日期查询当天的账务账单
	 * @param params
	 * @return
	 */
	List<OsdayBean> listOsDayQueryByParams(Map params);
}
