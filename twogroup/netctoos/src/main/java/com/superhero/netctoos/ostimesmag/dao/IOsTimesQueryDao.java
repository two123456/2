package com.superhero.netctoos.ostimesmag.dao;

import java.util.List;
import java.util.Map;


import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.bean.OstimesBean;

/***
 * 按月查询账务账单持久层接口 次（读）
 * @author wyr 
 * 
 *
 */
public interface IOsTimesQueryDao {
	/***
	 * 根据账务账号，业务账号，日期统计条数
	 * @param params
	 * @return
	 */
	int countOsTimesQueryByParams(Map params);
	/***
	 * 根据账务账号，业务账号，日期查询当天的账务账单
	 * @param params
	 * @return
	 */
	List<OstimesBean> listOsTimesQueryByParams(Map params);
}
