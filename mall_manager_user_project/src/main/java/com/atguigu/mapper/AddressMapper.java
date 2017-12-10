package com.atguigu.mapper;

import java.util.List;

import com.atguigu.bean.T_MALL_ADDRESS;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;


public interface AddressMapper {

	void insert_address_01(T_MALL_ADDRESS address);

	List<T_MALL_ADDRESS> select_addresses_by_user_id(T_MALL_USER_ACCOUNT user);

	T_MALL_ADDRESS select_addresses_by_id(int address_id);

}
