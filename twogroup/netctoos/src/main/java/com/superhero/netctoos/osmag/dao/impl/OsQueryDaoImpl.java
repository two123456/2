package com.superhero.netctoos.osmag.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.superhero.netctoos.bean.OsBean;
import com.superhero.netctoos.bean.PageBean;
import com.superhero.netctoos.osmag.dao.IOsQueryDao;
import com.superhero.netctoos.osmag.mapper.OsMapper;

@Repository
public class OsQueryDaoImpl implements IOsQueryDao {

	@Resource
	private OsMapper mapper;

	@Override
	public PageBean getOsBeanByItem(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int count = mapper.getOsBeanCount(map);
		List<OsBean> list = new ArrayList<>();
		if (count != 0) {
			list = mapper.getOsBeanByItem(map);
		}
		PageBean page = new PageBean();
		page.setCount(count);
		page.setData(list);

		return page;
	}

}
