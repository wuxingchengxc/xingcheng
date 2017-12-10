package com.atguigu0210.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu0210.bean.MY_T_MALL_ATTR;
import com.atguigu0210.bean.T_MALL_PRODUCT;
import com.atguigu0210.bean.T_MALL_SKU;
import com.atguigu0210.bean.T_MALL_SKU_ATTR_VALUE;
import com.atguigu0210.mapper.SkuMapper;

@Service
public class SkuServiceImp implements SkuService {

	@Autowired
	SkuMapper skuMapper;

	@Override
	public List<MY_T_MALL_ATTR> get_attrs_by_class_2_id(int class_2_id) {
		
		List<MY_T_MALL_ATTR> attrs= skuMapper.select_attrs_by_class_2_id(class_2_id);
		
		return attrs;
	}

	@Override
	public List<T_MALL_PRODUCT> get_product_by_class_2_class_1_tm(String class_2_id, String class_1_id, String pp_id) {
		HashMap<String,Object> hashmap=new HashMap<>();
		hashmap.put("class_1_id", class_1_id);
		hashmap.put("pp_id", pp_id);
		hashmap.put("class_2_id", class_2_id);
		List<T_MALL_PRODUCT> list = skuMapper.select_product_by_class_2_class_1_tm(hashmap);
		return list;
	}

	@Override
	public void save_sku(List<T_MALL_SKU_ATTR_VALUE> new_list_attrs, T_MALL_SKU sku) {
		
		skuMapper.insert_sku(sku);
		
		HashMap<String,Object> hashmap =new  HashMap<>();
		hashmap.put("list_attrs", new_list_attrs);
		hashmap.put("sku_id", sku.getId());
		
		skuMapper.inset_sku_attr_value(hashmap);
		
	}


}
