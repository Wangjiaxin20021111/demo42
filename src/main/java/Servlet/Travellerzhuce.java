package Servlet;

import Service.TravellerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Travellerzhuce extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int n=0;
            TravellerService tt=new TravellerService();
            req.setCharacterEncoding("gbk");
            resp.setCharacterEncoding("gbk");
            String num=req.getParameter("num");
            String password=req.getParameter("password");
             n=tt.insert(num,password);
            if(n>0)
            {
                PrintWriter pw=resp.getWriter();
                pw.print("恭喜你，游客"+num+"注册成功！");
            }
            else {
                PrintWriter p1=resp.getWriter();
                p1.print("该用户名已经被注册！");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
