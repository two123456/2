package com.superhero.netctoos.servermag.queryservice;
/***
 * 服务器业务层接口
 * @author gongtao
 *
 */

import java.util.Map;

import com.superhero.netctoos.bean.PageBean;

public interface IServerQueryService {
  /***
   * 显示所有数据
   * @param page 
   * @param params
   * @return
   */
	public PageBean getServiceAll(PageBean page ,Map params);
	
}
