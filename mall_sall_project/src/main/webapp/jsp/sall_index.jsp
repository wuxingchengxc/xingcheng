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
				$("#sall_index_class_1").append("<li onmouseover='sall_show_class_2_ul(this.value)'  value="+json.id+">"+json.flmch1+"</li>");
			});
			
		});
	});
	
	function sall_show_class_2_ul(class_2_id){
		$.getJSON("js/json/class_2_"+class_2_id+".js",function(data){
			$("#sall_index_class_2").empty();
			$(data).each(function(i,json){
				$("#sall_index_class_2").append(
						"<li value="+json.id+"><a href='goto_sku_search.do?class_2_id="+json.id+"&class_2_name="+json.flmch2+"' target='_blank'>" + json.flmch2
						+ "</a></li>");
		});
		
		
		});
	}
	
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
</head>
<body>
	<jsp:include page="sall_herad.jsp" ></jsp:include>
	<ul id="sall_index_class_1" style="width:150px"></ul>
	<ul id="sall_index_class_2" ></ul>
	
	
</body>
</html>