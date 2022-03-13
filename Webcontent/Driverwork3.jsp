<%@ page import="Service.DriverService" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 25043
  Date: 2022/3/13
  Time: 8:08
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
        DriverService dd=new DriverService();
        String num=request.getParameter("num");
        String traveller=request.getParameter("traveller");
        int n= 0;
        n = dd.jiedan(num,traveller);
        if(n>0)
        {
            out.print("接单成功");
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }

%>
</body>
</html>
