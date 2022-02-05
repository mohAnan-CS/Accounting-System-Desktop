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
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM account;" );
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
        ResultSet rs = stmt.executeQuery("select u.user_id, u.user_first_name, u.user_last_name, d.dates, d.accountName, d.amount, d.typ ,d.relation from user u ,DebitCreditInfo d where d.userid = u.user_id;\n" );

        while (rs.next()) {

            int user_id = rs.getInt("user_id");
            int relation = rs.getInt("relation");
            String user_first_name = rs.getString("user_first_name");
            String user_last_name = rs.getString("user_last_name");
            String name = user_first_name +" "+user_last_name;
            String dates = rs.getString("dates");
            String accountName = rs.getString("accountName");
            double amount = rs.getDouble("amount");
            String typ = rs.getString("typ");

            GeneralLedger gl = new GeneralLedger(user_id,relation,name,dates,accountName,amount,typ);
            list.add(gl);
        }
        return list;
    }
    public ObservableList Search(String AccountName) throws SQLException {

        ObservableList<GeneralLedger> list = FXCollections.observableArrayList();

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        ResultSet rs = stmt.executeQuery("select u.user_id, u.user_first_name, u.user_last_name, d.dates, d.accountName, d.amount, d.typ ,d.relation from user u ,DebitCreditInfo d " +
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

            GeneralLedger gl = new GeneralLedger(user_id, relation, name, dates, accountName, amount, typ);
            list.add(gl);
        }
        return list;
    }


}
