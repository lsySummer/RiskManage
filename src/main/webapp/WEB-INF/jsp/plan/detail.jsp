<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/css/mycss.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/css/frame.css"
          rel="stylesheet">
    <script src="${pageContext.request.contextPath}/statics/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js" type="text/javascript"></script>
    <title>Risk Manage System</title>
</head>
<body>
<div class="container">
    <div class="jumbotron" style="height: 130px">
        <h1 style="margin-top: -30px">Risk Manage System</h1>
    </div>

    <div class="panel">
        <div class="navi-tab"><a href="${pageContext.request.contextPath}/risk/plan/">全部列表</a></div>
        <div class="navi-tab">${planInfo.planName}</div>
    </div>

    <div class="main">
        <div class="panel">
            <div class="panel-header">
                <c:choose>
                    <c:when test="${isCreator}">
                        <a class="btn btn-success"
                           href="${pageContext.request.contextPath}/risk/plan/${planInfo.id}/add_item">
                            新增风险条目
                        </a>
                        <a class="btn btn-info"
                           href="${pageContext.request.contextPath}/risk/plan/${planInfo.id}/import_item">
                            导入风险条目
                        </a>
                    </c:when>
                    <c:otherwise>
                        <h4>风险条目</h4>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <div class="panels-container">
            <c:forEach items="${items}" var="item">
                <div class="col-md-6 col-lg-4">
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
                                <a class="btn btn-primary btn-block"
                                    href="${pageContext.request.contextPath}/risk/plan/${planInfo.id}/${item.rid}">
                                    详细
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>