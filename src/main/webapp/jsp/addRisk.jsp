<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/mycss.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/jquery/jquery-1.8.3.min.js"></script>
<title>Risk Manage System</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron" style="height: 130px">
			<h1 style="margin-top: -30px">Risk Manage System</h1>
		</div>


		<div class="col-sm-3 col-md-2">
			<div class="panel">
				<div class="panel-header">
					<h4>Navigation</h4>
				</div>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a>风险提交</a></li>
					<li><a href="<%=request.getContextPath()%>/toState">风险跟踪</a></li>
				</ul>
			</div>
		</div>


		<div class="col-sm-9 col-md-10">
			<div class="panel">
				<div class="panel-header">
					<h4>Information</h4>
				</div>
				<div class="panel-body">
					<s:form cssClass="col-sm-12 form-horizontal" action="addRisk"
						method="post">
						<div class="form-group">
							<label class="col-sm-2 control-label" for="rname">风险名称</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="rname" name="rname">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="rcontent">风险内容</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="rcontent"
									name="rcontent">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="rpossible">风险可能</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="rpossible"
									name="rpossible">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="rinfluence">风险程度</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="rinfluence"
									name="rinfluence">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="rtrig">风险触发</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="rtrig" name="rtrig" rows="3"></textarea>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="folSelect">负责跟踪</label>
							<div class="col-sm-10">
								<select class="form-control" id="folSelect" name="folSelect">
									<s:iterator value="#request.uList">
										<option value='<s:property value="id" />'>
											<s:property value="username" />
										</option>
									</s:iterator>
								</select>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button class="btn btn-default" id="save" type="submit">添加</button>
							</div>
						</div>
					</s:form>
				</div>
			</div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

</body>
</html>