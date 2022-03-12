package Condition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    static String aa;
    static String root;
    static String password;
    public static Connection co() throws SQLException {
        aa="jdbc:mysql://localhost:3306/dache";
        root="root";
        password="20021111aA#";
        Connection coon= DriverManager.getConnection(aa,root,password);
        return coon;
    }
}
