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
				<div class="panel-heading">点名</div>
				<div class="panel-body">
				<p>
				${msg}
				</p>
				<c:if test="${DmState==0||DmState==null}">
					<form class="form-horizontal" action="StartDmServlet" method="post">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">点名状态：</label>
							<div class="col-sm-7">
								未开始点名
							</div>
						</div>
						
							
						
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">开始点名</button>
							</div>
						</div>

					</form>
                </c:if>
                <c:if test="${DmState==1}">
					<form class="form-horizontal" action="StopDmServlet" method="post">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">点名状态：</label>
							<div class="col-sm-7">
								正在点名中
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">停止点名</button>
							</div>
						</div>

					</form>
                </c:if>
				</div>
			</div>

		</div>



	</div>

</body>
</html>
