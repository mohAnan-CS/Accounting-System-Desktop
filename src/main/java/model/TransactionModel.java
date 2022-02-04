package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import sql.DataBaseConnection;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionModel {

    public void fillComboBox(ComboBox comboBox) throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        ObservableList list = FXCollections.observableArrayList();

        Statement stmt = db.getConn().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT accountRef, accountName FROM account;" );
        while (rs.next()) {
            String accountName = rs.getString("accountName");
        }
    }

    public void getDebitCredit1(double debitValue,double creditValue,String debitType,String creditType) throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        LoginModel login = new LoginModel();

        ResultSet rs = stmt.executeQuery("SELECT relation FROM DebitCreditInfo;" );
        int max=0;
        int flag =0;
        while (rs.next()) {
            int re = rs.getInt("relation");
            if (max < re){
              max = re;
            }
        }
        max++;
        System.out.println(max);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName) values("+login.id+",'"+date+"',"+max+","+debitValue+",'"+debitType+ "');");
        stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName) values("+login.id+",'"+date+"',"+max+","+creditValue+",'"+creditType+ "');");

    }
}
