package com.atguigu0210.util;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.FactoryBean;

public class MyWsServiceBean<T> implements FactoryBean<T> {

	private String url;
	private Class<T> t;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Class<T> getT() {
		return t;
	}

	public void setT(Class<T> t) {
		this.t = t;
	}
	
	public static  <T> T getMyServiceBean(String url ,Class<T> t){
		
		JaxWsProxyFactoryBean proxy=new JaxWsProxyFactoryBean();
		proxy.setAddress(url);
		proxy.setServiceClass(t);
		T create = (T)proxy.create();
		return create;
	}

	public T getObject() throws Exception {
		T myServiceBean = getMyServiceBean(url,t);
		return myServiceBean;
	}

	@Override
	public Class<?> getObjectType() {
		return t;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	
	
}
