package com.atguigu0210.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.bean.T_MALL_ADDRESS;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.service.LoginServiceInf;

@Controller
public class TestController {

	@Autowired
	LoginServiceInf loginServiceInf;
	
	@RequestMapping("ws_login_user")
	public String ws_login_user(){
		T_MALL_USER_ACCOUNT user = new T_MALL_USER_ACCOUNT();
		user.setYh_mch("test");
		user.setYh_mm("123");;
		T_MALL_USER_ACCOUNT login_user_01 = loginServiceInf.login_user_01(user);
		T_MALL_USER_ACCOUNT user2 = new T_MALL_USER_ACCOUNT();
		user2.setYh_mch("qwer");
		user2.setYh_mm("123");
		T_MALL_USER_ACCOUNT login_user_02 = loginServiceInf.login_user_02(user2);
		return null;
	}
	
}
