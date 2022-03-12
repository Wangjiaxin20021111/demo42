package Service;

import Condition.Condition;
import DAO.TravellerDAO2;
import POJI.Traveller;

import java.sql.SQLException;
import java.util.ArrayList;

public class TravellerService2 {
    TravellerDAO2 dd=new TravellerDAO2();
    public Traveller findTraveller(String num, String password) throws SQLException {
        String sql="select*from traveller where num='"+num+"' and password='"+password+"'";
        ArrayList<Traveller> list=null;
        list=dd.findtraveller(sql);
        Traveller tt=null;
        if(list!=null)
        {
            tt=list.get(0);
            return tt;
        }
        else {
            return null;
        }
    }


    public int book(Condition co) throws SQLException {
        int n=0;
        if(co.time!=null&&co.time!=""&&co.endplace!=null&&co.endplace!=""&&co.beginplace!=null&&co.endplace!=""&&co.num!=""&&co.num!="")
        {
            System.out.println("更改条件是："+co.num+"..."+co.time+"..."+co.beginplace+"..."+co.endplace);
            String sql="update traveller set beginplace=' "+co.beginplace+" ' where num='"+co.num+"'";

            String sql1="update traveller set endplace=' "+co.endplace+" ' where num='"+co.num+"'";

            String sql2="update traveller set time='"+co.time+"' where num='"+co.num+"'";
            n=dd.book(sql,sql1,sql2);
            return n;
        }
        else {
            return 0;
        }
    }
}
