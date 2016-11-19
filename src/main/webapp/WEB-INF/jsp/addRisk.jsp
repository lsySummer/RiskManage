<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <script src="${pageContext.request.contextPath}/statics/js/jquery.min.js" type="text/javascript"></script>
    <script src="http://code.jquery.com/jquery-latest.js" type="text/javascript"></script>
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
                    <li class="active"><a>风险提交</a></li>
                    <li><s:a action="toState">风险跟踪</s:a></li>
                </ul>
            </div>
        </div>

        <div class="main">
            <div class="panel">
                <div class="panel-header">
                    <h4>Information</h4>
                </div>
                <div class="panel-body">
                    <form class="col-sm-12 form-horizontal" action="addRisk"
                            method="post">
                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label" for="rname">风险名称</label>
                            <div class="col-md-10 col-sm-9">
                                <input class="form-control" type="text" id="rname" name="rname">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label" for="rcontent">风险内容</label>
                            <div class="col-md-10 col-sm-9">
                                <input class="form-control" type="text" id="rcontent"
                                       name="rcontent">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label" for="rpossible">风险可能</label>
                            <div class="col-md-10 col-sm-9">
                                <input class="form-control" type="text" id="rpossible"
                                       name="rpossible">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label" for="rinfluence">风险程度</label>
                            <div class="col-md-10 col-sm-9">
                                <input class="form-control" type="text" id="rinfluence"
                                       name="rinfluence">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label" for="rtrig">风险触发</label>
                            <div class="col-md-10 col-sm-9">
                                <textarea class="form-control" id="rtrig" name="rtrig" rows="3"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 col-sm-3 control-label" for="folSelect">负责跟踪</label>
                            <div class="col-md-2 col-sm-9">
                                <select class="form-control" id="folSelect" name="folSelect">
                                    <s:iterator value="#request.uList">
                                        <option value='<s:property value="id" />'>
                                            <s:property value="username"/>
                                        </option>
                                    </s:iterator>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-5 col-md-2 col-sm-offset-4 col-sm-5">
                                <button class="btn btn-default btn-block" id="save" type="submit">添加</button>
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