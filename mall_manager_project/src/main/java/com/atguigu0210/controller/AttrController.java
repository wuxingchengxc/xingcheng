package com.atguigu0210.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu0210.bean.LISR_MY_T_MALL_ATTR;
import com.atguigu0210.bean.MY_T_MALL_ATTR;
import com.atguigu0210.service.AttrServiceImpl;

@Controller
public class AttrController {

	@Autowired
	private AttrServiceImpl attrServiceImpl;
	
	@RequestMapping("goto_attr_publish")
	public String goto_attr_publish(){
		return "manager_attr_publish";
	}
	@RequestMapping("get_attr")
	public String get_attr(int class_2_id,String class_2_name,ModelMap map){
		//	
		class_2_id=6;
		List<MY_T_MALL_ATTR> attrs=attrServiceImpl.get_Attrs_By_Class_2_Id(class_2_id);
		map.put("attrs", attrs);
		map.put("class_2_id", class_2_id);
		map.put("class_2_name", class_2_name);
		return "manager_attr_inner";
	}
	
	@RequestMapping("goto_attr_add")
	public String save_attr(int class_2_id,String class_2_name,ModelMap map){
		map.put("class_2_id", class_2_id);
		map.put("class_2_name", class_2_name);
		return "manager_attr_add";
	}
	
	@RequestMapping("save_attr")
	public ModelAndView save_attr(LISR_MY_T_MALL_ATTR list_attrs ,String class_2_id,String class_2_name){
		//保存
		attrServiceImpl.save_attr(list_attrs ,class_2_id,class_2_name);
		
		ModelAndView mv =new ModelAndView("redirect:/goto_attr_add.do");
		mv.addObject("class_2_id",class_2_id);
		mv.addObject("class_2_name", class_2_name);
		return mv;
	}
	
	
}
