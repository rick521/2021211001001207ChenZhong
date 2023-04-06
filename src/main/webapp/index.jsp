<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@include file="header.jsp"%>

<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "2021211001001207ChenZhong" %>
</h1>
<br/>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30"/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>

    </select>
    <input type="submit" value="Search"/>


</form>



</body>
</html>
<%@include file="footer.jsp"%>
