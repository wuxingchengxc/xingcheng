package com.atguigu0210.service;

import java.util.List;

import com.atguigu0210.bean.LISR_MY_T_MALL_ATTR;
import com.atguigu0210.bean.MY_T_MALL_ATTR;

public interface AttrService {

	public List<MY_T_MALL_ATTR> get_Attrs_By_Class_2_Id(int class_2_id);
	
	public void save_attr(LISR_MY_T_MALL_ATTR list_attrs ,String class_2_id,String class_2_name);
}
