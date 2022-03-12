<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Service.DriverService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="POJI.Traveller" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 25043
  Date: 2022/3/12
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    try {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        DriverService dd=new DriverService();
        String num=request.getParameter("num");
        String beginplace=request.getParameter("beginplace");
        String time=request.getParameter("time");//起始时间
        String time1=request.getParameter("time1");//结束时间
        ArrayList<Traveller> list= null;

        list = dd.findtraveller(beginplace,time,time1);
        request.setAttribute("list",list);
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

%>
<center>
<table border="7" width="70%">
    <tr>
        <td>游客编号</td>
        <td>上车地点</td>
        <td>下车地点</td>
        <td>上车时间</td>
    </tr>
<c:forEach items="${requestScope.list}" var="Traveller">
    <tr>
        <td>${Traveller.num}</td>
        <td>${Traveller.beginplace}</td>
        <td>${Traveller.endplace}</td>
        <td>${Traveller.time}</td>
    </tr>
</c:forEach>
</center>
</table>
</body>
</html>
