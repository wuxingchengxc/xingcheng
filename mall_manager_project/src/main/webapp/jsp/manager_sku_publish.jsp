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
				$("#sku_publish_class_1_select").append("<option value="+json.id+">"+json.flmch1+"</option>");
			});
			
		});
	});
	
	function sku_publish_change_class_2_by_class_1(class_1_id){
		//var id = $("#sku_publish_class_1_select option:selected").val();
		
		$.getJSON("js/json/class_2_"+class_1_id+".js",function(data){
			$("#sku_publish_class_2_select").empty();
			$(data).each(function(i,json){
				$("#sku_publish_class_2_select").append("<option value="+json.id+">"+json.flmch2+"</option>");
			});
			
		});
		
		sku_publish_change_tm_by_class_1(class_1_id);
		
	}
	
	function sku_publish_change_tm_by_class_1(class_1_id){
		//var id = $("#sku_publish_class_1_select option:selected").val();
		$.getJSON("js/json/tm_class_1_"+class_1_id+".js",function(data){
			$("#sku_publish_tm_select").empty();
			$(data).each(function(i,json){
				$("#sku_publish_tm_select").append("<option value="+json.id+">"+json.ppmch+"</option>");
			});
			
		});
		
	}
	function sku_publish_get_attr_by_class_2_id(class_2_id){
		var name=$("#attr_publish_class_2_select option:selected").html();
		$.get("get_attr_sku.do",{"class_2_id" : class_2_id,class_2_name : name},function(html){
			//添加HTML到当前页面
			$("#sku_publish_inner").append(html);
		});
		
	}
	
	function sku_publish_get_product_by_class_2_class_1_tm(){
		var class_2_id=$("#sku_publish_class_2_select option:selected").val();
		var pp_id=$("#sku_publish_tm_select option:selected").val();
		var class_1_id=$("#sku_publish_class_1_select option:selected").val();
		$.get("get_product.do",{"class_2_id" : class_2_id,"pp_id" : pp_id,"class_1_id":class_1_id},function(data){
			//添加HTML到当前页面
			$("#sku_publish_product").empty();
			$(data).each(function(i,json){
				$("#sku_publish_product").append("<option value="+json.id+">"+json.shp_mch+"</option>");
			});
		});
		
		
	}
	
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>硅谷商城</title>
</head>
<body>
	sku信息发布<br>
	<select id="sku_publish_class_1_select" onChange="sku_publish_change_class_2_by_class_1(this.value)" name="flbh1"></select>
	<br>
	<select id="sku_publish_class_2_select" onchange="sku_publish_get_attr_by_class_2_id(this.value)" name="flbh2"></select>
	<br>
	<select id="sku_publish_tm_select" onchange="sku_publish_get_product_by_class_2_class_1_tm()" name="pp_id"></select>
	<br>
	<form action="sava_sku.do" method="post">
	<select id="sku_publish_product" name="shp_id"></select> <br>
	<div id="sku_publish_inner"></div>
	<br>
	<br>
	</form>
	
</body>
</html>