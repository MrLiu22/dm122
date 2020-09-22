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
				<c:if test="${DmState==1}">
					<form class="form-horizontal" action="DmServlet" method="post">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">姓名：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="xm"
									placeholder="请输入姓名">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">学号：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="xh"
									 placeholder="请输入学号">
							</div>
						</div>

						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">桌号</label>
							<div class="col-sm-6">
								<select class="form-control" name="zh">
									<option value="1">麻将桌</option>
									<option value="2">台球桌</option>
									<option value="3">乒乓球桌</option>
									<option value="4">小魔仙桌</option>
									<option value="5">想不出什么桌</option>
									<option value="6">老师疯狂加的桌</option>
									<option value="7">打字打得头痛桌</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">点名时间</label>
							<div class="col-sm-3">
								<select class="form-control" name="zc">
									<option value="1">春假周</option>
									<option value="2">暑假周</option>
									<option value="3">秋假周</option>
									<option value="4">寒假周</option>

								</select>
							</div>
							<div class="col-sm-3">
								<select class="form-control" name="xq">
									<option value="1">星期一</option>
									<option value="2">星期二</option>
									<option value="3">星期三</option>
									<option value="4">星期四</option>
									<option value="5">星期五</option>
									<option value="6">星期六</option>

								</select>
							</div>
						</div>
						
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">提交</button>
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
