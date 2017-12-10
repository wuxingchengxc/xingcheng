package com.atguigu.utlis;

public class MyDataSourceSwitch {

	private static ThreadLocal<String> key=new ThreadLocal<>();
	
	public static String getKey(){
		return key.get();
	}
	public static void setKey(String key_in){
		key.set(key_in);
	}
	public static void clearKey(){
		key.remove();
	}
	
}
