<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>点名</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<script type="text/javascript"
	src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>

</head>

<body>
	<div class="container">
		<!--导航条-->
		<%@ include file="Hd.jsp"%>
		<!--左边-->
		<%@ include file="left.jsp"%>
		<!--中间-->
		<div class="col-md-9">
		
			<div class="panel panel-primary">
				<h3 class="panel-heading">点名列表</h3>
				<p style="color:red">${msg}</p>
				<table class="table">
					
					<thead>
						<tr>
							<th>桌号</th>
							<th>人数</th>
							<th>操作</th>
						</tr>
					</thead>
					
					<tbody>
					
					<c:forEach items="${ZhtjList}" var="item"> 
						<tr>
						<th scope="row"><a href="DmtjbyzhServlet?zh=${item.zh}">${item.zh}</a></th>
							
							<td>${item.rs}</td>
							
							<td>
							<a class="btn btn-danger btn-xs" href="DmQueryZcZh?zc=${param.zc}&xq=${param.xq}&zh=${item.zh}">显示详情</a> 
							</td>
						</tr>
						</c:forEach>
						
					</tbody>
					
				</table>
			</div>

		</div>



	</div>

</body>
</html>
