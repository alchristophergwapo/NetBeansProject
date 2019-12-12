/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author alonzoch_sd2081
 */
public class CRUD {

    String databaseName = "alonzo";

    public Connection connectToDB() {
        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/" + databaseName;
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(myUrl, "root", "");
            return connection;
        } catch (Exception e) {
            System.err.println("An error occur!");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean addData(String[] data, String tableName, String csv) {
        String query = "INSERT INTO " + tableName + "(" + csv + ")" + "VALUES('";
        for(int i =0;i < data.length; i++) {
            if(i != (data.length  - 1)) {
                query += data[i] + "','";
            }if (i == (data.length - 1)){
                query += data[i] + "')";
            }
        }
        System.out.println(query);
        try {
            Connection connection = connectToDB();
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }
    }

    public ResultSet getData(String username, String selectWhat, String identifier, String tablename) {
        String accountQuery = "SELECT " + selectWhat + " FROM " + tablename + " WHERE " + identifier + "=" + "\"" + username + "\"" + ";";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = connectToDB();
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(accountQuery);
            return rs;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ResultSet getAllData(String tableName) {
        String accountQuery = "SELECT * FROM " + tableName + ";";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = connectToDB();
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(accountQuery);
            return rs;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean deleteData(String tableName, String identifier, String value) {
        try {
            String deleteQuery = "DELETE FROM " + tableName + " WHERE " + identifier + "=" + "\"" + value + "\"" + ";";
            Connection connection = connectToDB();
            Statement statement = connection.createStatement();
            statement.executeUpdate(deleteQuery);
            connection.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean editData(String tableName, String[] valuetoEdit,String[] data, String valueWhere, String value) {
        try {
            String editQuery = "UPDATE " + tableName + " SET ";
            for(int i =0; i < valuetoEdit.length; i++) {
               if(i != (valuetoEdit.length-1)){
                   editQuery += valuetoEdit[i] + " = ? ,";
               } if(i == valuetoEdit.length - 1 ) {
                   editQuery += valuetoEdit[i] + " = ? ";
               }
            }
            editQuery += "WHERE " + valueWhere + " =" + "\"" + value + "\"" + ";";
            Connection connection = connectToDB();
            PreparedStatement psmt = connection.prepareStatement(editQuery);
            for(int i = 1; i < valuetoEdit.length+1; i++) {
                psmt.setString(i, data[i-1]);
            }
            System.out.println(editQuery);
            psmt.executeUpdate();
            connection.close();
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
