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
				$("#spu_publish_class_1_select").append("<option value="+json.id+">"+json.flmch1+"</option>");
			});
			
		});
	});
	
	function spu_publish_change_class_2_by_class_1(class_1_id){
		//var id = $("#spu_publish_class_1_select option:selected").val();
		
		$.getJSON("js/json/class_2_"+class_1_id+".js",function(data){
			$("#spu_publish_class_2_select").empty();
			$(data).each(function(i,json){
				$("#spu_publish_class_2_select").append("<option value="+json.id+">"+json.flmch2+"</option>");
			});
			
		});
		
		spu_publish_change_tm_by_class_1(class_1_id);
		
	}
	
	function spu_publish_change_tm_by_class_1(class_1_id){
		//var id = $("#spu_publish_class_1_select option:selected").val();
		$.getJSON("js/json/tm_class_1_"+class_1_id+".js",function(data){
			$("#spu_publish_tm_select").empty();
			$(data).each(function(i,json){
				$("#spu_publish_tm_select").append("<option value="+json.id+">"+json.ppmch+"</option>");
			});
			
		});
		
	}
	
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>硅谷商城</title>
</head>
<body>
	spu信息发布<br>
	<form action="save_spu.do" enctype="multipart/form-data" method="post">
	<select id="spu_publish_class_1_select" onChange="spu_publish_change_class_2_by_class_1(this.value)" name="flbh1"></select>
	<br>
	<select id="spu_publish_class_2_select" name="flbh2"></select>
	<br>
	<select id="spu_publish_tm_select" name="pp_id"></select>
	<br>
	商品名称:<input type="text" name="shp_mch" /> <br>
	
	商品描述:<input type="text" name="shp_msh" /> <br>
	
	商品图片：<br>
		<input type="file"  name="files"/><br>
		<input type="file"  name="files"/><br>
		<input type="file"  name="files"/><br>
		<input type="file"  name="files"/><br>
		<input type="file"  name="files"/><br>
	<input type="submit" value="提交">
	</form>
</body>
</html>