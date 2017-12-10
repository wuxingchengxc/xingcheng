package com.atguigu0210.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.atguigu0210.bean.T_MALL_USER;
import com.google.gson.Gson;

import net.sf.json.JSONArray;

public class MyJsonUtil {
	//JSON转集合对象
	public static <T> List<T>  json_to_list(String json,T t){
		try {
			json = URLDecoder.decode(json, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONArray fromObject = JSONArray.fromObject(json);
		List<T>  list_object = (List<T>)JSONArray.toCollection(fromObject, t.getClass());
		
		return list_object;
	}
	
	
	
	
	//对象编码 传递json
	public static <T> String object_to_json(T t){
		
		Gson gson=new Gson();
		String json = gson.toJson(t);
		
		try {
			json= URLEncoder.encode(json,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	//解码对象
	public static <T> T json_to_Object(String json,Class<T> t){
		Gson gson = new Gson();
		T json_object = null;
		try {
			json= URLDecoder.decode(json, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		json_object = gson.fromJson(json, t);
		
		return json_object;
	}
	
	
	
}
