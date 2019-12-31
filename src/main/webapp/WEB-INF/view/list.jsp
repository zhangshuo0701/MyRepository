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
${success }
	<form action="list" method="post">
		请输入商品名:<input type="text" name="gname" value="${g.gname }">
		<input type="submit" value="搜索">
	<a href="toAdd">添加</a>
	<div>
		<c:forEach items="${list }" var="g">
			<div style="float: left;">
			<input type="checkbox" class="ck" value="${g.gid }">
				图片:<img alt="" src="pic/${g.image }" width="100" height="200"><br>
				商品名:${g.gname }<br>
				英文名:${g.gename }<br>
				品牌:${g.bname }<br>
				类型:${g.kname }<br>
				尺寸:${g.size }<br>
				价格:${g.price }<br>
				数量:${g.num }<br>
				标签:${g.biaoqian }<br>
				<a href="searchById?gid=${g.gid }">修改</a>
			</div>
		</c:forEach>
		<div style="clear: both;">
			<button name="pageNum" value="1">首页</button>
			<button name="pageNum" value="${pg.prePage==0?1:pg.prePage }">上一页</button>
			<button name="pageNum" value="${pg.nextPage==0?pg.pages:pg.nextPage }">下一页</button>
			<button name="pageNum" value="${pg.pages }">尾页</button>
		</div>
		
	</div>
	</form>
	<input type="button" value="批删" onclick="deletes()">
	<script type="text/javascript">
		function deletes() {
			var ids = $(".ck:checked").map(function() {
				return this.value;
			}).get().join();
			if(confirm("你确定要删除选中的数据吗？")){
				$.post(
					"deletes",
					{ids:ids},
					function(data) {
						if(data > 0){
							alert("删除成功！！！");
							location.href="list";
						}
					}
				)
			}
		}
		
	</script>
</body>
</html>