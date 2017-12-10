package com.atguigu0210.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu0210.bean.MY_T_MALL_SKU;
import com.atguigu0210.bean.T_MALL_SHOPPINGCAR;

public interface CartMapper {

	int select_test();

	void insert_cart(T_MALL_SHOPPINGCAR car);

	void update_car(T_MALL_SHOPPINGCAR car);

	List<T_MALL_SHOPPINGCAR> select_list_car_by_user_id(@Param("yh_id")int yh_id);


}
