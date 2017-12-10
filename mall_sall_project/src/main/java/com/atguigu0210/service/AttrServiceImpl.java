package com.atguigu0210.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
