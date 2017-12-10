package com.atguigu0210.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu0210.bean.T_MALL_SHOPPINGCAR;
import com.atguigu0210.mapper.CartMapper;
import com.atguigu0210.mapper.IndexMapper;

@Service
public class CartServiceImp implements IndexServiceInf {

	@Autowired
	CartMapper cartMapper;

	@Override
	public int test() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void add_cart(T_MALL_SHOPPINGCAR car) {
		//插入CAR对象并且返回主键
		cartMapper.insert_cart(car);
	}

	public void update_car(T_MALL_SHOPPINGCAR car) {
		
		cartMapper.update_car(car);
	}

	public List<T_MALL_SHOPPINGCAR> get_list_car_by_user_id(int id) {
		List<T_MALL_SHOPPINGCAR> list_car=cartMapper.select_list_car_by_user_id(id);
		return list_car;
	}

}
