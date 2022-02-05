package model;

import sql.DataBaseConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class UserSettingModel {

    public void AddUser(int id,String FirstName,String LastName,String pass,String Phone ,String address,String permission,double salary) throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        stmt.executeUpdate("INSERT INTO user (user_id, user_first_name, user_last_name, user_pass, user_permission, user_salary,User_state,Address,PhoneNum)\n" +
                "VALUES ("+id+",'"+FirstName+"','"+LastName+"','"+pass+"','"+permission+"',"+salary+",'Working','"+address+"','"+Phone+"');");

    }
    public void edit(int id,String FirstName,String LastName,String pass,String Phone ,String address,String permission,double salary,String state) throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        stmt.executeUpdate("UPDATE user SET user_first_name = '"+FirstName+"', user_last_name = '"+LastName+"', user_pass = '"+pass+"', user_permission = '"+permission+"', user_salary = "+salary+", User_state ='"+state+"' , Address = '"+address+"','"+Phone+"' WHERE user_id = "+id+";");

    }//deactiveted

    public void delete(int id) throws SQLException {
        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        stmt.executeUpdate("UPDATE user SET User_state ='Deactive' WHERE user_id = "+id+" ");

    }

}
