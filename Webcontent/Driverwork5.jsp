<%@ page import="Service.TravellerService2" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 25043
  Date: 2022/3/13
  Time: 17:02
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
        int n= 0;
        TravellerService2 tt=new TravellerService2();
        String num=request.getParameter("num");//司机获取游客号码，修改游客信息为被送达的状态：未有司机接单，同时把游客的地址重新置为空
        n = tt.arrivetraveller(num);
        if(n>0)
        {
            out.print("您已经成功送达游客到目的地");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

%>
</body>
</html>
