<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Service.DriverService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="POJI.Traveller" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Service.TravellerService" %>
<%@ page import="POJI.Driver" %><%--
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
        Driver driver=dd.finddriver1(num);//返回一个没有接单的司机
        String ss="未接单";
        if(driver.getZhuangtai().equals(ss))
        {
            ArrayList<Traveller> list = null;
            list = dd.findtraveller(beginplace, time, time1);
            request.setAttribute("list", list);
            request.setAttribute("num", num);
        }
        else {
            out.print("<h1>您已经接了一笔订单！</h1>");
        }
    } catch (SQLException | ClassNotFoundException e) {
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
        <td>接单</td>
    </tr>
<c:forEach items="${requestScope.list}" var="Traveller">
    <tr>
        <td>${Traveller.num}</td>
        <td>${Traveller.beginplace}</td>
        <td>${Traveller.endplace}</td>
        <td>${Traveller.time}</td>
        <td>
            <a href="Driverwork3.jsp?num=${requestScope.num}&traveller=${Traveller.num}">
                点击这里即可完成接单
            </a>
        </td>
    </tr>
</c:forEach>

</center>
</table>
</body>
</html>
