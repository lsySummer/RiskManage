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
        <div class="navi-tab">全部列表</div>
    </div>

    <div class="main">
        <div class="panel">
            <div class="panel-header">
                <form action="${pageContext.request.contextPath}/risk/plan/" method="GET" name="typeForm">
                    <label for="type" class="sr-only">类型</label>
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#create_dialog">
                        <span class="glyphicon glyphicon-plus"></span>
                    </button>
                    <select class="form-control track-select" name="type" id="type" onchange="typeForm.submit()">
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
                    <c:choose>
                        <c:when test="${not empty planList}">
                            <c:forEach items="${planList}" var="plan" varStatus="loop">
                                <tr>
                                    <td>${loop.index + 1}</td>
                                    <td>${plan.projectName}</td>
                                    <td>${plan.planName}</td>
                                    <td><a class="btn btn-success" href="${pageContext.request.contextPath}/risk/plan/${plan.id}">详细</a></td>
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

<form class="form-horizontal" action="${pageContext.request.contextPath}/risk/plan/create" method="post">
    <div class="modal fade" id="create_dialog" tabindex="-1" role="dialog" aria-labelledby="create_dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">新增风险计划</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="planName">计划名称</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="planName" name="planName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="projectName">项目名称</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="projectName" name="projectName">
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