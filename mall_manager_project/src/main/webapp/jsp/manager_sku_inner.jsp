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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>new jsp</title>
</head>
<body>
	<br>
	请选择分类属性信息<br>
	<c:forEach items="${attrs}" var="attr" varStatus="index">
		<input type="checkbox" name="list_sku_attrs[${index.index}].shxm_id" value="${attr.id}">${attr.shxm_mch} :<br>
		
	</c:forEach>
	请选择分类属性值信息<br>
	<c:forEach items="${attrs}" var="attr" varStatus="index">
		<c:forEach items="${attr.values }" var="val" >
			<input type="radio" name="list_sku_attrs[${index.index}].shxzh_id" value="${val.id}"> ${val.shxzh } ${val.shxzh_mch }
		</c:forEach>		
		<br>
	</c:forEach>
	
	库存信息:<input name="kc" type="text" /><br>
	价格信息:<input name="jg" type="text"/><br>
	库存名称:<input name="sku_mch" type="text" /><br>
	地址：<input type="text" name="kcdz"/><br>
	
	<input type="submit" value="提交" />
	
</body>
</html>