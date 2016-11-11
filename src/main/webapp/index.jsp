<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/mycss.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/index.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Risk Manage System</title>
<script type="text/javascript">
	var msg = "${requestScope.error}";
	if (msg) {
		alert(msg);
	}
	
	function login() {
		setForm('loginForm');
	}
	
	function register() {
		setForm('registerForm');
	}
	
	function setForm(source) {
		let action = document.getElementById(source).getAttribute('action');
		document.getElementById('mainForm').setAttribute('action', action);
	}
</script>
</head>
<body>
	<div class="center-container">
		<div class="login-form">
			<div class="panel" style="background: #fff; opacity: 0.7;">
				<div class="col-xs-12">
					<div class="table display-table">
						<div class="col-sm-4 table-cell login-logo"></div>
						<div class="table-cell">
							<div class="col-xs-12">
								<s:form id="loginForm" action="login" method="post">
								</s:form>
								<s:form id="registerForm" action="register" method="post">
								</s:form>
								<form id="mainForm" method="post">
									<div class="form-group">
										<h3 style="font-family: 'Microsoft Yahei';">
											<span>Welcome to</span> <span>Risk Manage System!</span>
										</h3>
									</div>
									<div class="form-group">
										<label for="username" hidden>用户名</label>
										<input class="form-control" type="text"
											   id="username" name="username" placeholder="用户名">
									</div>
									<div class="form-group">
										<label for="password" hidden>密码</label>
										<input class="form-control" type="password"
											   id="password" name="password" placeholder="密码">
									</div>

									<div class="form-group">
										<button type="submit" class="btn btn-default btn-block-s"
											onclick="login()">登录</button>
										<button type="submit" class="btn btn-success btn-block-s"
											onclick="register()">注册</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>