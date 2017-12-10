package com.atguigu0210.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.common.util.ModCountCopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu0210.bean.T_MALL_SHOPPINGCAR;
import com.atguigu0210.bean.T_MALL_USER;
import com.atguigu0210.service.CartServiceImp;
import com.atguigu0210.util.MyJsonUtil;

@Controller
public class CartController {

	@Autowired 
	private CartServiceImp cartService;
	
	@RequestMapping("sall_update_car")
	public String sall_update_car(T_MALL_SHOPPINGCAR car,ModelMap map,HttpSession session,
			@CookieValue(value="json_cart",required=false)String list_car_cookie,HttpServletResponse response){
		//登录和未登录
		T_MALL_USER user = (T_MALL_USER)session.getAttribute("login_user");
		List<T_MALL_SHOPPINGCAR> list_cart=new ArrayList<>();
		if(user==null){
			//未登录去cookie中获取数据
			if(!StringUtils.isEmpty(list_car_cookie)){
				list_cart = MyJsonUtil.json_to_list(list_car_cookie,new T_MALL_SHOPPINGCAR());
			}
		}else{
			//登录过从session中获取数据
			list_cart=(List<T_MALL_SHOPPINGCAR>)session.getAttribute("list_cart_session");
		}
		//修改购物车数据
		for (int i = 0; i < list_cart.size(); i++) {
			//是否为同一件商品
			if(list_cart.get(i).getSku_id()==car.getSku_id()){
				if(car.getShfxz().equals("-1")&&car.getTjshl()!=-1){
					//加数量修改  合计修改
					list_cart.get(i).setTjshl(car.getTjshl());
					list_cart.get(i).setHj(list_cart.get(i).getSku_jg()*list_cart.get(i).getTjshl());
				}else{
					list_cart.get(i).setShfxz(car.getShfxz());
				}
			}
		}
		if(user==null){
			//未登录同步Cookie
			String cookie_json = MyJsonUtil.object_to_json(list_cart);
			Cookie cookie = new Cookie("json_cart", cookie_json);
			cookie.setMaxAge(60*60*60);
			response.addCookie(cookie);
		}else{
			//登录同步Session
		}
		//计算总金额
		BigDecimal sum =new BigDecimal("0");
		sum = get_cart_sum(list_cart);
		map.put("sum", sum);
		map.put("list_cart", list_cart);
		return "sall_cart_list_inner";
	}
	/**
	 * 计算总金额
	 */
	private BigDecimal get_cart_sum(List<T_MALL_SHOPPINGCAR> list_car) {
		BigDecimal sum =new BigDecimal("0");
		for (int i = 0; i < list_car.size(); i++) {
			if(list_car.get(i).getShfxz().equals("1")){
			sum=sum.add(new BigDecimal(list_car.get(i).getHj()+""));
			}
		}
		return sum;
	}
	@RequestMapping("goto_cart_list")
	public String goto_cart_list(@CookieValue(value="json_cart",required=false)String list_car_cookie
			,ModelMap map,HttpSession session){
		//跳转购物车结算页面
		//获取当前购物车信息
		T_MALL_USER user = (T_MALL_USER)session.getAttribute("login_user");
		List<T_MALL_SHOPPINGCAR> list_cart=new ArrayList<>();
		if(user==null){
			//未登录去cookie中获取数据
			if(!StringUtils.isEmpty(list_car_cookie)){
				list_cart = MyJsonUtil.json_to_list(list_car_cookie,new T_MALL_SHOPPINGCAR());
			}
		}else{
			//登录过从session中获取数据
			list_cart=(List<T_MALL_SHOPPINGCAR>)session.getAttribute("list_cart_session");
		}
		map.put("list_cart", list_cart);
		return "sall_cart_list";
	}
	
	@RequestMapping("get_minicart")
	public String get_minicart(@CookieValue(value="json_cart",required=false)String list_car_cookie
			,ModelMap map,HttpSession session){
		T_MALL_USER user = (T_MALL_USER)session.getAttribute("login_user");
		List<T_MALL_SHOPPINGCAR> list_cart=new ArrayList<>();
		if(user==null){
			//未登录去cookie中获取数据
			if(!StringUtils.isEmpty(list_car_cookie)){
				list_cart = MyJsonUtil.json_to_list(list_car_cookie,new T_MALL_SHOPPINGCAR());
			}
		}else{
			//登录过从session中获取数据
			list_cart=(List<T_MALL_SHOPPINGCAR>)session.getAttribute("list_cart_session");
		}
		map.put("list_cart", list_cart);
		return "sall_mini_cart_inner";
	}
	
