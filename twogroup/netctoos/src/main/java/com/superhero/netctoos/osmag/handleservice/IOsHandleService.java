package com.superhero.netctoos.osmag.handleservice;

import com.superhero.netctoos.bean.OsBean;

public interface IOsHandleService {
	/**
	 * 新增业务账号
	 * @param os
	 */
	public void saveOsBean(OsBean os);
	/**
	 * 修改业务账号
	 * @param os
	 */
	public void updateOsBean(OsBean os);
	/**
	 * 删除业务账号
	 * @param os
	 */
	public void deleteOsBean(OsBean os);

}
