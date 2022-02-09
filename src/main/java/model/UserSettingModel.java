package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sql.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSettingModel {

    public void addUser(int id, String FirstName, String LastName, String pass, String Phone , String address, String permission, double salary) throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        stmt.executeUpdate("INSERT INTO user (user_id, user_first_name, user_last_name, user_pass, user_permission, user_salary,User_state,Address,PhoneNum)\n" +
                "VALUES ("+id+",'"+FirstName+"','"+LastName+"','"+pass+"','"+permission+"',"+salary+",'Working','"+address+"','"+Phone+"');");

    }
    public void edit(int id, String FirstName, String LastName, String Phone
            , String address, String permission, double salary) throws SQLException {
        System.out.println(id + "\n" + FirstName + "\n" + LastName + "\n" + Phone + "\n" + address + "\n" + permission + "\n" + salary);

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        stmt.executeUpdate("UPDATE user SET user_first_name = '"+FirstName+"', user_last_name = '"+LastName+"', user_permission = '"+permission+"', user_salary = "+salary+" , Address = '"+address+"', PhoneNum = '"+Phone+"' WHERE user_id = "+id+";");

    }

    public void delete(int id) throws SQLException {
        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        stmt.executeUpdate("UPDATE user SET User_state ='Deactive' WHERE user_id = "+id+" ");

    }

    public ObservableList<User> getAllUser() throws SQLException {

        ObservableList<User> list = FXCollections.observableArrayList();
        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();

        ResultSet rse = stmt.executeQuery("SELECT user_id,user_first_name,user_last_name,user_permission,user_salary,Address,PhoneNum,User_state FROM user " );

        while (rse.next()) {

            String fname = rse.getString("user_first_name");
            String lname = rse.getString("user_last_name");
            String UserName = fname + lname;
            int id = rse.getInt("user_id");
            String perm = rse.getString("user_permission");
            String salary = rse.getString("user_salary")+"";
            String add = rse.getString("Address");
            String phone = rse.getString("PhoneNum");
            //String state =  rse.getString("User_state");
            User user = new User(id , fname , lname , phone , add , salary , perm );
            list.add(user);
        }
        return list;
    }

    public ObservableList searchUser(int userId) throws SQLException {

        ObservableList<User> list = FXCollections.observableArrayList();
        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();

        ResultSet rse = stmt.executeQuery("SELECT user_id,user_first_name,user_last_name,user_permission,user_salary,Address,PhoneNum,User_state FROM user where user_id = "+userId+";" );

        while (rse.next()) {

            String fname = rse.getString("user_first_name");
            String lname = rse.getString("user_last_name");
            //String UserName = fname + lname;
            int id = rse.getInt("user_id");
            String perm = rse.getString("user_permission");
            String salary = rse.getString("user_salary")+"";
            String add = rse.getString("Address");
            String phone = rse.getString("PhoneNum");
            //String state =  rse.getString("User_state");
            User user = new User(id,fname,lname,phone,add,salary,perm);
            list.add(user);
        }
        return list;
    }

}
