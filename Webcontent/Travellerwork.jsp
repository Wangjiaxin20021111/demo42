<%@ page import="POJI.Traveller" %>
<%@ page import="Service.TravellerService2" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Condition.Condition" %><%--
  Created by IntelliJ IDEA.
  User: 25043
  Date: 2022/3/12
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<form action="Travellerwork2.jsp" method="post">
<h1>欢迎${requestScope.num}登录！</h1>
<center>
<table border="7" width="70%">
   <tr>
       <td>请输入您的上车地点</td>
       <td><input type="text" name="beginplace" required/></td>
   </tr>
    <tr>
        <td>请输入您的目的地</td>
        <td><input type="text" name="endplace" required/></td>
    </tr>
    <tr>
        <td>请输入您的上车时间</td>
        <td><input type="datetime-local" name="time" required/></td>
    </tr>
    <tr>
        <td>请选择是否现在预订</td>
        <td>
        <input type="radio" name="book" value="是" required/>是
        <input type="radio" name="book" value="否" required/>否
        </td>
    </tr>
    <tr>
        <td>订单状态</td>
        <td>
            <a href="Travellerbook.jsp?num=${requestScope.num}">
                点击这里查看
            </a>
        </td>
    </tr>
    <input type="hidden" name="num" value="${requestScope.num}">
    <input type="submit" value="提交">
</table>
</center>
</form>
</body>
</html>
