package com.superhero.netctoos.servermag.queryservice.impl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.bean.ServerBean;
import com.superhero.netctoos.servermag.dao.IServerDao;
import com.superhero.netctoos.servermag.queryservice.IServerQueryService;
/***
 * 服务器业务层实现类
 * @author gongtao
 *
 */
@Service
public class ServerQueryServiceImpl implements IServerQueryService {
    @Resource
	private IServerDao serverdao;
	
	
	@Override
	public PageBean getServiceAll(PageBean page, Map params) {
		// TODO Auto-generated method stub
		int totalRows=serverdao.countpagebean(params);
		if (totalRows>0) {
			params.put("index", page.getIndex());
			params.put("rows",page.getLimit());
			List<ServerBean> datas=serverdao.listServerByparams(params);
			page.setCount(totalRows);
			page.setData(datas);			
		}
		return page;
   }
	
}
