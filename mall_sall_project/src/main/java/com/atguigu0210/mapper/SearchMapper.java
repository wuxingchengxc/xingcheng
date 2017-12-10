package com.atguigu0210.mapper;

import java.util.HashMap;
import java.util.List;

import com.atguigu0210.bean.MY_T_MALL_SKU;
import com.atguigu0210.bean.OBJECT_MY_T_MALL_SKU;
import com.atguigu0210.bean.T_MALL_SKU;

public interface SearchMapper {


	List<MY_T_MALL_SKU> select_sku_list_by_class_2_id(int class_2_id);

	List<MY_T_MALL_SKU> select_sku_list_by_attr_value(HashMap<String, Object> map);

	List<T_MALL_SKU> select_list_sku_by_spu_id(int spu_id);

	OBJECT_MY_T_MALL_SKU select_sku_detail_by_sku_id(int sku_id);


}
