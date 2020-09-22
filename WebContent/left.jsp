<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="row">
	<!--左边-->
	<div class="col-md-3">
		<div class="list-group">
			<a href="login.jsp" class="list-group-item active">管理员登录</a> 
			<a href="DmtjServlet"class="list-group-item">点名列表</a> 
			<a href="DmtjServlet" class="list-group-item">点名统计</a>
			<a href="#" class="list-group-item">tomcat</a> <a href="#"
				class="list-group-item">jerry</a>
		</div>
		<div class="list-group">
			<a href="dm.jsp" class="list-group-item active">点名页面</a> <a
				href="DmQuery" class="list-group-item">点名列表</a>

		</div>

		<div class="panel panel-primary">
				<div class="panel-heading">按周次查询</div>
				<div class="panel-body">
				<p>
				${msg}
				</p>
					<form class="form-horizontal" action="DmQueryZc" method="post">
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-4 control-label">周次</label>
							<div class="col-sm-6">
								<select class="form-control" name="zc">
									<option value="1">1周</option>
									<option value="2">2周</option>
									<option value="3">3周</option>
									<option value="4">4周</option>
									<option value="5">5周</option>
									<option value="6">6周</option>
									<option value="7">7周</option>
									<option value="8">8周</option>

								</select>
							</div>
							<label for="inputPassword3" class="col-sm-4 control-label">星期</label>
							<div class="col-sm-6">
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
								<button type="submit" class="btn btn-default">查询</button>
							</div>
						</div>

					</form>

				</div>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">按桌号统计</div>
				<div class="panel-body">
				<p>
				${msg}
				</p>
					<form class="form-horizontal" action="Zhtj" method="post">
						<div class="form-group">
						<label for="inputPassword3" class="col-sm-3 control-label">周次</label>
							<div class="col-sm-9">
								<select class="form-control" name="zc">
									<option value="1">1周</option>
									<option value="2">2周</option>
									<option value="3">3周</option>
									<option value="4">4周</option>
									<option value="5">5周</option>
									<option value="6">6周</option>
									<option value="7">7周</option>
									<option value="8">8周</option>

								</select>
							</div>
							<label for="inputPassword3" class="col-sm-3 control-label">星期</label>
							<div class="col-sm-9">
								<select class="form-control" name="xq">
									<option value="1">星期一</option>
									<option value="2">星期二</option>
									<option value="3">星期三</option>
									<option value="4">星期四</option>
									<option value="5">星期五</option>
									<option value="6">星期六</option>
									<option value="7">星期日</option>

								</select>
							</div>
						</div>
					
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">统计</button>
							</div>
						</div>

					</form>

				</div>
			</div>
			
			<div class="panel panel-primary">
				<div class="panel-heading">按桌号查询</div>
				<div class="panel-body">
				<p>
				${msg}
				</p>
					<form class="form-horizontal" action="DmQueryZh" method="post">
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">桌号</label>
							<div class="col-sm-9">
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
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">查询</button>
							</div>
						</div>

					</form>

				</div>
			</div>
	</div>