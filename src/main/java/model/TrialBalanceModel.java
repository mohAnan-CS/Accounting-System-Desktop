package model;

import com.example.controllers.TableViewClass.TrialBalanceTableView;
import sql.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TrialBalanceModel {

    public TrialBalanceTableView getBalance(String AccountName) throws SQLException {

        double balance = 0;
        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();

        ResultSet rse = stmt.executeQuery("SELECT accountType,accountName FROM account WHERE accountName = '" + AccountName + "';");

        String str = "";
        while (rse.next()) {

            str = rse.getString("accountType");

        }

        ResultSet rs = stmt.executeQuery("select accountName, amount, typ from DebitCreditInfo  " + "where accountName = '" + AccountName + "';\n");

        while (rs.next()) {

            String accountName = rs.getString("accountName");
            double amount = rs.getDouble("amount");
            String typ = rs.getString("typ");

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
        }
        String ans;
        if (str.equalsIgnoreCase("assets") || str.equalsIgnoreCase("expenses")) {
            if (balance >= 0) {
                ans = "Debit";
            } else {
                ans = "Credit";
            }
        } else {
            if (balance >= 0) {
                ans = "Credit";
            } else {
                ans = "Debit";
            }
        }


        TrialBalanceTableView trialBalanceTableView;
        if (ans.equalsIgnoreCase("Debit"))
            trialBalanceTableView = new TrialBalanceTableView(AccountName, String.valueOf(balance), "");
        else
            trialBalanceTableView = new TrialBalanceTableView(AccountName, "", String.valueOf(balance));

        return trialBalanceTableView ;

    }

}
