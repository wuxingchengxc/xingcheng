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
	
	
	
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品界面</title>
</head>
<body>
	商品头图 
	${sku_detail.spu.shp_tp }<br>
	${sku_detail.sku_mch }<br>
	<hr/>
	<c:forEach items="${list_sku}" var="l_sku">
		<a href="get_sku_detail_by_sku_id.do?sku_id=${l_sku.id}&spu_id=${l_sku.shp_id}">${l_sku.sku_mch }</a><br/>
	</c:forEach>
	<hr/>
	<c:forEach items="${sku_detail.list_imge}" var="img" >
		${img.url}
	</c:forEach>
	<hr/>
	<c:forEach items="${sku_detail.list_attr_vlue_name}" var="val_name">
		${ val_name.attr_name} :${val_name.value_name }<br>
	
	</c:forEach>
	<form action="add_cart.do" method="post" >
		<input type="hidden" name="sku_mch" value = "${sku_detail.sku_mch}"/>
		<input type="hidden" name="sku_jg" value = "${sku_detail.jg}"/>
		<input type="hidden" name="tjshl" value = "1"/>
		<input type="hidden" name="shfxz" value = "1"/>
		<input type="hidden" name="hj" value = "${sku_detail.jg}"/>
		<input type="hidden" name="shp_id" value = "${sku_detail.shp_id}"/>
		<input type="hidden" name="sku_id" value = "${sku_detail.id}"/>
		<input type="hidden" name="shp_tp" value = "${sku_detail.spu.shp_tp}"/>
		<input type="hidden" name="kcdz" value = "${sku_detail.kcdz}"/>
		<input type="submit" value="添加购物车"/>
	</form>
</body> 
</html>