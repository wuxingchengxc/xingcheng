<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	var cookie_nch="";
	$(function(){
		
		var cookies=document.cookie;
		cookies=cookies.replace(/\s/,"");
		var cookies_str=cookies.split(";");
		for (var int = 0; int < cookies_str.length; int++) {
			var cookies_obj=cookies_str[int].split("=");
			if(cookies_obj[0]=="login_user"){
				//解码
				var cookes_json=decodeURIComponent(cookies_obj[1]);
				alert(cookes_json);
				//转换成对象
				cookie_nch=$.parseJSON(cookes_json).yh_nch;
			}
		}
		$("#header_nch").html(cookie_nch);
	});
	
	
	
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
</head>
<body>
	<c:if test="${login_user==null}">
		<span style="color:red" id = "header_nch"></span><a href="goto_login.do">登录</a>  注册
	</c:if>
	<c:if test="${login_user!=null}">
		欢迎,${yh_nch}  我的订单   <a href="logout.do">登出</a>
	</c:if>
	
	
</body>
</html>