package com.atguigu0210.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu0210.bean.MY_T_MALL_SKU;
import com.atguigu0210.bean.MY_T_MALL_SKU_ATTR_VALUE;
import com.atguigu0210.bean.OBJECT_MY_T_MALL_SKU;
import com.atguigu0210.bean.T_MALL_SKU;
import com.atguigu0210.bean.T_MALL_SKU_ATTR_VALUE;
import com.atguigu0210.mapper.IndexMapper;
import com.atguigu0210.mapper.SearchMapper;

@Service
public class SearchServiceImp implements SearchServiceInf {

	@Autowired
	SearchMapper searchMapper;

	@Override
	public List<MY_T_MALL_SKU> get_sku_list_by_class_2_id(int class_2_id) {
		
		List<MY_T_MALL_SKU> list_skus=searchMapper.select_sku_list_by_class_2_id(class_2_id);
		return list_skus;
	}

	@Override
	public List<MY_T_MALL_SKU> get_sku_by_attr_value(String class_2_id, MY_T_MALL_SKU_ATTR_VALUE list_sku_attrs,String order) {
		//弄出SQL 存入
		List<T_MALL_SKU_ATTR_VALUE> list_sku_all_attrs = list_sku_attrs.getList_sku_attrs();
		HashMap<String,Object> map=new HashMap<>();
		if(list_sku_all_attrs!=null&&list_sku_all_attrs.size()>0){
		
		
		StringBuffer sbf=new StringBuffer();
			//拼接sql
			sbf.append(" and sku.Id in ( select sku_1.sku_id from ");
			for (int i = 0; i < list_sku_all_attrs.size(); i++) {
				sbf.append(" (select sku_id from t_mall_sku_attr_value where shxm_id='"+list_sku_all_attrs.get(i).getShxm_id()+"' and shxzh_id='"+list_sku_all_attrs.get(i).getShxzh_id()+"' ");
				sbf.append(" ) sku_"+(1+i));
				if(i<list_sku_all_attrs.size()-1){
					sbf.append(" , ");
				}
			}
			if(list_sku_all_attrs.size()>1){
				sbf.append(" where " );
				for(int i=0;i< list_sku_all_attrs.size()-1; i++){
					sbf.append(" sku_"+(i+1)+".sku_id ="+" sku_"+(i+2)+".sku_id");
					if(i<list_sku_all_attrs.size()-2){
						sbf.append(" and ");
					}
				}
			}
			sbf.append(" ) ");
			map.put("sql", sbf.toString());
		
		}
		map.put("order", order);
		map.put("class_2_id", Integer.parseInt(class_2_id));
		//调用mapper层 
		List<MY_T_MALL_SKU> list_sku=searchMapper.select_sku_list_by_attr_value(map);
		return list_sku;
	}

	@Override
	public List<T_MALL_SKU> get_list_sku_by_spu_id(int spu_id) {
		List<T_MALL_SKU> list_sku=searchMapper.select_list_sku_by_spu_id(spu_id);
		return list_sku;
	}

	@Override
	public OBJECT_MY_T_MALL_SKU get_sku_detail_by_sku_id(int sku_id) {
		OBJECT_MY_T_MALL_SKU sku_detail=searchMapper.select_sku_detail_by_sku_id(sku_id);
		return sku_detail;
	}

}
