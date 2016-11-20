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
        $(document).ready(function () {
            $("a").click(function () {
                event.stopPropagation();
            })
        });
        function showDeleteModal(rid) {
            let url = "${pageContext.request.contextPath}/risk/plan/${planInfo.id}/"+ rid + "/remove";
            $("#delete_form").attr("action", url);
            $('#delete_item').modal('show');
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
                <form class="right-align s-m-w" action="${pageContext.request.contextPath}/risk/plan/${planInfo.id}"
                      method="get">
                    <div class="input-group">
                        <input type="text" class="form-control" name="search" placeholder="搜索关键词"
                               value="${pageContext.request.getParameter("search")}">
                        <span class="input-group-btn">
                        <button type="submit" class="btn btn-default">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                    </div>
                </form>
            </div>
        </div>

        <div class="panels-container">
            <c:forEach items="${items}" var="item">
                <div class="col-sm-6 col-lg-4"
                     onclick="location.href='${pageContext.request.contextPath}/risk/plan/${planInfo.id}/${item.rid}'">
                    <div class="panel card hover">
                        <div class="panel-header">
                            <h4 class="text-center wrap-word">
                                    ${item.name}
                            </h4>
                        </div>
                        <div class="panel-body">
                            <div class="col-sm-6">
                                <label class="control-label">风险可能：</label>
                                <span class="wrap-word">${item.possibility}</span>
                            </div>
                            <div class="col-sm-6">
                                <label class="control-label">影响程度：</label>
                                <span class="wrap-word">${item.level}</span>
                            </div>
                            <div class="col-sm-6">
                                <label class="control-label">风险触发：</label>
                                <span class="wrap-word">${item.riskTrigger}</span>
                            </div>
                            <div class="col-sm-6">
                                <label class="control-label">负责跟踪：</label>
                                <span class="wrap-word">${item.followName}</span>
                            </div>
                            <div class="col-sm-12">
                                <label class="control-label">风险内容：</label>
                                <span class="wrap-word">${item.content}</span>
                            </div>
                            <div class="col-sm-12">
                                <label class="control-label">当前状态：</label>
                                <span class="wrap-word">${item.currentState}</span>
                            </div>
                            <c:if test="${isCreator}">
                                <div class="card-btn-group">
                                    <div class="col-sm-6 card-btn">
                                        <a class="btn btn-warning btn-block"
                                           href="${pageContext.request.contextPath}/risk/plan/${planInfo.id}/${item.rid}/modify">
                                            修改
                                        </a>
                                    </div>
                                    <div class="col-sm-6 card-btn">
                                        <a class="btn btn-danger btn-block"
                                           onclick="showDeleteModal(${item.rid});">
                                            移除
                                        </a>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<form class="form-horizontal" id="delete_form" method="post">
    <div class="modal fade" id="delete_item" tabindex="-1" role="dialog" aria-labelledby="移除条目">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">确认</h4>
                </div>
                <div class="modal-body">
                    <p>确定要移除此条目吗？</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-danger">移除</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>