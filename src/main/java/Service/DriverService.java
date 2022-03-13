package Service;

import DAO.DriverDAO;
import POJI.Driver;
import POJI.Traveller;

import java.sql.SQLException;
import java.util.ArrayList;
@SuppressWarnings("all")
public class DriverService {
    DriverDAO  dd=new DriverDAO();
    public int insertDriver(String num, String password, String carnum, String driverage) throws ClassNotFoundException {
        int n=0;
        //String sql="insert into driver(num,password,driverage,carnum) values('"+num+"','"+password+"','"+driverage+"','"+carnum+"')";
        String sql="insert into driver(num,password,driverage,carnum,zhuangtai) values('"+num+"','"+password+"','"+driverage+"','"+carnum+"','"+"未接单')";
        n=dd.insert(sql);
        return n;
    }
    public ArrayList<Driver> finddriver(String num, String password) throws ClassNotFoundException, SQLException {
        String sql="select*from driver where num='"+num+"' and password='"+password+"'";
        ArrayList<Driver> list=new ArrayList<Driver>();
        list=dd.finddriver(sql);
        return list;
    }

    public ArrayList<Traveller> findtraveller(String beginplace, String time, String time1) throws SQLException, ClassNotFoundException {
        ArrayList<Traveller> list=new ArrayList<>();
        if(beginplace!=null&&beginplace!=""&&time!=null&&time!=""&&time1!=null&&time1!="")
        {
            String sql = "select*from traveller where beginplace like '%"+beginplace +"%' and time>'" + time + "' and time<'" + time1 + "' and zhuangtai='未有司机接单'";
            System.out.println(sql);
            list = dd.findtraveller(sql);
        }
        return list;
    }

    public int jiedan(String num,String traveller) throws SQLException, ClassNotFoundException {
        int n=0;
        String sql="update traveller set zhuangtai='已有司机接单' where num='"+traveller+"'";
        String sql1="update traveller set siji='"+num+"' where num='"+traveller+"'";
        String sql2="update driver set zhuangtai='已接单' where num='"+num+"'";
        n=dd.jiedan(sql,sql1,sql2);
        return n;
    }
    //判断司机是否可以接单的方法
    public Driver finddriver1(String num) throws SQLException, ClassNotFoundException {
        //ArrayList<Driver> list= new ArrayList<>();
        String sql="select*from driver where num='"+num+"' and zhuangtai='"+"未接单"+"'";
        System.out.println(sql);
        ArrayList<Driver> list=dd.finddriver1(sql);
        Driver driver=null;
        if(list!=null) {
            System.out.println("哈啊啊啊啊啊啊");
          driver=list.get(0);
          return driver;
        }
       else {
           /*
           Driver driver1 =new Driver();
           driver1.setZhuangtai("已接单");
           return driver1;*/
            System.out.println("here");
            ArrayList<Driver> list1=new ArrayList<>();
            Driver driver1=new Driver();
            driver1.setZhuangtai("已接单");
            list1.add(driver1);
            Driver driver2=list1.get(0);
            return driver2;
        }
    }

    public ArrayList<Traveller> findtraveller1(String num) throws SQLException, ClassNotFoundException {
        String sql="select*from traveller where siji='"+num+"' and zhuangtai='已有司机接单'";
        ArrayList<Traveller> list=dd.findtraveller1(sql);
        if(list!=null)
        {
           return list;
        }
        else {
            return null;
        }
    }

    public ArrayList<Driver> finddriver2(String num) throws SQLException, ClassNotFoundException {
        String sql="select*from traveller,driver where traveller.siji=driver.num and traveller.num='"+num+"'and traveller.zhuangtai='已有司机接单'";
        System.out.println(sql);
        ArrayList<Driver> list=dd.findriver2(sql);
        if(list!=null)
        {
            return list;
        }
        else {
            return null;
        }
    }

    public int arrivedriver(String driver) throws SQLException, ClassNotFoundException {
        int j=0;
        String sql="update driver set zhuangtai='未接单' where num='"+driver+"'";
        j=dd.arrivedriver(sql);
        return j;
    }
}
