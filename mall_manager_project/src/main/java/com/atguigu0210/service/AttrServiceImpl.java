package com.atguigu0210.service;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu0210.bean.LISR_MY_T_MALL_ATTR;
import com.atguigu0210.bean.MY_T_MALL_ATTR;
import com.atguigu0210.mapper.AttrMapper;

@Service
public class AttrServiceImpl implements AttrService{

	@Autowired 
	private AttrMapper attrMapper;
	
	@Override
	public List<MY_T_MALL_ATTR> get_Attrs_By_Class_2_Id(int class_2_id) {
		//查询出当前编号的属性
		List<MY_T_MALL_ATTR> attrs= attrMapper.select_Attrs_By_Class_2_Id(class_2_id);
		
		return attrs;
	}

	@Override
	public void save_attr(LISR_MY_T_MALL_ATTR list_attrs, String class_2_id, String class_2_name) {
		//添加属性
		List<MY_T_MALL_ATTR> list_my_mall_attr = list_attrs.getList_my_mall_attr();
		for (MY_T_MALL_ATTR my_T_MALL_ATTR : list_my_mall_attr) {
			my_T_MALL_ATTR.setFlbh2(Integer.parseInt(class_2_id));
			//添加属性
			 attrMapper.insert_attr(my_T_MALL_ATTR);
			//添加属性值
			HashMap<String,Object> hashMap=new HashMap<>();
			hashMap.put("shxm_id", my_T_MALL_ATTR.getId());
			hashMap.put("class_2_id", class_2_id);
			hashMap.put("list_value", my_T_MALL_ATTR.getValues());
			attrMapper.insert_attr_value(hashMap);
		}
		
	}

}
