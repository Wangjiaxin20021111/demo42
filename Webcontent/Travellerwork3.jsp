<%@ page import="Service.DriverService" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 25043
  Date: 2022/3/13
  Time: 17:14
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
        DriverService w=new DriverService();
        String driver=request.getParameter("driver");
        System.out.println(driver);
        int n=0;
        n=w.arrivedriver(driver);
        if(n>0)
        {
            out.print("已经确认司机送达");
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
%>
</body>
</html>
