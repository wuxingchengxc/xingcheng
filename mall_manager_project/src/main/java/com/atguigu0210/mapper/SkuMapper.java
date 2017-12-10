package com.atguigu0210.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu0210.bean.MY_T_MALL_ATTR;
import com.atguigu0210.bean.T_MALL_PRODUCT;
import com.atguigu0210.bean.T_MALL_SKU;

public interface SkuMapper {


	List<MY_T_MALL_ATTR> select_attrs_by_class_2_id(@Param("class_2_id")int class_2_id);

	List<T_MALL_PRODUCT> select_product_by_class_2_class_1_tm(HashMap<String, Object> hashmap);

	void insert_sku(T_MALL_SKU sku);

	void inset_sku_attr_value(HashMap<String, Object> hashmap);


}
