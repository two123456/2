package com.superhero.netctoos.osmonthmag.dao;

import java.util.List;
import java.util.Map;


import com.superhero.netctoos.bean.OsmonthBean;

/***
 * 按月查询账务账单持久层接口（读）
 * @author wyr 
 * 
 *
 */
public interface IOsMonthQueryDao {
	/***
	 * 根据账务账号，业务账号，日期统计条数
	 * @param params
	 * @return
	 */
	int countOsMonthQueryByParams(Map params);
	/***
	 * 根据账务账号，业务账号，日期查询当天的账务账单
	 * @param params
	 * @return
	 */
	List<OsmonthBean> listOsMonthQueryByParams(Map params);
}
