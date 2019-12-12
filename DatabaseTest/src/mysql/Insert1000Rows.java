/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author alonzoch_sd2081
 */
public class Insert1000Rows {

    public Insert1000Rows() {
    }

    public Connection connectToDB() {
        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/alonzo";
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(myUrl, "root", "");
            return connection;
        } catch (Exception e) {
            System.err.println("An error occur!");
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void insertSingleOpen() {

        try {
            Date dateStart = new Date();
            long start = dateStart.getTime();
;            Connection connection = connectToDB();
            for (int i = 1; i < 1001; i++) {
                Statement statement = connection.createStatement();
                String sqlString = "INSERT INTO 1000rowinsert (column1,column2,column3,column4,column5)" + "VALUES('" + i + "','"
                        + (i+1) + "','" + (i + 2) + "','" + (i + 3) + "','" + (i + 4) + "')";
                statement.executeUpdate(sqlString);
            }
            connection.close();

            System.out.println("Added successfully!");
            Date dateEnd = new Date();
            long end = dateEnd.getTime();
            System.out.println("It takes " + ((end - start)/1000) + " seconds to add the data to the database using single open & close connection.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void deleteSingleOpen() {

        try {
            Date dateStart = new Date();
            long start = dateStart.getTime();
            Connection connection = connectToDB();
            for (int i = 1000;i > 0; i--) {
                String sqlString = "DELETE FROM 1000rowinsert WHERE column1=?";
                PreparedStatement preparedStmt = connection.prepareStatement(sqlString);
                preparedStmt.setInt(1, i);

                // execute the preparedstatement
                preparedStmt.execute();
            }
            connection.close();

            System.out.println("Deleted successfully!");
            Date dateEnd = new Date();
            long end = dateEnd.getTime();
            System.out.println("It takes about " + ((end-start)/1000) + " seconds in deleting all datas in the database using single open & close connection.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void insertOpenClose() {

        try {
            Date dateStart = new Date();
            long start = dateStart.getTime();
            for (int i = 1; i < 301; i++) {
                Connection connection = connectToDB();
                Statement statement = connection.createStatement();
                String sqlString = "INSERT INTO 1000rowinsert (column1,column2,column3,column4,column5)" + "VALUES('" + i + "','"
                        + (i) + "','" + (i + 1) + "','" + (i + 2) + "','" + (i + 3) + "')";
                statement.executeUpdate(sqlString);
                connection.close();
            }

            System.out.println("Added successfully!");
            Date dateEnd = new Date();
            long end = dateEnd.getTime();
            System.out.println("It takes " + ((end - start)/1000) + " seconds to add the data to the database using open & close per write connection.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void deleteOpenClose() {

        try {
            Date dateStart = new Date();
            long start = dateStart.getTime();
            for (int i = 300;i > 0; i--) {
                Connection connection = connectToDB();
                String sqlString = "DELETE FROM 1000rowinsert WHERE column1=?";
                PreparedStatement preparedStmt = connection.prepareStatement(sqlString);
                preparedStmt.setInt(1, i);

                // execute the preparedstatement
                preparedStmt.execute();
                connection.close();
            }
            System.out.println("Deleted successfully!");
            Date dateEnd = new Date();
            long end = dateEnd.getTime();
            System.out.println("It takes about " + ((end-start)/1000) + " seconds in deleting all datas in the database using open & close per delete connection.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public void getAverageInLoop() {
        try {
            double total1 = 0;
            double total2 = 0;
            double total3 = 0;
            double total4 = 0;
            double total5 = 0;
            Date dateStart = new Date();
            long start = dateStart.getTime();
            String query = "SELECT * FROM 1000rowinsert";
            Connection connection = connectToDB();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                total1 += rs.getInt(1);
                total2 += rs.getInt(2);
                total3 += rs.getInt(3);
                total4 += rs.getInt(4);
                total5 += rs.getInt(5);
            }
            
            for (int i = 1; i < 10001; i++) {
                
            }
            connection.close();
            Date dateEnd = new Date();
            long end = dateStart.getTime();
            System.out.println("Average row 1 : "+total1/1000);
            System.out.println("Average row 1 : "+total2/1000);
            System.out.println("Average row 1 : "+total3/1000);
            System.out.println("Average row 1 : "+total4/1000);
            System.out.println("Average row 1 : "+total5/1000);
            System.out.println("It takes about " + ((start - end)) + " to get the average.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void getAverageUsingAVG() {
        try {
            String query =  "SELECT column1, AVG(column1) AS 'Average FirstColumn',column2,AVG(column2) AS 'Average SecondColumn',column3,AVG(column3) AS 'Average ThirdColumn',"
                    + "column4,AVG(column4) AS 'Average FourthColumn',column5,AVG(column5) AS 'Average FifthColumn' FROM `1000rowinsert` WHERE 1";
            Date dateStart = new Date();
            long start = dateStart.getTime();
            Connection connection = connectToDB();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                System.out.println(rs.getInt(2));
                System.out.println(rs.getInt(4));
                System.out.println(rs.getInt(6));
                System.out.println(rs.getInt(8));
                System.out.println(rs.getInt(10));
            }
            connection.close();
            Date dateEnd = new Date();
            long end = dateStart.getTime();
            System.out.println("It takes about " + ((end-start)) + " to get the average.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        Insert1000Rows i = new Insert1000Rows();
//        i.insertSingleOpen();
//        i.deleteSingleOpen();
//        i.insertOpenClose();
//        i.deleteOpenClose();
        i.getAverageInLoop();
        i.getAverageUsingAVG();
    }
}
