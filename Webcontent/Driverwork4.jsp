<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="POJI.Driver" %>
<%@ page import="Service.DriverService" %>
<%@ page import="POJI.Traveller" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 25043
  Date: 2022/3/13
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    DriverService service=new DriverService();
    String num=request.getParameter("num");
    ArrayList<Traveller> list=null;
    list=service.findtraveller1(num);
    request.setAttribute("list",list);
%>
<table border="7" width="70%">
    <tr>
        <td>游客号码</td>
        <td>游客上车时间</td>
        <td>游客上车地点</td>
        <td>游客下车地点</td>
        <td>确认已经达游客</td>
    </tr>
<c:forEach items="${requestScope.list}" var="Traveller">
     <tr>
         <td>${Traveller.num}</td>
         <td>${Traveller.time}</td>
         <td>${Traveller.beginplace}</td>
         <td>${Traveller.endplace}</td>
         <td>
             <a href="Driverwork5.jsp?num=${Traveller.num}">
                 点击这里确认已经达游客
             </a>
         </td>
     </tr>
</c:forEach>
</table>
</body>
</html>
