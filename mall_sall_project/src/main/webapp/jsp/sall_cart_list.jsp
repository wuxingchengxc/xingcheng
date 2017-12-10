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
 	function car_list_change_check(sku_id,car_id,shfxz){
 		$.post("sall_update_car.do",
 				{"sku_id":sku_id,"car_id":car_id,tjshl:-1,"shfxz":!(shfxz) ? 0 : 1},
 				function(data){
 					$("#sall_cart_list_inner").html(data);
 				});
 	}
 	function car_list_change_number(sku_id,car_id,tjshl){
 		$.post("sall_update_car.do",
 				{"sku_id":sku_id,"car_id":car_id,"tjshl":tjshl,"shfxz":-1},
 				function(data){
 					$("#sall_cart_list_inner").html(data);
 				});
 	}
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
</head>
<body>
	<div id="sall_cart_list_inner">
		<jsp:include page="sall_cart_list_inner.jsp"></jsp:include>
	</div>
	
</body>
</html>