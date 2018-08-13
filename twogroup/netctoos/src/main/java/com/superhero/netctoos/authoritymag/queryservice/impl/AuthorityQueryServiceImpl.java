package com.superhero.netctoos.authoritymag.queryservice.impl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.superhero.netctoos.authoritymag.dao.IAuthorityQueryDao;
import com.superhero.netctoos.authoritymag.queryservice.IAuthorityQueryService;
import com.superhero.netctoos.bean.AuthorityBean;
import com.superhero.netctoos.bean.PageBean;
/**
 * 权限管理读取 业务层实现类
 * @author Administrator
 *
 */
@Service
public class AuthorityQueryServiceImpl implements IAuthorityQueryService{
	
	@Resource
	private IAuthorityQueryDao authorityDaoImpl;

	@Override
	public PageBean getAllAuthority(Map params,PageBean page) {
		// TODO Auto-generated method stub
		int totalRows=authorityDaoImpl.countpage(params);
		if (totalRows>0) {
			params.put("index",page.getIndex());
			params.put("rows",page.getLimit());
			List <AuthorityBean> datas=authorityDaoImpl.listAuthorityByparams(params);
			page.setCount(totalRows);
			page.setData(datas);			
		}
		return page;
	}
	@Override
	public AuthorityBean getAuthorityById(Long id) {
		// TODO Auto-generated method stub
		return authorityDaoImpl.getAuthorityById(id);
	}

}
