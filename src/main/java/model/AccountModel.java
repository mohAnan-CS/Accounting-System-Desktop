package model;

import com.example.controllers.TableViewClass.AccountTableView;
import com.example.controllers.TableViewClass.IncomeStateTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sql.DataBaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

    public ObservableList getAccounts() throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        ResultSet rs = stmt.executeQuery("select accountRef,accountName,accountType from account;");
        ObservableList<Account> list = FXCollections.observableArrayList();

        int i = 0 ;
        while (rs.next()) {
            int ref = rs.getInt("accountRef");
            String accountName = rs.getString("accountName");
            String accountType = rs.getString("accountType");
            Account a = new Account(ref, accountType, accountName);

            list.add(a);
            System.out.println(list.get(i).toString());
            i++;
        }

        return list;


    }

    public ObservableList<IncomeStateTableView> fun() throws SQLException {
        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        ArrayList<String> accountArr = new ArrayList<String>();
        ObservableList<IncomeStateTableView> list = FXCollections.observableArrayList();

        stmt.executeUpdate("truncate table report;");

        ResultSet rse = stmt.executeQuery("SELECT accountName,accountType FROM account where accountType = 'expenses';");
        while (rse.next()) {
            String accountName = rse.getString("accountName");
            String accountType = rse.getString("accountType");

            accountArr.add(accountName);
        }


        for (int i=0;i<accountArr.size();i++){
            rse = stmt.executeQuery("SELECT accountName,amount FROM DebitCreditInfo WHERE accountName = '" + accountArr.get(i) + "';");
            String str = "";
            double balance=0;
            while (rse.next()) {

                str = rse.getString("accountName");
                balance += rse.getDouble("amount");
            }
            if ( !str.isEmpty() ){

                list.add(new IncomeStateTableView(str , String.valueOf(balance)));
            }

        }

        return list ;
    }

    public double fun1() throws SQLException {
        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        double ans=0;
        ResultSet rs = stmt.executeQuery("select sum(amount) from account a,DebitCreditInfo d where a.accountName = d.accountName and accountType = 'expenses';");
        while (rs.next()) {

            ans = rs.getInt("sum(amount)");
        }
        return ans;
    }

    public double fun2() throws SQLException {
        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        double ans=0;


        ResultSet rs = stmt.executeQuery("select sum(amount) from account a,DebitCreditInfo d where a.accountName = d.accountName and accountType = 'revinue';");
        while (rs.next()) {

            ans = rs.getInt("sum(amount)");
        }
        return ans;
    }
}
