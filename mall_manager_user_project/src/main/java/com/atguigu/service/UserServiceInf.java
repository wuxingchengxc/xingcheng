package com.atguigu.service;

import javax.jws.WebService;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;


@WebService
public interface UserServiceInf {

	public String regist_01(T_MALL_USER_ACCOUNT user);
}
