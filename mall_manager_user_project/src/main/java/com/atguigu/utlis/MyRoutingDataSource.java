package com.atguigu.utlis;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MyRoutingDataSource extends AbstractRoutingDataSource {
	
	
	
	protected Object determineCurrentLookupKey() {
		return MyDataSourceSwitch.getKey();
	}
	
	
	
}
