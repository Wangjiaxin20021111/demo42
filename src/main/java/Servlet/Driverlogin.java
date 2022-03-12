package Servlet;

import POJI.Driver;
import Service.DriverService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Driverlogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            DriverService dr=new DriverService();
            String num=req.getParameter("num");
            String password=req.getParameter("password");
            ArrayList<Driver> list=dr.finddriver(num,password);
            Driver dd=list.get(0);
            if(dd!=null)
            {
                System.out.println("恭喜您，:"+dd.getNum()+"登录成功");
                req.setAttribute("Driver",list);
                req.setAttribute("num",dd.getNum());
                req.getRequestDispatcher("Driverwork.jsp").forward(req,resp);
            }
            else {
                System.out.println("您输入的账号或者密码不正确");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
