package com.atguigu0210.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu0210.bean.T_MALL_USER;
import com.atguigu0210.util.MyJsonUtil;

@Controller
public class IndexController {

	@RequestMapping("index")
	public String index(HttpServletRequest request,Model model) {
		Cookie[] cookies = request.getCookies();
		T_MALL_USER user=null;
		if(cookies.length>0&&cookies!=null){
			//遍历COOKIES
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("login_user")){
				//解码
					String value = cookies[i].getValue();
					user = MyJsonUtil.json_to_Object(value, T_MALL_USER.class);
					
				}
				
			}
			
		}
		if(user!=null){
			model.addAttribute("yh_nch", user.getYh_nch());
		}
		
		return "sall_index";
	}

}
