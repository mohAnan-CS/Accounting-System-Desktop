package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sql.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GeneralJournalModel {

    ObservableList<GeneralJournal> list = FXCollections.observableArrayList();
    public void FillTable() throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        ResultSet rs = stmt.executeQuery("select u.user_id, u.user_first_name, u.user_last_name, d.dates, d.accountName, d.amount, d.typ from user u ,DebitCreditInfo d where d.userid = u.user_id;" );

        while (rs.next()) {

            int user_id = rs.getInt("user_id");
            String user_first_name = rs.getString("user_first_name");
            String user_last_name = rs.getString("user_last_name");
            String name = user_first_name +" "+user_last_name;
            String dates = rs.getString("dates");
            String accountName = rs.getString("accountName");
            double amount = rs.getDouble("amount");
            String typ = rs.getString("typ");

            GeneralJournal gj = new GeneralJournal(accountName,dates,name,typ,amount,user_id);
            list.add(gj);
            System.out.println(gj.toString());
        }


        }
}
