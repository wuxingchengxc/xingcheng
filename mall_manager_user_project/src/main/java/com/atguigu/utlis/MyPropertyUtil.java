package com.atguigu.utlis;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.web.multipart.MultipartFile;

public class MyPropertyUtil {

	public static String getMyProperties(String key) {

		Properties properties = new Properties();

		InputStream resourceAsStream = MyPropertyUtil.class.getClassLoader()
				.getResourceAsStream("usernameToken.properties");

		try {
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String property = properties.getProperty(key);
		return property;
	}

}
