package model;

import sql.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BalanceSheetModel {

    public double sumOf(String str) throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        ResultSet rse = stmt.executeQuery("select sum(amount) from DebitCreditInfo where accountName = '"+str+"';");
        double ans=0;
        while (rse.next()) {
            ans = rse.getDouble("sum(amount)");
        }
        return ans;
    }

}
