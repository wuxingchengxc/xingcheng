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
	
	function search_attr_value_down(shxm_id){
		//删除当前导航的 A标签DIV
		$("#search_navigation_"+shxm_id).remove();
		//删除当前导航隐藏域DIV
		$("#search_hidden_"+shxm_id).remove();
		//显示A标签到下面
		$("#search_attr_show_"+shxm_id+"").show();
		//查询一遍
		search_get_sku_by_attr_value();
	}


	function search_attr_value_up(shxm_id,shxzh_id,shxz_mch){
		//点击当前的属性立马显示到导航栏，再隐藏当前的 
		$("#search_map").append("<a id='search_navigation_"+shxm_id+"' href='javascript:search_attr_value_down("+shxm_id+")' >"+shxz_mch+"</a>");
		$("#search_attr_show_"+shxm_id+"").hide();
		//保存到DIV
		map="{\"shxzh_id\":"+shxzh_id+",\"shxm_id\":"+shxm_id +"}";
		
		$("#search_map").append("<input id='search_hidden_"+shxm_id+"' type='text' value="+map+">");
		//调用后台数据查询相关SKU
		search_get_sku_by_attr_value();
	}
	
	function search_get_sku_by_attr_value(){
		//从DIV中取出所有的数据信息
		var maps=$("#search_map :input");
		var model_ognl="class_2_id="+${class_2_id}
		$(maps).each(function(i,json){
			var json_obj=$.parseJSON(json.value);
			model_ognl=model_ognl+"&list_sku_attrs["+i+"].shxzh_id="+json_obj.shxzh_id+"&list_sku_attrs["+i+"].shxm_id="+json_obj.shxm_id;
		});
		//发送ajaxpost请求
		model_ognl =model_ognl+"&order="+$("#search_order").val();
		
		$.ajax({
			type:"POST",
			url:"get_sku_by_attr_value.do",
			data:model_ognl,
			success:function(date){
				$("#search_inner").html(date);
			}
		});
		
	}
	
	function search_update_order(order){
		if($("#search_order").val()==order){
			order=order+" desc";
		}
		$("#search_order").val(order);
		search_get_sku_by_attr_value();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品界面</title>
</head>
<body>
	导航<div id="search_map"><br>
	<jsp:include page="sall_mini_cart.jsp"></jsp:include>
	</div>
	<input type="hidden" id="search_order" value=" order by jg "/>
	<c:forEach items="${attrs}" var="attr">
		<div id="search_attr_show_${attr.id }">
			<a id='search_navigation_' href="javascript:search_attr_value_down()"  ></a>
			${attr.shxm_mch}:
			<c:forEach items="${attr.values}" var="val">
				<a href="javascript:search_attr_value_up(${ val.shxm_id},${val.id },'${val.shxzh}${val.shxzh_mch}' );">${val.shxzh}${val.shxzh_mch}</a>
			</c:forEach>
			<br>
		</div>
	</c:forEach>
	<hr>
	排序：<a href="javascript:search_update_order(' order by jg ');">价格</a>    <a href="javascript:search_update_order(' order by chjshj ');">上架时间</a>     <a href="javascript:;">评论数</a>   <a href="javascript:search_update_order(' order by kc ');">销量</a>
	<hr>
	<div id="search_inner">
		<jsp:include page="/jsp/sall_search_inner.jsp"></jsp:include>
	</div>
</body> 
</html>