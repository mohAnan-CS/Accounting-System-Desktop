package model;

import sql.DataBaseConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CurrencyModel {

    public String currentCurrency = "EUR";

    ArrayList<String> currencyType = new ArrayList<String>();

    public void getCurrency() throws SQLException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();

        ResultSet rse = stmt.executeQuery("SELECT currency_type,currency_Name FROM currency;");


        while (rse.next()) {

            String currency_type = rse.getString("currency_type");
            currencyType.add(currency_type);
        }
    }

    public boolean checkNumber(String Num){


        if (Num == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(Num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String addCurrency(String currency) throws SQLException, IOException {

        DataBaseConnection db = new DataBaseConnection();
        Statement stmt = db.getConn().createStatement();
        String url = "https://currencies.apps.grandtrunk.net/getlatest/USD/";
        url += currency;

       if (  checkNumber( readFromWeb(url) ) ){

           int flag = 0;

           for (int i=0;i<currencyType.size();i++){
               if (currency.equalsIgnoreCase(currencyType.get(i))){
                   flag = 1;
               }
           }
           if (flag == 0){
               stmt.executeUpdate("insert INTO currency (currency_type) values ('"+currency+"');");
               return "The Currency Was Added";
           }
           else{
               return "The Currency Is In The System";
           }


        }
       else {
           return "You Added a Wrong Currency";
       }



    }

    public  String readFromWeb(String webURL) throws IOException {

        URL url = new URL(webURL);
        InputStream is =  url.openStream();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            line = br.readLine();
            return line;
        }
        catch (MalformedURLException e) {
           e.printStackTrace();
            return "false";
        }
        catch (IOException e) {
            e.printStackTrace();
            return "false";
        }

    }


}
