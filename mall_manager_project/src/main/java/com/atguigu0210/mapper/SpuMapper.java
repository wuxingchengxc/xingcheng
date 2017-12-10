package com.atguigu0210.mapper;

import java.util.Map;

import com.atguigu0210.bean.T_MALL_PRODUCT;

public interface SpuMapper {

	void insert_spu(T_MALL_PRODUCT spu);
	
	void insert_spu_image(Map<String, Object> hashMap);
	
}
