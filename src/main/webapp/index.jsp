<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>haha</h1>
<s:form action="login" method="post">
角色<input type="text" name="role"><br/>
用户名<input type="text" name="username"><br/>
密码<input type="password" name="password"><br/>
<input type="submit">
</s:form>
</body>
</html>