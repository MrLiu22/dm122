<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>点名</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<script type="text/javascript"
	src="bootstrap-3.3.7-dist/js/bootstrap.js">
	</script>

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
				<div class="panel-heading">管理员登录</div>
				<div class="panel-body">
				<p>
				${msg}
				</p>
					<form class="form-horizontal" action="loginServlet" method="post">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">用户名：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="xm"
									placeholder="请输入管理员名称">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="xh"
									 placeholder="请输入密码">
							</div>
						</div>

						
						
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">管理员登录</button>
							</div>
						</div>

					</form>

				</div>
			</div>

		</div>



	</div>

</body>
</html>
