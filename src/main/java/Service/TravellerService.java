package Service;

import DAO.TravellerDAO;

import java.sql.SQLException;

public class TravellerService {
    TravellerDAO tt=new TravellerDAO();

    public int insert(String num, String password) throws SQLException, ClassNotFoundException {
        String sql="insert into traveller(num,password,zhuangtai) values('"+num+"','"+password+"','未有司机接单')";
        int c=0;
        c=tt.insertTraveller(sql);
        System.out.println(c);
        return c;
    }
}
