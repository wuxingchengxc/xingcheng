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
	function sall_goto_order(){
		location.assign("goto_order.do");
	}
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
</head>
<body>
	<c:forEach items="${list_cart }" var="car">
		<input type="checkbox" ${ car.shfxz== "1" ? "checked" :""} onclick="car_list_change_check(${car.sku_id},${car.id },this.checked)"  />${car.sku_mch}
		<a href="javascript:car_list_change_number(${car.sku_id},${car.id },${car.tjshl-1});">-</a>${ car.tjshl }
		<a href="javascript:car_list_change_number(${car.sku_id},${car.id },${car.tjshl+1});">+</a>
		<button onclick="car_list_delete(car.id)">删除</button>
		<br/>
	</c:forEach>
	<div style="color: red">${sum}</div>
	<button onclick="sall_goto_order()">结算 </button>
</body>
</html>