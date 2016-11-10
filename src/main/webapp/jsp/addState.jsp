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
<script src="http://code.jquery.com/jquery-latest.js"></script>
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
					<li><a href="<%=request.getContextPath()%>/toRisk">风险提交</a></li>
					<li class="active"><a
						href="<%=request.getContextPath()%>/toState">风险跟踪</a></li>
				</ul>
			</div>
		</div>

		<div class="col-sm-9 col-md-10">
			<div class="panel">
				<div class="panel-header">
					<h4><%=request.getAttribute("itemName")%></h4>
				</div>
				<div class="panel-body">
				<!-- <form>
				</form> -->
					<div class="col-xs-6 col-sm-1 form-group">
						<a id="modal3" data-target="#myModal3" role="button"
							class="btn btn-success" data-toggle="modal">新增状态</a>
					</div>
					<%
						int k = 0;
					%>
					<input type="hidden" name="shid" id="shid" /> <input type="hidden"
						name="prid" id="prid" />

<div class="col-xs-12 form-group">
<div style="overflow-x:scroll;">
					<table class="table table-bordered table-striped"
						style="table-layout: fixed;">
						<thead>
							<tr>
								<th>#</th>
								<!-- <th>风险内容</th> -->
								<th>创建时间</th>
								<th>状态描述</th>
								<th>详情</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.slist">
								<tr>
									<th class="align-v-center" scope="row"><%=k%></th>
									<%-- <td style="word-wrap: break-word;"><%=request.getAttribute("itemName")%></td> --%>
									<td class="align-v-center"><s:date name="createTime"
											format="yyyy-MM-dd hh:mm:ss" /></td>
									<td class="wrap-word"><s:property
											value="state" /></td>
									<td class="wrap-word"><s:property
											value="detail" /></td>
								</tr>
								<%
									k++;
								%>
							</s:iterator>
						</tbody>
					</table>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">新增状态</h4>
				</div>
				<div class="modal-body">
					<s:form cssClass="form-horizontal" action="addState" method="post">
						<input type="hidden" name="rid" id="rid"
							value=<%=request.getAttribute("itemId")%>>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="rdescription">状态描述</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="rdescription" name="rdescription" rows="3"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="rdetail">风险详情</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="rdetail" name="rdetail" rows="3"></textarea>
							</div>
						</div>
					</s:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消
					</button>
					<button type="submit" class="btn btn-primary">确定</button>
				</div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-fade -->
	<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

</body>
</html>