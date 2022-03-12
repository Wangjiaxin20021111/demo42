<%@ page import="Service.TravellerService2" %>
<%@ page import="Condition.Condition" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 25043
  Date: 2022/3/12
  Time: 14:03
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
        TravellerService2 service2=new TravellerService2();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String book=request.getParameter("book");
        if(book.equals("是"))
        {
            String time = request.getParameter("time");
            System.out.println(time);
            String num = request.getParameter("num");
            String beginplace = request.getParameter("beginplace");
            String endplace = request.getParameter("endplace");
            Condition co = new Condition(time,num,beginplace,endplace);
            int n = service2.book(co);
            if (n > 0) {
                out.print("您已成功发布信息，请耐心等待司机接单");
            }
        }
        else {
            out.print("请您返回预订！");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
</body>
</html>
