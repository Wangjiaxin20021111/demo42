package Servlet;

import POJI.Traveller;
import Service.TravellerService2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Travellerlogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            TravellerService2 tt=new TravellerService2();
            req.setCharacterEncoding("gbk");
            resp.setCharacterEncoding("gbk");
            String num=req.getParameter("num");
            String password=req.getParameter("password");
            Traveller yy=null;
            yy=tt.findTraveller(num,password);
            if(yy!=null)
            {
                System.out.println(yy.getNum()+",您已经成功登录");
                req.setAttribute("num",num);
                req.getRequestDispatcher("Travellerwork.jsp").forward(req,resp);
            }
            else {
                System.out.println("用户名或者密码不正确");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