	@RequestMapping("add_cart")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response,Model model,T_MALL_SHOPPINGCAR car,HttpSession session) {
		//用户登陆还是未登录 
		T_MALL_USER login_user =(T_MALL_USER)session.getAttribute("login_user");
		
		if(login_user==null){
			//有无cookie
			String json_cart="";
			Cookie[] cookies = request.getCookies();
			if(cookies==null){
				//创建一个新的数组
				List<T_MALL_SHOPPINGCAR> list_car =new ArrayList<>();
				list_car.add(car);
				//car转换成json
				json_cart=MyJsonUtil.object_to_json(list_car);
				//新建一个cookie cookie里面存储购物车相关的字符串
				Cookie cookie=new Cookie("json_cart",json_cart);
				//设置过期时间
				cookie.setMaxAge(60 * 60 * 24 * 30);
				//返回给客户端
				response.addCookie(cookie);
			}else {
				List<T_MALL_SHOPPINGCAR> list_cart =new ArrayList<>();
				String cookies_json="";
				for (int i = 0; i < cookies.length; i++) {
					//判断是不是我们需要的数据
					if(cookies[i].getName().equals("json_cart")){
						cookies_json=cookies[i].getValue();
					}
				}
				
				if(!cookies_json.equals("")){
					//转换成集合
					list_cart = MyJsonUtil.json_to_list(cookies_json, car);
					//cookies中有数据 负责更新数据
					Boolean b=is_new_car(list_cart,car);
					if(b){
						//是老数据
						for (int i = 0; i < list_cart.size(); i++) {
							if(list_cart.get(i).getSku_mch().equals(car.getSku_mch())){
								//更新数量
								list_cart.get(i).setTjshl(list_cart.get(i).getTjshl()+car.getTjshl());
								list_cart.get(i).setHj(car.getSku_jg() * list_cart.get(i).getTjshl());
							}
						}
					}else{
						list_cart.add(car);
					}
					
				}else{
					//购物车中没有数据
					list_cart.add(car);
				}
				//将json存到cookie中
				String list_json = MyJsonUtil.object_to_json(list_cart);
				Cookie cookie=new Cookie("json_cart",list_json);
				//设置过期时间
				cookie.setMaxAge(60 * 60 * 24 * 30);
				//返回给客户端
				response.addCookie(cookie);
			}
		}else{
			//用户已登录操作session
			car.setYh_id(login_user.getId());
			List<T_MALL_SHOPPINGCAR> list_cart=new ArrayList<>();
			list_cart = (List<T_MALL_SHOPPINGCAR>)session.getAttribute("list_cart_session");
			if(list_cart==null||list_cart.size()==0){
				//session中没有数据
				//插入一条新数据
				cartService.add_cart(car);
				list_cart=new ArrayList<>();
				list_cart.add(car);
				//新建session
				session.setAttribute("list_cart_session", list_cart);
			}else{
				//内容里面含有数据判断是新数据还是老数据
				Boolean b = is_new_car(list_cart,car);
				
				if(b){
					//这是老数据
					for (int i = 0; i < list_cart.size(); i++) {
						if(list_cart.get(i).getSku_id()==car.getSku_id()){
							//数量相加
							list_cart.get(i).setTjshl(list_cart.get(i).getTjshl()+car.getTjshl());
							list_cart.get(i).setHj(car.getSku_jg() * list_cart.get(i).getTjshl());
							//更新DB层
							cartService.update_car(list_cart.get(i));
						}
					}
					//同步session 由于SESSION中已经存在集合故不必写 set
				}else{
					//添加一条,主键返回
					cartService.add_cart(car);
					//这是新数据
					list_cart.add(car);
					//同步session
				}
				
				
			}
		}
		//跳转结算页面
		ModelAndView modelAndView = new ModelAndView("redirect:/cart_success.do");
		modelAndView.addObject(car);
		
		return modelAndView;
	}

	private Boolean is_new_car(List<T_MALL_SHOPPINGCAR> list_car, T_MALL_SHOPPINGCAR car) {
		boolean b = false;

		for (int i = 0; i < list_car.size(); i++) {
			if (car.getSku_id() == list_car.get(i).getSku_id()) {
				b = true;
			}
		}
		return b;
	}
	
	@RequestMapping("cart_success")
	public String cart_success(@CookieValue(value="json_cart",required=false)String list_car_cookie
			,ModelMap map,HttpSession session) {
		T_MALL_USER user = (T_MALL_USER)session.getAttribute("login_user");
		List<T_MALL_SHOPPINGCAR> list_cart=new ArrayList<>();
		if(user==null){
			//未登录去cookie中获取数据
			if(!StringUtils.isEmpty(list_car_cookie)){
				list_cart = MyJsonUtil.json_to_list(list_car_cookie,new T_MALL_SHOPPINGCAR());
			}
		}else{
			//登录过从session中获取数据
			list_cart=(List<T_MALL_SHOPPINGCAR>)session.getAttribute("list_cart_session");
		}
		map.put("list_cart", list_cart);
		return "sall_cart_list";
	}

}
