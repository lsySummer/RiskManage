<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Login</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body style="margin-top: 40px;">
	<s:form class="form-horizontal" method="post" action="test">
		<label>Name</label>
		<input type='text' name='txt'>
		<button type="submit">Submit</button>
	</s:form>
</body>
</html>