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
        <div class="navi-tab"><a href="${pageContext.request.contextPath}/risk/plan/${planInfo.id}">${planInfo.planName}</a></div>
        <div class="navi-tab">新增风险条目</div>
    </div>

    <div class="main">
        <div class="panel">
            <div class="panel-header">
                <h4>Information</h4>
            </div>

            <div class="panel-body">
                <form class="form-horizontal"
                      action="${pageContext.request.contextPath}/risk/plan/${planInfo.id}/${itemInfo.rid}/modify"
                      method="post">
                    <div class="form-group">
                        <label class="col-md-2 col-sm-3 control-label" for="name">风险名称</label>
                        <div class="col-md-10 col-sm-9">
                            <input class="form-control t-m-w" type="text" id="name" name="name" value="${itemInfo.name}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 col-sm-3 control-label" for="content">风险内容</label>
                        <div class="col-md-10 col-sm-9">
                            <input class="form-control t-m-w" type="text" id="content" name="content" value="${itemInfo.content}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 col-sm-3 control-label" for="possibility">风险可能</label>
                        <div class="col-md-10 col-sm-9">
                            <input class="form-control t-m-w" type="text" id="possibility" name="possibility" value="${itemInfo.possibility}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 col-sm-3 control-label" for="level">风险程度</label>
                        <div class="col-md-10 col-sm-9">
                            <input class="form-control t-m-w" type="text" id="level" name="level" value="${itemInfo.level}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 col-sm-3 control-label" for="trig">风险触发</label>
                        <div class="col-md-10 col-sm-9">
                            <textarea class="form-control t-m-w" id="trig" name="riskTrigger" rows="3">${itemInfo.riskTrigger}</textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-2 col-sm-3 control-label" for="folSelect">负责跟踪</label>
                        <div class="col-md-10 col-sm-9">
                            <select class="form-control t-m-w" id="folSelect" name="follower">
                                <c:forEach items="${users}" var="user">
                                    <c:choose>
                                        <c:when test="${itemInfo.followName.equals(user.username)}">
                                            <option value="${user.id}" selected>${user.username}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${user.id}">${user.username}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-2 col-sm-offset-3 col-sm-3">
                            <button class="btn btn-success btn-block" type="submit">完成</button>
                        </div>
                        <div class="col-md-2 col-sm-3">
                            <a class="btn btn-default btn-block" href="${pageContext.request.contextPath}/risk/plan/${planInfo.id}">放弃</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>