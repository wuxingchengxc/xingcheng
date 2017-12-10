package com.atguigu.service;

import javax.jws.WebService;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;

@WebService
public interface LoginServiceInf {

	public T_MALL_USER_ACCOUNT login_user_01(T_MALL_USER_ACCOUNT user);

	public T_MALL_USER_ACCOUNT login_user_02(T_MALL_USER_ACCOUNT user);

}
