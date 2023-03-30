<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-03-30
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
Login:
<form method="POST" action="login" >
    Username :<input type="text" name="username"><br/>
    Password :<input type="password" name="password"><br/>
    <input type="submit"/>
</form>
</body>
</html>
<%@include file="footer.jsp"%>
