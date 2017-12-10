package com.atguigu0210.mapper;

import com.atguigu0210.bean.T_MALL_USER;

public interface LoginMapper {

	int select_test();

	T_MALL_USER select_user_by_mch_mm(T_MALL_USER user);

}
