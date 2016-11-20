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
        <div class="navi-tab">${itemInfo.name}</div>
    </div>

    <div class="main">
        <div class="panel">
            <div class="panel-header">
                <h4>状态</h4>
            </div>
            <div class="panel-body">
                <div class="form-group">
                    <button class="btn btn-success" data-toggle="modal" data-target="#add_state">新增状态</button>
                </div>
                <div class="form-group">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>创建时间</th>
                            <th>状态描述</th>
                            <th>详情</th>
                            <th>是否发生</th>
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
                                        <td>${state.ifHappen ? "是" : "否"}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="5">空</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<form class="form-horizontal" action="${pageContext.request.contextPath}/risk/plan/${planInfo.id}/${itemInfo.id}/add_state" method="post">
    <div class="modal fade" id="add_state" tabindex="-1" role="dialog" aria-labelledby="新增状态">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">新增状态</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="state">状态</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="state" name="state">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="detail">详细描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="detail" name="detail" rows="3"></textarea>
                        </div>
                    </div>
                    <div class="checkbox">
                        <label class="sr-only" for="ifHappen">是否发生</label>
                        <div class="col-sm-offset-2">
                            <label>
                                <input type="checkbox" id="ifHappen" name="ifHappen"> 已发生
                            </label>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>