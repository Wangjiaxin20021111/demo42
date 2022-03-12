package DAO;

import Condition.Connect;
import POJI.Driver;
import POJI.Traveller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@SuppressWarnings("all")
public class DriverDAO {
    public int insert(String sql) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection coon = null;
        try {
            int n=0;
            coon = Connect.co();
            Statement stmt = coon.createStatement();
            /*如果执行成功的话，会返回一个值，它的值为1，如果没有执行成功，返回0*/
            n = stmt.executeUpdate(sql);
            if(n==1)
            {
                coon.close();
                stmt.close();
                return n;
            }
            else {
                coon.close();
                stmt.close();
                return n;
            }
        } catch (SQLException e) {
            return 0;
        }
    }

    public ArrayList<Driver> finddriver(String sql) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        ArrayList<Driver> list=new ArrayList<>();
        ResultSet rr=stmt.executeQuery(sql);
        String num;
        String password;
        Driver dd;
        while (rr.next())
        {
            dd=new Driver();
            num=rr.getString("num");
            password=rr.getString("password");
            dd.setNum(num);
            dd.setPassword(password);
            list.add(dd);
        }
        if(list!=null)
        {
            return list;
        }
        else {
            return null;
        }
    }

    public ArrayList<Traveller> findtraveller(String sql) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        ArrayList<Traveller> list=new ArrayList<>();
        ResultSet rr=stmt.executeQuery(sql);
        String num;
        String time;
        String beginplace;
        String endplace;
        String driver;
        Traveller tt=null;
        while (rr.next())
        {
           tt=new Traveller();
           num=rr.getString("num");
           time=rr.getString("time");
           beginplace=rr.getString("beginplace");
           endplace=rr.getString("endplace");
           /*
           driver=rr.getString("siji");
            System.out.println(driver);*/

           tt.setNum(num);
           tt.setBeginplace(beginplace);
           tt.setEndplace(endplace);
           tt.setTime(time);
           list.add(tt);
        }
        coon.close();
        stmt.close();
        rr.close();
        if(list!=null)
        {
            return list;
        }
        else {
            return null;
        }

    }
}
