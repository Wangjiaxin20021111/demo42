<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Service.TravellerService2" %>
<%@ page import="POJI.Traveller" %>
<%@ page import="Service.DriverService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="POJI.Driver" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 25043
  Date: 2022/3/12
  Time: 17:27
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
        DriverService a=new DriverService();
        String num=request.getParameter("num");
        ArrayList<Driver> listt= null;
        listt = a.finddriver2(num);
        if(listt!=null)
        {
            request.setAttribute("listt", listt);
        }
        else {
            out.print("尚未有司机接单");
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }

%>
<center>
<table border="7" width="70%">
    <tr>
        <td>司机号码</td>
        <td>车牌号码</td>
        <td>司机驾龄</td>
        <td>我的号码</td>
        <td>点击这里确认司机已经把我送达目的地</td>
    </tr>
<c:forEach items="${requestScope.listt}" var="Driver">
     <tr>
         <td>${Driver.num}</td>
         <td>${Driver.carnum}</td>
         <td>${Driver.driverage}</td>
         <td>${Driver.traveller}</td>
         <td>
             <a href="Travellerwork3.jsp?driver=${Driver.num}">
                 点击这里确认司机已经把我送达目的地
             </a>
         </td>
     </tr>
</c:forEach>
</table>
</center>
</body>
</html>
