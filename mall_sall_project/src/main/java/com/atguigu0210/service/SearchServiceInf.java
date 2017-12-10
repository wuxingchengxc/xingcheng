package com.atguigu0210.service;

import java.util.List;

import com.atguigu0210.bean.MY_T_MALL_SKU;
import com.atguigu0210.bean.MY_T_MALL_SKU_ATTR_VALUE;
import com.atguigu0210.bean.OBJECT_MY_T_MALL_SKU;
import com.atguigu0210.bean.T_MALL_SKU;

public interface SearchServiceInf {

	public List<MY_T_MALL_SKU> get_sku_list_by_class_2_id(int class_2_id);

	public List<MY_T_MALL_SKU> get_sku_by_attr_value(String class_2_id, MY_T_MALL_SKU_ATTR_VALUE list_sku_attrs,String order);

	public List<T_MALL_SKU> get_list_sku_by_spu_id(int spu_id);

	public OBJECT_MY_T_MALL_SKU get_sku_detail_by_sku_id(int sku_id);

}
