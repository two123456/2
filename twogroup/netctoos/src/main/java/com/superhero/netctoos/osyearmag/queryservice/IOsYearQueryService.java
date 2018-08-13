package com.superhero.netctoos.osyearmag.queryservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.superhero.netctoos.bean.OsmonthBean;
import com.superhero.netctoos.bean.OsyearBean;
import com.superhero.netctoos.bean.PageBean;

public interface IOsYearQueryService {
	/**
	 * 根据年和账务账号模糊查询
	 * @param page
	 * @param map
	 * @return
	 */
	public PageBean getOsYearByAccountAndYear(PageBean page,Map<String, Object> map);
	
	/**
	 * 根据业务账号和年份查询业务账号年账单信息
	 * @param map 查询条件集合
	 * @return 业务账号年账单对象
	 */
	public List<OsmonthBean> getOsyearByOsAndYear(Map<String, Object> map);
}
