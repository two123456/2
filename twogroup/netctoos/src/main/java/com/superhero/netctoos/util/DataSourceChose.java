package com.superhero.netctoos.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 数据源选择类，用来动态的选择数据源
 * @author star
 *
 */
public class DataSourceChose extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return HandleDataSource.getDataSource();
	}
	
}
