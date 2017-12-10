package com.atguigu0210.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.web.multipart.MultipartFile;

public class MyUpLoadFile {

	//接收一个图片对象上传到指定位置
	public static List<String> image_upload(MultipartFile[] files) throws IOException{
		//获取文件路径
		String basepath=getProperties("windows_path");
		List<String> list_images=new ArrayList<>();
		if(files!=null){
			
			for (MultipartFile multipartFile : files) {
				//组合文件名
				String image_name=System.currentTimeMillis()+multipartFile.getOriginalFilename();
				list_images.add(image_name);
				String image_name_path=basepath+"\\"+image_name;
				multipartFile.transferTo(new File(image_name_path));
			}
			return list_images;
		}else{
			return null;
		}
	}
	
	public static String getProperties(String key){
		Properties properties=new Properties();
		
		InputStream resourceAsStream = MyUpLoadFile.class.getClassLoader().getResourceAsStream("pathResourcce.properties");

		try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String value = (String)properties.get(key);
		
		return value;
	}
	
	
	
}
