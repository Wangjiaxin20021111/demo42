package Service;

import DAO.TravellerDAO;

import java.sql.SQLException;

public class TravellerService {
    TravellerDAO tt=new TravellerDAO();

    public int insert(String num, String password) throws SQLException, ClassNotFoundException {
        String sql="insert into traveller(num,password) values('"+num+"','"+password+"')";
        int c=0;
        c=tt.insertTraveller(sql);
        System.out.println(c);
        return c;
    }
}
