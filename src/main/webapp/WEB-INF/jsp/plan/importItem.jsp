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
    <script>
        function setItemId(id) {
            document.getElementById("risk_id").value = id;
        }
    </script>
    <title>Risk Manage System</title>
</head>
<body>
<div class="container">
    <div class="jumbotron" style="height: 130px">
        <h1 style="margin-top: -30px">Risk Manage System</h1>
    </div>

    <div class="panel">
        <div class="navi-tab"><a href="${pageContext.request.contextPath}/risk/plan/">全部列表</a></div>
        <div class="navi-tab"><a
                href="${pageContext.request.contextPath}/risk/plan/${planInfo.id}">${planInfo.planName}</a></div>
        <div class="navi-tab">导入风险条目</div>
    </div>

    <div class="main">
        <div class="panel">
            <div class="panel-header">
                <h4>Import</h4>
            </div>

            <div class="panel-body">
                <form class="form-horizontal"
                      action="${pageContext.request.contextPath}/risk/plan/${planInfo.id}/import_item"
                      method="post">
                    <table class="table">
                        <tbody>
                        <c:choose>
                            <c:when test="${not empty items}">
                                <c:forEach items="${items}" var="item" varStatus="loop">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${item.name}</td>
                                        <td class="wrap-word">${item.content}</td>
                                        <td>
                                            <button type="button"
                                                    class="btn btn-info"
                                                    data-toggle="modal"
                                                    data-target="#select_follower"
                                                    onclick="setItemId(${item.id})">
                                                导入
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="4" class="text-center">空</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>条目名称</th>
                            <th>风险内容</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>

<form action="${pageContext.request.contextPath}/risk/plan/${planInfo.id}/import_item" method="post">
    <div class="modal fade" id="select_follower" tabindex="-1" role="dialog" aria-labelledby="select_follower">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">选择跟踪者</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="risk_id" name="risk_id">
                    <div class="form-group">
                        <label class="sr-only" for="follower">用户列表</label>
                        <select class="form-control" id="follower" name="follower">
                            <c:forEach items="${users}" var="user">
                                <option value="${user.id}">${user.username}</option>
                            </c:forEach>
                        </select>
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