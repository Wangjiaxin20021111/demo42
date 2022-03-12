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
        String sql="insert into driver(num,password,driverage,carnum) values('"+num+"','"+password+"','"+driverage+"','"+carnum+"')";
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
            String sql = "select*from traveller where beginplace like '%"+beginplace +"%' and time>'" + time + "' and time<'" + time1 + "'";
            System.out.println(sql);
            list = dd.findtraveller(sql);
        }
        return list;
    }
}
