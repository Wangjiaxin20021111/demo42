package Servlet;

import Service.DriverService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Driverzhuce extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            DriverService dd= new DriverService();
            req.setCharacterEncoding("gbk");
            req.setCharacterEncoding("gbk");
            String num=req.getParameter("num");
            String password=req.getParameter("password");
            String carnum=req.getParameter("carnum");
            String driverage=req.getParameter("driverage");
            int n=0;
            n=dd.insertDriver(num,password,carnum,driverage);
            if(n>0)
            {
                PrintWriter pw=resp.getWriter();
                pw.print("恭喜你，司机"+num+"注册成功！");
            }
            else {
                PrintWriter p1=resp.getWriter();
                p1.print("该用户名已经被注册！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
