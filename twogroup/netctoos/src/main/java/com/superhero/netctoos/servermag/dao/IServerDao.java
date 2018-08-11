package com.superhero.netctoos.servermag.dao;

import java.util.List;
import java.util.Map;

import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.ServerBean;

/***
 * 服务器持久层接口
 * @author gongtao
 *
 */
public interface IServerDao {
	   /***
     * 显示所有服务器
     * @param page
     * @return
     */
   List<ServerBean>listServerByparams(Map params);
	/***
	 * 统计所有服务器
	 * @return
	 */
	int countpagebean(Map params);
}
