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
    public int book(String sql,String sql1,String sql2) throws SQLException {
        Connection coon=Connect.co();
        Statement stmt=coon.createStatement();
        int n=0;
        int n1=0;
        int n3=0;
        n=stmt.executeUpdate(sql);
        n1=stmt.executeUpdate(sql1);
        n3=stmt.executeUpdate(sql2);
        System.out.println(sql+"..."+sql1+"..."+sql2+"...");
        System.out.println(n+",,,"+n1+",,,"+n3+",,,");
        if(n==1&&n1==1&&n3==1)
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
}
