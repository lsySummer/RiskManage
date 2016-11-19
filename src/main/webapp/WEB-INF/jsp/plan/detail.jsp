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
                    <h4># Name</h4>
                </div>

                <div class="panel-body">
                    <div class="panels-container">
                        <c:forEach items="${items}" var="item">
                            <div class="col-md-6">
                                <div class="panel card hover">
                                    <div class="panel-header">
                                        <h4 class="text-center wrap-word">
                                                ${item.name}
                                        </h4>
                                    </div>
                                    <div class="panel-body">
                                        <div class="col-sm-6">
                                            <span class="infoTxt text-black">风险可能：</span>
                                            <span class="infoTxt wrap-word">${item.possibility}</span>
                                        </div>
                                        <div class="col-sm-6">
                                            <span class="infoTxt text-black">影响程度：</span>
                                            <span class="infoTxt wrap-word">${item.level}</span>
                                        </div>
                                        <div class="col-sm-6">
                                            <span class="infoTxt text-black">风险触发：</span>
                                            <span class="infoTxt wrap-word">${item.possibility}</span>
                                        </div>
                                            <%--<div class="col-sm-6">--%>
                                            <%--<span class="infoTxt text-black">提交用户：</span>--%>
                                            <%--<span class="infoTxt wrap-word">${detail.name}</span>--%>
                                            <%--</div>--%>
                                        <div class="col-sm-6">
                                            <span class="infoTxt text-black">负责跟踪：</span>
                                            <span class="infoTxt wrap-word">${item.followName}</span>
                                        </div>
                                        <div class="col-sm-12">
                                            <span class="infoTxt text-black">风险内容：</span>
                                            <span class="infoTxt wrap-word">${item.content}</span>
                                        </div>
                                        <div class="col-sm-12">
                                            <span class="infoTxt text-black">当前状态：</span>
                                            <span class="infoTxt wrap-word">${item.currentState}</span>
                                        </div>
                                        <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
                                            <a class="btn btn-primary btn-block">
                                                全部状态
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>