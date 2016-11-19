<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${pageContext.request.contextPath}/statics/css/bootstrap.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/css/mycss.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/css/frame.css"
          rel="stylesheet">
    <script src="${pageContext.request.contextPath}/statics/js/bootstrap.js" type="text/javascript"></script>
    <title>Risk Manage System</title>
</head>
<body>
<div class="container">
    <div class="jumbotron" style="height: 130px">
        <h1 style="margin-top: -30px">Risk Manage System</h1>
    </div>

    <div>
        <div class="navigation">
            <div class="panel">
                <div class="panel-header">
                    <h4>Navigation</h4>
                </div>
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a>计划跟踪</a></li>
                    <li><a href="${pageContext.request.contextPath}/risk/plan/create">新建计划</a></li>
                </ul>
            </div>
        </div>

        <div class="main">
            <div class="panel">
                <div class="panel-header">
                    <form action="${pageContext.request.contextPath}/risk/plan/list" method="GET" name="typeForm">
                        <label for="type" class="sr-only">类型</label>
                        <select class="form-control track-select" name="type" id="type"
                                onchange="typeForm.submit()">
                            <option value='0'>我提交的</option>
                            <option value='1'>我跟踪的</option>
                        </select>
                    </form>
                </div>
                <div class="panel-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>项目名称</th>
                            <th>计划名称</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${planList}" var="plan" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>${plan.projectName}</td>
                                <td>${plan.planName}</td>
                                <td><a class="btn btn-success" href="/risk/plan/detail/${plan.id}">详细</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            var type = '${type}';
            var t1 = document.getElementById("type");
            for (let i = 0; i < t1.length; i++) {
                if (type == t1.options[i].value) {
                    t1.options[i].selected = true;
                    break;
                }
            }
        </script>
    </div>
</div>
</body>
</html>