package com.atguigu0210.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu0210.bean.T_MALL_PRODUCT;
import com.atguigu0210.mapper.SpuMapper;
@Service
public class SpuServiceImpl implements SpuService {

	@Autowired
	SpuMapper spuMapper;
	
	
	public void save_spu(T_MALL_PRODUCT spu, List<String> list_images) {
		//保存一个对象并且返回主键
		spuMapper.insert_spu(spu);
		//主键ID
		int id = spu.getId();
		//批量插入商品图片根据主键
		Map<String,Object> hashMap=new HashMap<>();
		hashMap.put("shp_id",id);
		hashMap.put("list_images",list_images);
		spuMapper.insert_spu_image(hashMap);
	}

}
