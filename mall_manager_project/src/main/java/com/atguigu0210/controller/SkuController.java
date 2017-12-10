package com.atguigu0210.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu0210.bean.MY_T_MALL_ATTR;
import com.atguigu0210.bean.MY_T_MALL_SKU_ATTR_VALUE;
import com.atguigu0210.bean.T_MALL_PRODUCT;
import com.atguigu0210.bean.T_MALL_SKU;
import com.atguigu0210.bean.T_MALL_SKU_ATTR_VALUE;
import com.atguigu0210.service.SkuService;

@Controller
public class SkuController {

	@Autowired
	SkuService skuService;
	
	@RequestMapping("goto_sku_publish")
	public String goto_sku_publish() {
		return "manager_sku_publish";
	}

	@RequestMapping("get_attr_sku")
	public String get_attr_sku(String class_2_id,Model model){
		//内部页面
		class_2_id="14";
		List<MY_T_MALL_ATTR> list_attrs = skuService.get_attrs_by_class_2_id(Integer.parseInt(class_2_id));
		model.addAttribute("attrs", list_attrs);
		return "manager_sku_inner";
	}
	
	@ResponseBody
	@RequestMapping("get_product")
	public List<T_MALL_PRODUCT> get_product(String class_2_id,String class_1_id,String pp_id,Model model){
		//查询
		class_2_id="14";
		class_1_id="7";
		pp_id="1";
		List<T_MALL_PRODUCT> list_product=skuService.get_product_by_class_2_class_1_tm(class_2_id,class_1_id,pp_id);
		return list_product;
	}
	
	@RequestMapping("sava_sku")
	public String sava_sku(String shp_id,T_MALL_SKU sku,MY_T_MALL_SKU_ATTR_VALUE list_sku_attrs){
		//处理参数
		List<T_MALL_SKU_ATTR_VALUE> list_sku_attrs2 = list_sku_attrs.getList_sku_attrs();
		List<T_MALL_SKU_ATTR_VALUE> new_list_attrs=new ArrayList<>();
		for (T_MALL_SKU_ATTR_VALUE t_MALL_SKU_ATTR_VALUE : list_sku_attrs2) {
			
			if(t_MALL_SKU_ATTR_VALUE.getShxm_id()!=0){
				T_MALL_SKU_ATTR_VALUE  attr=new T_MALL_SKU_ATTR_VALUE();
				attr.setShp_id(Integer.parseInt(shp_id));
				attr.setShxm_id(t_MALL_SKU_ATTR_VALUE.getShxm_id());
				attr.setShxzh_id(t_MALL_SKU_ATTR_VALUE.getShxzh_id());
				new_list_attrs.add(attr);
			}
		}
			
		skuService.save_sku(new_list_attrs,sku);
		
		
		return "redirect:/goto_sku_publish.do";
	}
	
	
	
}
