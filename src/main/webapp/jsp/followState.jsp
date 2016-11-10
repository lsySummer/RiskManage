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
<script type="text/javascript">
	function setValue(id){
		document.getElementById('hiddenCourseId').value=id;
		return true;
	}
	</script>

</head>
<body>
	<div class="container">
		<div class="jumbotron" style="height: 130px">
			<h1 style="margin-top: -30px">Risk Manage System</h1>
		</div>

		<div class="col-md-2 col-sm-3">
			<div class="panel">
				<div class="panel-header">
					<h4>Navigation</h4>
				</div>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="<%=request.getContextPath()%>/toRisk">风险提交</a></li>
					<li class="active"><a>风险跟踪</a></li>
				</ul>
			</div>
		</div>

		<div class="col-md-10 col-sm-9">
			<div class="panel">
				<div class="panel-header">
					<div class="col-md-2">
						<s:form action="riskType" method="GET" name="typeForm">
							<select class="form-control" name="riskSelect" id="riskSelect"
								onchange="typeForm.submit()">
								<option value='1'>我跟踪的</option>
								<option value='0'>我提交的</option>
							</select>
						</s:form>
					</div>
				</div>

				<s:form action="showState" method="GET">
					<input type="hidden" name="hiddenCourseId" id="hiddenCourseId">
					<div class="panel-body">
						<s:iterator value="#request.rList" id='clist'>
							<div class="col-md-6">
								<div class="panel">
									<div class="panel-header">
										<h4 class="text-center">
											<s:property value="name" />
										</h4>
									</div>
									<div class="panel-body">
										<div class="col-sm-6">
											<span class="infoTxt"><b>风险可能：</b></span> <span
												class="infoTxt wrap-word"><s:property value="possibility" /></span>
										</div>
										<div class="col-sm-6">
											<span class="infoTxt"><b>影响程度：</b></span> <span
												class="infoTxt wrap-word"><s:property value="level" /></span>
										</div>
										<div class="col-sm-6">
											<span class="infoTxt"><b>风险触发：</b></span> <span
												class="infoTxt wrap-word"><s:property value="riskTrigger" /></span>
										</div>
										<div class="col-sm-6">
											<span class="infoTxt"><b>提交用户：</b></span> <span
												class="infoTxt wrap-word"><s:property value="subName" /></span>
										</div>
										<div class="col-sm-6">
											<span class="infoTxt"><b>负责跟踪：</b></span> <span
												class="infoTxt wrap-word"><s:property value="folName" /></span>
										</div>
										<div class="col-sm-12" style="width: 600px">
											<span class="infoTxt"><b>风险内容：</b></span> <span
												class="infoTxt wrap-word"><s:property value="content" /></span>
										</div>
										<div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
										<button class="btn btn-primary btn-block"
											onclick="return setValue('<s:property value="id" />')">状态</button>
										</div>
										<!-- <div class="courseline"
										style="margin-left: 30%; margin-top: 2%"> -->
										<!-- </div> -->
									</div>
								</div>
							</div>
							<%-- </div>
						<div class="courseblock" style="width: 800px; height: 250px">
							<div class="courseInfo" style="width: 800px">
								<s:property value="name" />
							</div>
							<div style="width: 700px; float: left; margin-left: 2%;">
								<div class="courseline">
									<span class="infoTxt"><b>风险可能：</b></span> <span class="infoTxt"><s:property
											value="possibility" /></span>
								</div>
								<div class="courseline">
									<span class="infoTxt"><b>影响程度：</b></span> <span class="infoTxt"><s:property
											value="level" /></span>
								</div>
								<div class="courseline">
									<span class="infoTxt"><b>风险触发：</b></span> <span
										class="infoTxt"><s:property value="riskTrigger" /></span>
								</div>
								<div class="courseline">
									<span class="infoTxt"><b>提交用户：</b></span> <span class="infoTxt"><s:property
											value="subName" /></span>
								</div>
								<div class="courseline">
									<span class="infoTxt"><b>负责跟踪：</b></span> <span class="infoTxt"><s:property
											value="folName" /></span>
								</div>
								<div class="courseline" style="width: 600px">
									<span class="infoTxt"><b>风险内容：</b></span> <span class="infoTxt"><s:property
											value="content" /></span>
								</div>
								<div class="courseline" style="margin-left: 30%; margin-top: 2%">
									<button class="btn btn-primary" type="submit"
										style="margin-left: 30%"
										onclick="return setValue('<s:property value="id" />')">显示风险状态</button>
								</div>
							</div>
						</div> --%>
						</s:iterator>
					</div>
				</s:form>
			</div>
			<script>
				var type = '<%=request.getAttribute("type")%>';
				var t1 = document.getElementById("riskSelect");
				for (i = 0; i < t1.length; i++) {//给select赋值  
					if (type == t1.options[i].value) {
						t1.options[i].selected = true
					}
				}
			</script>

		</div>
	</div>


	<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

</body>
</html>