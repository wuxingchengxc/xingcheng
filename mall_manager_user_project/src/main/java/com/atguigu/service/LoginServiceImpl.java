package com.atguigu.service;



import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.mapper.LoginMapper;
import com.atguigu.utlis.MyDataSourceSwitch;
public class LoginServiceImpl implements LoginServiceInf {

	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public T_MALL_USER_ACCOUNT login_user_01(T_MALL_USER_ACCOUNT user) {
		MyDataSourceSwitch.setKey("1");
		
		T_MALL_USER_ACCOUNT login_user = loginMapper.select_user_01(user);
		MyDataSourceSwitch.clearKey();
		return login_user;
	}

	@Override
	public T_MALL_USER_ACCOUNT login_user_02(T_MALL_USER_ACCOUNT user) {
		MyDataSourceSwitch.setKey("2");
		T_MALL_USER_ACCOUNT login_user = loginMapper.select_user_01(user);
		MyDataSourceSwitch.clearKey();
		return login_user;
	}

}
