package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sql.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GeneralLedgerModel {

    public int Counter() throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM account;");
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }


    public ObservableList Fun() throws SQLException {

        ObservableList<GeneralLedger> list = FXCollections.observableArrayList();
        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        ResultSet rs = stmt.executeQuery("select u.user_id, u.user_first_name, u.user_last_name, d.dates, d.accountName, d.amount, d.typ ,d.relation,d.explanation from user u ,DebitCreditInfo d where d.userid = u.user_id;\n");

        while (rs.next()) {

            int user_id = rs.getInt("user_id");
            int relation = rs.getInt("relation");
            String user_first_name = rs.getString("user_first_name");
            String user_last_name = rs.getString("user_last_name");
            String name = user_first_name + " " + user_last_name;
            String dates = rs.getString("dates");
            String accountName = rs.getString("accountName");
            double amount = rs.getDouble("amount");
            String typ = rs.getString("typ");
            String explanation = rs.getString("explanation");

            GeneralLedger gl = new GeneralLedger(user_id, relation, name, dates, accountName, amount, typ, 0, explanation);
            list.add(gl);
        }
        return list;
    }

    public ObservableList Search(String AccountName) throws SQLException {

        double balance = 0;
        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();

        ResultSet rse = stmt.executeQuery("SELECT accountType,accountName FROM account WHERE accountName = '" + AccountName + "';");

        String str = "";
        while (rse.next()) {

            str = rse.getString("accountType");


        }


        ObservableList<GeneralLedger> list = FXCollections.observableArrayList();


        ResultSet rs = stmt.executeQuery("select u.user_id, u.user_first_name, u.user_last_name, d.dates, d.accountName, d.amount, d.typ ,d.relation,d.explanation from user u ,DebitCreditInfo d " +
                "where d.userid = u.user_id and accountName = '" + AccountName + "';\n");

        while (rs.next()) {

            int user_id = rs.getInt("user_id");
            int relation = rs.getInt("relation");
            String user_first_name = rs.getString("user_first_name");
            String user_last_name = rs.getString("user_last_name");
            String name = user_first_name + " " + user_last_name;
            String dates = rs.getString("dates");
            String accountName = rs.getString("accountName");
            double amount = rs.getDouble("amount");
            String typ = rs.getString("typ");
            String explanation = rs.getString("explanation");
            if (str.equalsIgnoreCase("assets") || str.equalsIgnoreCase("expenses")) {
                // d+  c-
                if (typ.equalsIgnoreCase("debit")) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            } else {
                if (typ.equalsIgnoreCase("debit")) {
                    balance -= amount;
                } else {
                    balance += amount;
                }
            }

            GeneralLedger gl = new GeneralLedger(user_id, relation, name, dates, accountName, amount, typ, balance, explanation);
            list.add(gl);

            System.out.println(gl.toString());

        }

        return list;
    }




    public ObservableList Accounts() throws SQLException {

        ObservableList<String> list = FXCollections.observableArrayList();
        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();

        ResultSet rse = stmt.executeQuery("SELECT accountType,accountName FROM account ;");

        String str = "";
        while (rse.next()) {

            str = rse.getString("accountName");
            list.add(str);


        }
        return list;
    }


}
