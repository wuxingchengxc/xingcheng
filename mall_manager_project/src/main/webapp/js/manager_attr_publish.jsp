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
$(function(){
	$.getJSON("js/json/class_1.js",function(data){
		
		$(data).each(function(i,json){
			$("#attr_publish_class_1_select").append("<option value="+json.id+">"+json.flmch1+"</option>");
		});
		
	});
});

function attr_publish_change_class_2_by_class_1(class_1_id){
	//var id = $("#attr_publish_class_1_select option:selected").val();
	
	$.getJSON("js/json/class_2_"+class_1_id+".js",function(data){
		$("#attr_publish_class_2_select").empty();
		$(data).each(function(i,json){
			$("#attr_publish_class_2_select").append("<option value="+json.id+">"+json.flmch2+"</option>");
		});
		
	});
	
	
}

function attr_publish_get_attr_by_class_2_id(class_2_id){
	var name=$("#attr_publish_class_2_select option:selected").html();
	$.get("get_attr.do",{"class_2_id" : class_2_id,class_2_name : name},function(html){
		//添加HTML到当前页面
		$("#attr_publish_inner").append(html);
	});
	
}


</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>new jsp</title>
</head>
<body>
	<select id="attr_publish_class_1_select" onChange="attr_publish_change_class_2_by_class_1(this.value)" name="flbh1"></select>
	<br>
	<select id="attr_publish_class_2_select" onChange="attr_publish_get_attr_by_class_2_id(this.value)" name="flbh2"></select>
	<br>
	<div id="attr_publish_inner"></div>
</body>
</html>