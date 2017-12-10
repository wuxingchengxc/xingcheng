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
${ class_2_id} ${class_2_name }
	<form action="save_attr.do" method="post">
		<input type="hidden" name="class_2_id" value="${class_2_id}" />
		<input type="hidden" name="class_2_name" value="${class_2_name }">
			<table width="700px" border="1">
				<tr><td>属性名<input type="text" name="list_my_mall_attr[0].shxm_mch" /></td><td></td><td><a>添加值</a></td></tr>
				<tr><td>属性值<input type="text" name="list_my_mall_attr[0].values[0].shxzh" /></td><td>属性值名称<input type="text" name="list_my_mall_attr[0].values[0].shxzh_mch" /></td><td><a>删除</a></td></tr>
				<tr><td>属性值<input type="text" name="list_my_mall_attr[0].values[1].shxzh" /></td><td>属性值名称<input type="text" name="list_my_mall_attr[0].values[1].shxzh_mch" /></td><td><a>删除</a></td></tr>
			</table>
			
			<table width="700px" border="1" >
				<tr><td>属性名<input type="text" name="list_my_mall_attr[1].shxm_mch" /></td><td></td><td><a>添加值</a></td></tr>
				<tr><td>属性值<input type="text" name="list_my_mall_attr[1].values[0].shxzh" /></td><td>属性值名称<input type="text" name="list_my_mall_attr[1].values[0].shxzh_mch" /></td><td><a>删除</a></td></tr>
				<tr><td>属性值<input type="text" name="list_my_mall_attr[1].values[1].shxzh" /></td><td>属性值名称<input type="text" name="list_my_mall_attr[1].values[1].shxzh_mch" /></td><td><a>删除</a></td></tr>
			</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>