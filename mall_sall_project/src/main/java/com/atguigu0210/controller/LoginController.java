package com.atguigu0210.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.service.LoginServiceInf;
import com.atguigu0210.bean.T_MALL_SHOPPINGCAR;
import com.atguigu0210.bean.T_MALL_USER;
import com.atguigu0210.mapper.LoginMapper;
import com.atguigu0210.service.CartServiceImp;
import com.atguigu0210.util.MyJsonUtil;
import com.sun.istack.Interned;

@Controller
public class LoginController {

	@Autowired 
	private CartServiceImp cartService;	
	
	
	@Autowired
	LoginMapper loginMapper;
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "sall_index";
	}

	@RequestMapping("goto_login")
	public String goto_login(){
		
		return "sall_login";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("loginmysql")
	public String loginmysql (@CookieValue(value="json_cart",required=false)String json_cart ,HttpServletRequest req
			,T_MALL_USER user,HttpServletResponse responese,Model model,HttpSession session){
		//查询当前用户是否存在
		T_MALL_USER login_user =new T_MALL_USER();
		login_user.setId(3);
		login_user.setYh_nch("大头哥");
		//T_MALL_USER login_user=loginMapper.select_user_by_mch_mm(user);
		
		if(login_user!=null){
			//存在
			session.setAttribute("login_user", login_user);
			//保存用户信息
			add_yh_nch(responese,login_user);
			//同步cookie到db
			//查询出当前用户的DB信息
			List<T_MALL_SHOPPINGCAR> list_car_db=cartService.get_list_car_by_user_id(login_user.getId());
			list_car_cookie_to_db(list_car_db,json_cart,login_user,session,responese);
			
			return "redirect:/index.do";
		}else{
			model.addAttribute("error", "用户账号或密码错误");
			return "goto_login";
		}
		
	}
	private void list_car_cookie_to_db(List<T_MALL_SHOPPINGCAR> list_car_db, String json_cart_cookie,
			 T_MALL_USER user_login,HttpSession session,HttpServletResponse response) {
		//判断cookies中有无数据
		if(json_cart_cookie==null|| json_cart_cookie.isEmpty()){
			//如果为空 直接将DB中的数据同步到SEESION中list_cart_session
			session.setAttribute("list_cart_session",list_car_db);
		}else{
			List<T_MALL_SHOPPINGCAR> list_cart_cookie = MyJsonUtil.json_to_list(json_cart_cookie, list_car_db.get(1));
			//数据库中无数据
			if(list_car_db==null||list_car_db.size()==0){
				//存储COOKIE中的数据到DB层
				for (int i = 0; i < list_cart_cookie.size(); i++) {
					//用户ID存入
					list_cart_cookie.get(i).setYh_id(user_login.getId());
					cartService.add_cart(list_cart_cookie.get(i));
				}
			}else{
				//是重复数据或者不是重复数据
				for (int i = 0; i < list_cart_cookie.size(); i++) {
					Boolean b = is_new_car(list_car_db, list_cart_cookie.get(i));
					if(!b){
							//是新数据
							//用户ID存入
							list_cart_cookie.get(i).setYh_id(user_login.getId());
							cartService.add_cart(list_cart_cookie.get(i));
					}else{
						//不是新数据
						for (int j = 0; j < list_car_db.size(); j++) {
							if(list_car_db.get(j).getSku_id()==(list_cart_cookie.get(i).getSku_id())){
								//更新数量
								list_car_db.get(j).setTjshl(list_car_db.get(j).getTjshl()+list_cart_cookie.get(i).getTjshl());
								//更	新合计
								list_car_db.get(j).setHj(list_car_db.get(j).getSku_jg()*list_car_db.get(j).getTjshl());
								//存入db
								cartService.update_car(list_car_db.get(j));
							}
						}
						//更新到DB
					}
				}
				
				
				
			}
		}
		//	清空COOKIE中的数据json_cart
		response.addCookie(new Cookie("json_cart", null));
		// 同步session
		session.setAttribute("list_cart_session", cartService.get_list_car_by_user_id(user_login.getId()));
		
	}

	//保存用户信息到cookie
	public static void add_yh_nch(HttpServletResponse responese,T_MALL_USER login_user){
		
		String object_to_json = MyJsonUtil.object_to_json(login_user);
		Cookie cookie=new Cookie("login_user", object_to_json);
		cookie.setMaxAge(60 * 60);
		responese.addCookie(cookie);
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
	
}
