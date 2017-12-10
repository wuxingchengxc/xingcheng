package com.atguigu.utlis;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class MyPasswordCallback implements CallbackHandler{
	
	public void handle(Callback[] arg0) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback wc = (WSPasswordCallback) arg0[0];
		String username = wc.getIdentifier();
		//获取密码
		String myProperties = MyPropertyUtil.getMyProperties(username);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		String format = sdf.format(new Date());
		//时间戳+密码 然后MD5加密=最终密码
		String md5 = MD5Util.md5(format + myProperties);
		wc.setPassword(md5);
		
	}

	
	
}
