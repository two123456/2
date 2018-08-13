package com.superhero.netctoos.osyearmag.dao;

import java.util.List;
import java.util.Map;


import com.superhero.netctoos.bean.OsmonthBean;

/***
 * 按月查询账务账单持久层接口（读）
 * @author wyr 
 * 
 *
 */
public interface IOsYearQueryDao {
	/***
	 * 根据账务账号，业务账号，日期统计条数
	 * @param params
	 * @return
	 */
	int countOsYearQueryByParams(Map params);
	/***
	 * 根据账务账号，业务账号，日期查询当天的账务账单
	 * @param params
	 * @return
	 */
	List<OsmonthBean> listOsYearQueryByParams(Map params);
}
