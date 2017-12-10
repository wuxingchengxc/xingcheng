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
	function show_sku_mch(){
		$.post("get_minicart.do",function(data){
			$("#minicart_list").html(data);
		});
		$("#minicart_list").show();
	}
	function hide_sku_mch(){
		$("#minicart_list").hide();
	}
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
</head>
<body>
	<a target="_blank" href="goto_cart_list.do" onmouseover="show_sku_mch()" onmouseout="hide_sku_mch()" >迷你购物车</a>
	<div id="minicart_list" style="display:none">
		
	</div>
</body>
</html>