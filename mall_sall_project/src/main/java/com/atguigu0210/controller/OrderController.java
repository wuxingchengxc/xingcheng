package com.atguigu0210.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.atguigu.bean.T_MALL_ADDRESS;
import com.atguigu0210.bean.T_MALL_ORDER;
import com.atguigu0210.bean.T_MALL_ORDER_INFO;
import com.atguigu0210.bean.T_MALL_SHOPPINGCAR;
import com.atguigu0210.bean.T_MALL_USER;

@Controller
@SessionAttributes("list_order_session")
public class OrderController {

	/**
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("goto_order")
	public String goto_order(Model model,HttpSession session) {
		//条转订单页面，先第一次进行拆单 
		T_MALL_USER user = (T_MALL_USER) session.getAttribute("login_user");
		if(user==null){
			//跳转去登录的新页面
			return "redirect:/sall_login_buy.do";
		}else{
			//取出订单数据
			List<T_MALL_SHOPPINGCAR> list_cart=(List<T_MALL_SHOPPINGCAR>)session.getAttribute("list_cart_session");
			//new 一个新的库存set集合
			HashSet<String> list_kcdz=new HashSet<>();
			//总的订单集合
			List<T_MALL_ORDER> list_order=new ArrayList<>();
			for (int i = 0; i < list_cart.size(); i++) {
				list_kcdz.add(list_cart.get(i).getKcdz());
			}
			
			Iterator<String> iterator = list_kcdz.iterator();
			while (iterator.hasNext()) {
				//每一个订单的库存地址
				String next = iterator.next();
				T_MALL_ORDER order =new T_MALL_ORDER();
				List<T_MALL_ORDER_INFO> list_order_info=new ArrayList<>();
				order.setYh_id(user.getId());
				order.setYh_id(user.getId());
				//总价格
				BigDecimal sum = new BigDecimal("0");
				for (int i = 0; i < list_cart.size(); i++) {
					if(list_cart.get(i).getKcdz().equals(next)&&list_cart.get(i).getShfxz().equals("1")){
						//商品详细信息
						T_MALL_ORDER_INFO order_info=new T_MALL_ORDER_INFO();
						//本单价格
						sum = sum.add(new BigDecimal(list_cart.get(i).getHj()+""));
						order_info.setGwch_id(list_cart.get(i).getId());
						order_info.setShp_tp(list_cart.get(i).getShp_tp());
						order_info.setSku_id(list_cart.get(i).getSku_id());
						order_info.setSku_jg(list_cart.get(i).getSku_jg());
						order_info.setSku_kcdz(list_cart.get(i).getKcdz());
						order_info.setSku_mch(list_cart.get(i).getSku_mch());
						order_info.setSku_shl(list_cart.get(i).getTjshl());
						
						list_order_info.add(order_info);
					}
				}
				order.setList_order_info(list_order_info);
				//存入当前订单数据
				list_order.add(order);
			}
			//存入当前contlloer session域中
			model.addAttribute("list_order_session", list_order);
		}
		return "redirect:/gato_sall_order.do";
	}
	
	@RequestMapping("gato_sall_order")
	public String gato_sall_order(Model map,@ModelAttribute("list_order_session")List<T_MALL_ORDER> list_order ){
		//获取用户地址信息
		T_MALL_ADDRESS addres =new T_MALL_ADDRESS();
		addres.setShjr("吴兴城");
		addres.setYh_dz("深证");
		//订单状态 1 
		addres.setDzzt("1");
		map.addAttribute("list_order",list_order );
		//地址信息
		map.addAttribute("list_addres",addres);
		
		
		return "sall_order";
	}
	
	@RequestMapping("save_order")
	public String save_order(int addresId,@ModelAttribute("list_order_session")List<T_MALL_ORDER> list_order,HttpSession session){
		//保存订单信息到DB
		//删除Session
		return null;
	}

}
