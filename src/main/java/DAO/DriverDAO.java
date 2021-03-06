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

    public int jiedan(String sql, String sql1,String sql2) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        int n=0;
        int n1=0;
        int n2=0;
        n=stmt.executeUpdate(sql);
        n1=stmt.executeUpdate(sql1);
        n2=stmt.executeUpdate(sql2);
        if(n>0&&n1>0&&n2>0) {
            return n;
        }
        else {
            return 0;
        }
    }
    //判断司机是否接单
    public ArrayList<Driver> finddriver1(String sql) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        ArrayList<Driver> list=new ArrayList<>();
        ResultSet rr=stmt.executeQuery(sql);
        Driver driver=null;
        String num;
        String zhuangtai;
        while (rr.next())
        {
               driver=new Driver();
               num=rr.getString("num");
               zhuangtai=rr.getString("zhuangtai");
               driver.setNum(num);
               driver.setZhuangtai(zhuangtai);
               list.add(driver);
        }
        if(list.size()>0) {
            System.out.println("hehe");
            return list;
        }
        else {
            System.out.println("haha");
            return null;
        }
    }

    public ArrayList<Traveller> findtraveller1(String sql) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        ArrayList<Traveller> list=new ArrayList<>();
        ResultSet rr=stmt.executeQuery(sql);
        Traveller traveller=null;
        String num;
        String time;
        String beginplace;
        String endplace;
        while (rr.next())
        {
            traveller=new Traveller();
            num=rr.getString("num");
            time=rr.getString("time");
            beginplace=rr.getString("beginplace");
            endplace=rr.getString("endplace");
            traveller.setNum(num);
            traveller.setTime(time);
            traveller.setBeginplace(beginplace);
            traveller.setEndplace(endplace);
            list.add(traveller);
        }
        coon.close();
        stmt.close();
        rr.close();
        return list;
    }

    public ArrayList<Driver> findriver2(String sql) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        ArrayList<Driver> list=new ArrayList<>();
        ResultSet rr=stmt.executeQuery(sql);
        String driver;
        String carnum;
        String driverage;
        String travellernum;
        Driver driver1=null;
        while (rr.next())
        {
            driver1=new Driver();
            driver=rr.getString("siji");
            carnum=rr.getString("carnum");
            driverage=rr.getString("driverage");

            travellernum= rr.getString(1);

            driver1.setTraveller(travellernum);
            driver1.setNum(driver);
            driver1.setCarnum(carnum);
            driver1.setDriverage(driverage);

            list.add(driver1);
        }
        if(list.size()>0)
        {
            return list;
        }
        else {
            return null;
        }
    }

    public int arrivedriver(String sql) throws ClassNotFoundException, SQLException {
        int n=0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        n=stmt.executeUpdate(sql);
        return n;
    }
}
