<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>点名</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<style type="text/css">
.wx{

    background-color="#9E9E9E";

}
</style>


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
							<th>#</th>
							<th>学号</th>
							<th>姓名</th>
							<th>周次</th>
							<th>桌号</th>
							<th>IP地址</th>
							<th>提交时间</th>
							<th>数据状态</th>
							<th>操作</th>
						</tr>
					</thead>
					
					<tbody>
					
					<c:forEach items="${dmList}" varStatus="status" var="item"> 
					
						<tr <c:if test="${!item.yx}">class="wx"</c:if>>
							<td>${status.index+1}</td>
							<th scope="row"><a href="DmQueryXh?xh=${item.xh}">${item.xh}</a></th>
							<td>${item.xm}</td>
							<td><a href="DmQueryZc?zc=${item.zc}&xq=${item.xq}">第${item.zc}周星期${item.xq}</a></td>
							<td>${item.zh}</td>
							<td><a href="DmQueryIp?ip=${item.ip}">${item.ip}</a></td>
							<td>${item.sj1}</td>
							<td>${item.geyYxCn()}</td>
							<td>
							<c:if test="">
							<c:if test="${item.yx}">
							<a class="btn btn-primary btn-xs" href="ChangeState?id=${item.id}&state=0">作废</a> 
							</c:if>
							<c:if test="${!item.yx}">
							<a class="btn btn-danger btn-xs" href="ChangeState?id=${item.id}&state=1">恢复</a>
							</c:if>
							</c:if>
							</td>
						</tr>
						</c:forEach>
						
					</tbody>
					
				</table>
				<div class="panel-footer">
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<li><a href="DmQuery?pageno=${page.getPrev()}" aria-label="Previous"> <span
									aria-hidden="true">&laquo;</span> </a></li>
							<li><a href="DmQuery?pageno=1">1</a>
							</li>
							<li><a href="DmQuery?pageno=2">2</a>
							</li>
							
							<li><a href="DmQuery?pageno=3">...</a>
							</li>
							
							<li><a href="DmQuery?pageno=3">...</a>
							</li>
							
							<li><a href="DmQuery?pageno=${page.getLast()-1}">${page.getLast()-1}</a>
							</li>
							<li><a href="DmQuery?pageno=${page.getLast()}">${page.getLast()}</a>
							</li>
							<li><a href="DmQuery?pageno=${page.getNext()}" aria-label="Next"> <span
									aria-hidden="true">&raquo;</span> </a></li>
						</ul>
					</nav>
				</div>
			</div>

		</div>



	</div>

</body>
</html>
