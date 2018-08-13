package com.superhero.netctoos.osyearmag.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;


import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.bean.OsyearBean;

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
	/**
	 * 根据业务账号和年份查询业务账号年账单信息
	 * @param map 查询条件集合
	 * @return 业务账号年账单对象
	 */
	List<OsmonthBean> getOsyearByOsAndYear(Map<String, Object> map);
}
