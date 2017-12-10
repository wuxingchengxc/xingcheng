package com.atguigu0210.controller;


import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu0210.bean.MY_T_MALL_ATTR;
import com.atguigu0210.bean.MY_T_MALL_SKU;
import com.atguigu0210.bean.MY_T_MALL_SKU_ATTR_VALUE;
import com.atguigu0210.bean.OBJECT_MY_T_MALL_SKU;
import com.atguigu0210.bean.T_MALL_SKU;
import com.atguigu0210.service.AttrService;
import com.atguigu0210.service.SearchServiceInf;


@Controller
public class SearchController {

	@Autowired
	SearchServiceInf searchService;
	
	@Autowired
	AttrService attrService;
	
	@RequestMapping("get_sku_detail_by_sku_id")
	public String get_sku_detail_by_sku_id(Model model,int sku_id,int spu_id){
		//查询当前SPU关联的SKU 信息
		List<T_MALL_SKU> list_sku=searchService.get_list_sku_by_spu_id(spu_id);
		//根据SKU_ID查询相关详情
		OBJECT_MY_T_MALL_SKU sku_detail=searchService.get_sku_detail_by_sku_id(sku_id);
		
		model.addAttribute("sku_detail",sku_detail);
		model.addAttribute("list_sku", list_sku);
		
		return "sall_search_detail";
	}
	
	
	@RequestMapping("goto_sku_search")
	public String goto_sku_search(String class_2_id,ModelMap map,String class_2_name) {
		 class_2_id="14";
		List<MY_T_MALL_SKU> list_sku = searchService.get_sku_list_by_class_2_id(Integer.parseInt(class_2_id));
		
		List<MY_T_MALL_ATTR> attrs = attrService.get_Attrs_By_Class_2_Id(Integer.parseInt(class_2_id));
		
		map.put("class_2_id", class_2_id);
		map.put("attrs", attrs);
		map.put("list_sku", list_sku);
		return "sall_search";
	}
	
	
	@RequestMapping("get_sku_by_attr_value")
	public String get_sku_by_attr_value(String class_2_id,MY_T_MALL_SKU_ATTR_VALUE list_sku_attrs,Model model,String order){
		//查询后台根据属性名
		List<MY_T_MALL_SKU> list_sku=searchService.get_sku_by_attr_value(class_2_id,list_sku_attrs,order);
		model.addAttribute("list_sku",list_sku );
		return "sall_search_inner";
	}
	
	
	
}
