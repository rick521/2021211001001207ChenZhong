<!DOCTYPE html>
<%@ page import="com.chenzhong.model.User" %>
<%
    User user=(User) request.getAttribute("user");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
    <style>
        body {
            font-family: sans-serif;
            background-color: #f7f7f7;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-top: 30px;
        }
        table {
            margin: 0 auto;
            width: 80%;
            border-collapse: collapse;
            border: 1px solid #bbb;
            box-shadow: 2px 2px 5px #ccc;
            background-color: #fff;
        }
        th, td {
            border: 1px solid #bbb;
            padding: 10px;
            text-align: left;
            vertical-align: top;
        }
        th {
            background-color: #eee;
        }
    </style>
</head>
<body>
<h1>User Info</h1>
<table>
    <tr>
        <th>UserName:</th>
        <td><%=user.getUsermane()%></td>
    </tr>
    <tr>
        <th>PassWord:</th>
        <td><%=user.getPassword()%></td>
    </tr>
    <tr>
        <th>email:</th>
        <td><%=user.getEmail()%></td>
    </tr>
    <tr>
        <th>gender:</th>
        <td><%=user.getGender()%></td>
    </tr>
    <tr>
        <th>birthdate:</th>
        <td><%=user.getBirthDate()%></td>
    </tr>
</table>
</body>
</html>