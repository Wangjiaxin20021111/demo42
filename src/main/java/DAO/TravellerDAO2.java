package DAO;

import Condition.Connect;
import POJI.Traveller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
@SuppressWarnings("all")
public class TravellerDAO2 {

    public ArrayList<Traveller> findtraveller(String sql) throws SQLException {
        ArrayList<Traveller> list=new ArrayList<>();
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        ResultSet rr=stmt.executeQuery(sql);
        String num;
        Traveller tt;
        while(rr.next())
        {
            tt=new Traveller();
            num=rr.getString("num");
            tt.setNum(num);
            list.add(tt);
        }
        if(list.size()>0) {
            return list;
        }
        else {
            return null;
        }
    }
   //处理两个功能
    public int book(String sql,String sql1,String sql2,String sql3) throws SQLException {
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        int n=0;
        int n1=0;
        int n3=0;
        int n5=0;
        n=stmt.executeUpdate(sql);
        n1=stmt.executeUpdate(sql1);
        n3=stmt.executeUpdate(sql2);
        n5=stmt.executeUpdate(sql3);
        System.out.println(sql+"..."+sql1+"..."+sql2+"...");
        System.out.println(n+",,,"+n1+",,,"+n3+",,,"+n5+".....");
        if(n==1&&n1==1&&n3==1&&n5==1)
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
    }

    public ArrayList<Traveller> checktraveller(String sql) throws SQLException {
        ArrayList<Traveller> list=new ArrayList<>();
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        ResultSet rr=stmt.executeQuery(sql);
        Traveller traveller=null;
        String num;
        String zhuangtai;
        while (rr.next())
        {
            traveller=new Traveller();
            num=rr.getString("num");
            zhuangtai=rr.getString("zhuangtai");
            traveller.setNum(num);
            traveller.setZhuangtai(zhuangtai);
            list.add(traveller);
        }
        if(list.size()>0)
        {
            return list;
        }
        else {
            return null;
        }
    }

    public int arrivetraveller(String sql, String sql1, String sql2,String sql3) throws SQLException {
        int n=0,n1=0,n2=0,n3=0;
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        n=stmt.executeUpdate(sql);
        n1=stmt.executeUpdate(sql1);
        n2=stmt.executeUpdate(sql2);
        n3=stmt.executeUpdate(sql3);
        if(n>0&&n1>0&&n2>0&&n3>0)
        {
            return n;
        }
        else {
            return 0;
        }
    }
}
