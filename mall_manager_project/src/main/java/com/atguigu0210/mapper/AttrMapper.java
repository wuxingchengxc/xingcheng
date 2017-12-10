package com.atguigu0210.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu0210.bean.MY_T_MALL_ATTR;

public interface AttrMapper {

	List<MY_T_MALL_ATTR> select_Attrs_By_Class_2_Id(@Param("class_2_id") int class_2_id);

	void insert_attr(MY_T_MALL_ATTR my_T_MALL_ATTR);

	void insert_attr_value(HashMap<String, Object> hashMap);
}
