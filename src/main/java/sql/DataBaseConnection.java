package sql;

import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    public Connection conn ;

    public Connection getConn() throws SQLException {

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountDataBase?autoReconnect=true&useSSL=false","root","0000");
        return conn;

    }




}
