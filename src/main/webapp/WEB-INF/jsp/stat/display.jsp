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
    <script src="${pageContext.request.contextPath}/statics/js/Chart.min.js" type="text/javascript"></script>
    <script>
        var chart;

        $(document).ready(function () {
            $("form").submit(function (e) {
                e.preventDefault();
                let url = "${pageContext.request.contextPath}/risk/stat/get";
                $.get(url, $(this).serialize(), function (result) {
                    let datasets = {
                        label: "次数",
                        backgroundColor: [],
                        borderColor: [],
                        borderWidth: 1,
                        data: []
                    };
                    let labels = [];
                    for (let item of result) {
                        labels.push(item.risk.name);
                        datasets.data.push(item.count);
                        datasets.backgroundColor.push('#80bceb');
                        datasets.borderColor.push('#0078d7');
                    }

                    chart.data.datasets[0] = datasets;
                    chart.data.labels = labels;
                    chart.update();

                });
            });

            chart = new Chart($("#chart"), {
                type: "bar",
                data: {
                    labels: [],
                    datasets: []
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });
        })
    </script>
    <title>Risk Manage System</title>
</head>
<body>
<div class="container">
    <div class="jumbotron" style="height: 130px">
        <h1 style="margin-top: -30px">Risk Manage System</h1>
    </div>

    <div class="main">
        <div class="panel">
            <div class="panel-header">
                <form class="form-inline">
                    <div class="btn-group" data-toggle="buttons">
                        <label class="btn btn-info active">
                            <input type="radio" name="type" value="identify" autocomplete="off" checked> 识别最多
                        </label>
                        <label class="btn btn-info">
                            <input type="radio" name="type" value="happen" autocomplete="off"> 发生最多
                        </label>
                    </div>
                    <div class="input-group">
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </div>
                        <label class="sr-only" for="from">开始日期</label>
                        <fmt:formatDate value="${from}" pattern="yyyy-MM-dd" var="fromFmt"/>
                        <input type="date" class="form-control" id="from" name="from" value="${fromFmt}">
                    </div>
                    <label class="control-label">至</label>
                    <div class="input-group">
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </div>
                        <label class="sr-only" for="to">结束日期</label>
                        <fmt:formatDate value="${to}" pattern="yyyy-MM-dd" var="toFmt"/>
                        <input type="date" class="form-control" id="to" name="to" value="${toFmt}">
                    </div>
                    <button type="submit" class="btn btn-success">
                        <span class="glyphicon glyphicon-search"></span>
                    </button>

                    <a href="${pageContext.request.contextPath}/risk/plan/" class="btn btn-default right-align">返回</a>
                </form>
            </div>
            <div class="panel-body">
                <canvas id="chart"></canvas>
            </div>
        </div>
    </div>
</div>
</body>
</html>