<%--
  Created by IntelliJ IDEA.
  User: 25043
  Date: 2022/3/12
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h1>欢迎司机${requestScope.num}登录</h1>
    <form action="Driverwork2.jsp" method="post">
<table border="7" width="70%">
    <tr>
        <td>请输入您的地点</td>
        <td><input type="text" name="beginplace" required/></td>
    </tr>
    <tr>
        <td>给定一个时间范围：您的起始时间</td>
        <td><input type="datetime-local" name="time" required/></td>
    </tr>
    <tr>
        <td>结束时间</td>
        <td><input type="datetime-local" name="time1" required/></td>
    </tr>
    <input type="hidden" name="num" value="${requestScope.num}">
</table>
<input type="submit" value="注册">
    </form>
</center>
</body>
</html>
