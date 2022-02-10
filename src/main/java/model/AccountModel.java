package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sql.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountModel {


    public String addAccount(String accountName,String accountType,int ref) throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();

        stmt.executeUpdate("insert into account (accountRef,accountName,accountType) values("+ref+",'"+accountName+"','"+accountType+"');");
        return "Account Was Added";
    }

    public ObservableList getAccount() throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        ResultSet rs = stmt.executeQuery("select accountRef,accountName,accountType from account;" );
        ObservableList<GeneralJournal> list = FXCollections.observableArrayList();

        while (rs.next()) {
            rs.getInt("accountRef");
        }


        return list;
    }
}
