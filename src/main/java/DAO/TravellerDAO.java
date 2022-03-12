package DAO;

import Condition.Connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@SuppressWarnings("all")
public class TravellerDAO {
    public int insertTraveller(String sql) throws SQLException, ClassNotFoundException {
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
}
