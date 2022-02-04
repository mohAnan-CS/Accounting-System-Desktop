package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sql.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
public class Login {

    public static String FName;
    public static String LName;
    public static String permission;
    public static String id;

    public boolean login(int ID,String Password) throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();

        ResultSet rs = stmt.executeQuery("SELECT user_id,user_first_name, user_last_name, user_permission FROM user where user_id = "+ID+" and user_pass ="+Password+";");
        int c=0;
        while (rs.next()) {
            id = rs.getString("user_id");
            FName = rs.getString("user_first_name");
            LName  = rs.getString("user_last_name");
            permission = rs.getString("user_permission");
           c++;
        }
        if (c == 0){
            FName = null;
            LName = null;
            permission = null;
            return false;
        }
        else {
           return true;
        }
    }

}
