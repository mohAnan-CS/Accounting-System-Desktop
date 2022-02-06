package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import sql.DataBaseConnection;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionModel {

    public void fillComboBox(ComboBox comboBoxDebit , ComboBox comboBoxCredit) throws SQLException {

        System.out.println("fillComboBox");

        DataBaseConnection db = new DataBaseConnection();
        ObservableList list = FXCollections.observableArrayList();

        Statement stmt = db.getConn().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT accountRef, accountName FROM account;" );
        while (rs.next()) {
            String accountName = rs.getString("accountName");
            System.out.println("Account name " + accountName);
            list.add(accountName);
        }
        System.out.println(list.size());
        comboBoxDebit.setItems(list);
        comboBoxCredit.setItems(list);
    }

    public void fillComboBox(ComboBox comboBoxDebit , ComboBox comboBoxRemainDebit, ComboBox comboBoxCredit , ComboBox comboBoxRemainCredit) throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        ObservableList list = FXCollections.observableArrayList();

        Statement stmt = db.getConn().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT accountRef, accountName FROM account;" );
        while (rs.next()) {
            String accountName = rs.getString("accountName");
            list.add(accountName);
        }

        comboBoxDebit.setItems(list);
        comboBoxRemainDebit.setItems(list);
        comboBoxCredit.setItems(list);
        comboBoxRemainCredit.setItems(list);
    }

    public void storeDebitCredit1(double debitValue,double creditValue,String debitType,String creditType,String ex,String ex1) throws SQLException {

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


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ,explanation) values("+login.id+",'"+date+"',"+max+","+debitValue+",'"+debitType+ "','debit','"+ex+"');");
        stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ,explanation) values("+login.id+",'"+date+"',"+max+","+creditValue+",'"+creditType+ "','credit','"+ex1+"');");

    }
    public void storeDebitCredit2(double debitValue,double creditValue,double RemainDebit,double RemainCredit,
                                    String RemainCreditType,String RemainDebitType,String debitType,String creditType) throws SQLException {

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


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        if (debitValue != 0 && creditValue != 0 && RemainDebit !=0 && RemainCredit != 0) {

            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values("+login.id+",'"+date+"',"+max+","+debitValue+",'"+debitType+ "','debit');");
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values("+login.id+",'"+date+"',"+max+","+creditValue+",'"+creditType+ "','credit');");

            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values(" + login.id + ",'" + date + "'," + max + "," + RemainDebit + ",'" + RemainDebitType + "','debit');");
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values(" + login.id + ",'" + date + "'," + max + "," + RemainCredit + ",'" + RemainCreditType + "','credit');");
            System.out.println("4");
        }
        else if (debitValue != 0 && creditValue != 0 && RemainDebit !=0 && RemainCredit == 0){

            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values("+login.id+",'"+date+"',"+max+","+debitValue+",'"+debitType+ "','debit');");
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values("+login.id+",'"+date+"',"+max+","+creditValue+",'"+creditType+ "','credit');");
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values(" + login.id + ",'" + date + "'," + max + "," + RemainDebit + ",'" + RemainDebitType + "','debit');");
            //stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName) values(" + login.id + ",'" + date + "'," + max + "," + RemainDebit + ",'" + RemainDebitType + "','debit');");
            System.out.println("3d");
        }
        else if (debitValue != 0 && creditValue != 0 && RemainDebit ==0 && RemainCredit != 0){
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values("+login.id+",'"+date+"',"+max+","+debitValue+",'"+debitType+ "','debit');");
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values("+login.id+",'"+date+"',"+max+","+creditValue+",'"+creditType+ "','credit');");

            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values(" + login.id + ",'" + date + "'," + max + "," + RemainCredit + ",'" + RemainCreditType + "','credit');");
            System.out.println("3c");
        }
        else if (debitValue == 0 && creditValue != 0 && RemainDebit !=0 && RemainCredit != 0){

            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values("+login.id+",'"+date+"',"+max+","+creditValue+",'"+creditType+ "','credit');");

            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values(" + login.id + ",'" + date + "'," + max + "," + RemainDebit + ",'" + RemainDebitType + "','debit');");
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values(" + login.id + ",'" + date + "'," + max + "," + RemainCredit + ",'" + RemainCreditType + "','credit');");

        }
        else if (debitValue != 0 && creditValue == 0 && RemainDebit !=0 && RemainCredit != 0){
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values("+login.id+",'"+date+"',"+max+","+debitValue+",'"+debitType+ "','debit');");
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values(" + login.id + ",'" + date + "'," + max + "," + RemainDebit + ",'" + RemainDebitType + "','debit');");
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values(" + login.id + ",'" + date + "'," + max + "," + RemainCredit + ",'" + RemainCreditType + "','credit');");
            System.out.println("4");
        }
        else if (debitValue == 0 && creditValue == 0 && RemainDebit !=0 && RemainCredit != 0){
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values(" + login.id + ",'" + date + "'," + max + "," + RemainDebit + ",'" + RemainDebitType + "','debit');");
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values(" + login.id + ",'" + date + "'," + max + "," + RemainCredit + ",'" + RemainCreditType + "','credit');");
            System.out.println("4");
        }
        else if(debitValue != 0 && creditValue != 0 && RemainDebit == 0 && RemainCredit == 0){
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values("+login.id+",'"+date+"',"+max+","+debitValue+",'"+debitType+ "','debit');");
            stmt.executeUpdate("insert INTO DebitCreditInfo (userid, dates, relation, amount, accountName,typ) values("+login.id+",'"+date+"',"+max+","+creditValue+",'"+creditType+ "','credit');");

        }
    }

}
