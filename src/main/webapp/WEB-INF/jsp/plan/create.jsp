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
                    <li><a href="${pageContext.request.contextPath}/risk/plan/list">计划跟踪</a></li>
                    <li class="active"><a>新建计划</a></li>
                </ul>
            </div>
        </div>

        <div class="main">
            <div class="panel">
                <div class="panel-header">
                    <h4>Create</h4>
                </div>
                <div class="panel-body">
                    <form class="col-sm-12 form-horizontal" action="${pageContext.request.contextPath}/risk/plan/create"
                          method="post">
                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label" for="plan_name">计划名称</label>
                            <div class="col-md-10 col-sm-9">
                                <input class="form-control t-m-w" type="text" id="plan_name" name="plan_name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label" for="project_name">项目名称</label>
                            <div class="col-md-10 col-sm-9">
                                <input class="form-control t-m-w" type="text" id="project_name" name="project_name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label" for="follower">负责跟踪</label>
                            <div class="col-md-10 col-sm-9">
                                <select class="form-control s-m-w" id="follower" name="follower">
                                    <c:forEach items="${users}" var="user">
                                        <option value='${user.id}'>
                                            ${user.username}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-2 col-md-2 col-sm-offset-3 col-sm-3">
                                <button class="btn btn-default btn-block" type="submit">创建</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>