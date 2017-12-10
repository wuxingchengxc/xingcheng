package com.atguigu0210.service;

import java.util.List;

import com.atguigu0210.bean.MY_T_MALL_ATTR;
import com.atguigu0210.bean.T_MALL_PRODUCT;
import com.atguigu0210.bean.T_MALL_SKU;
import com.atguigu0210.bean.T_MALL_SKU_ATTR_VALUE;

public interface SkuService {

	public List<MY_T_MALL_ATTR> get_attrs_by_class_2_id(int class_2_id);

	public List<T_MALL_PRODUCT> get_product_by_class_2_class_1_tm(String class_2_id, String class_1_id, String pp_id);

	public void save_sku(List<T_MALL_SKU_ATTR_VALUE> new_list_attrs, T_MALL_SKU sku);
	
	
}
