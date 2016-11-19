<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="navi-tab"><a href="${pageContext.request.contextPath}/risk/plan/${planInfo.id}">${planInfo.planName}</a></div>
        <div class="navi-tab"># Name</div>
    </div>

    <div class="main">
        <div class="panel">
            <div class="panel-header">
                <h4>状态</h4>
            </div>
            <div class="panel-body">

                <table class="table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>创建时间</th>
                        <th>状态描述</th>
                        <th>详情</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${not empty states}">
                            <c:forEach items="${states}" var="state" varStatus="loop">
                                <tr>
                                    <th>${loop.index + 1}</th>
                                    <td>
                                        <fmt:formatDate value="${state.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
                                    </td>
                                    <td class="wrap-word">${state.state}</td>
                                    <td class="wrap-word">${state.detail}</td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="4">空</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>