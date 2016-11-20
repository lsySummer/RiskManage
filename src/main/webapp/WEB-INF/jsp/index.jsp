<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/statics/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/statics/css/mycss.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/statics/css/index.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
								<form id="loginForm" action="login" method="post">
								</form>
								<form id="registerForm" action="register" method="post">
								</form>
								<form id="mainForm" method="post">
									<div class="form-group">
										<h3 style="font-family: 'Microsoft Yahei', sans-serif;">
											<span>Welcome to</span> <span>Risk Manage System!</span>
										</h3>
									</div>
									<div class="form-group">
										<label for="username" class="sr-only">用户名</label>
										<input class="form-control" type="text"
											   id="username" name="username" placeholder="用户名">
									</div>
									<div class="form-group">
										<label for="password" class="sr-only">密码</label>
										<input class="form-control" type="password"
											   id="password" name="password" placeholder="密码">
									</div>

									<div class="form-group">
										<button type="submit" class="btn btn-success btn-block-s"
											onclick="login()">登录</button>
										<button type="submit" class="btn btn-default btn-block-s"
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