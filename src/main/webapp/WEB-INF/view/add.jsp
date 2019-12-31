<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
<!-- ?? css -->
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/resource/bootstrap.css">
<!-- ??js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/jquery-3.2.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="add" method="post" modelAttribute="g" enctype="multipart/form-data">
		商品名称:<form:input path="gname"/><br>
		英文名称:<form:input path="gename"/><br>
		商品品牌:<select name="bid" id="bid"></select><br>
		商品种类:<select name="kid" id="kid"></select><br>
		尺寸:<form:input path="size"/><br>
		单价:<form:input path="price"/><br>
		数量:<form:input path="num"/><br>
		标签:<form:input path="biaoqian"/><br>
		图片:<input type="file" name="file"><br>
		<form:button>提交</form:button>
	</form:form>
	<script type="text/javascript">
	
		$(function() {
			$.post(
				"getBrand",
				function(data) {
					for ( var i in data) {
						$("#bid").append("<option value='"+data[i].bid+"'>"+data[i].bname+"</option>");
					}
				},"json"
			)
			
			$.post(
				"getKind",
				function(data) {
					for ( var i in data) {
						$("#kid").append("<option value='"+data[i].kid+"'>"+data[i].kname+"</option>");
					}
				},"json"
			)
		})
	</script>
</body>
</html>