package org.example;
//package net.codejava.jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//import static jdk.internal.org.jline.utils.Colors.s;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

//        Scanner s = new Scanner(System.in);
        System.out.println("Hello World!");

        String dbURL = "jdbc:mysql://localhost/jdbc_db";
        String username = "root";
        String password = "";
        try {
        Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }
            else {
                System.out.println("Not Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
            Scanner sc= new Scanner(System.in);
            int choice = 0;
            do{
                System.out.println("1 - Insert");
                System.out.println("2 - View");
                System.out.println("3 - Update");
                System.out.println("4 - Delete");
                System.out.println("5 - Exit\n");
                System.out.print("Enter Your Choice : ");

                choice = sc.nextInt();
                switch (choice){
                    case 1:{
                        String sql = "INSERT INTO blog (author, title, content, date) VALUES (?, ?, ?, ?)";
                        PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setString(1, "Pratham");
                        statement.setString(2, "Advance Java");
                        statement.setString(3, "Something Something");
                        statement.setString(4, "2023-01-07");

                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("A new user was inserted successfully!");
                            System.exit(0);
                        }
                        break;
                    }
                    case 2:{
                        String sql = "SELECT * FROM blog";
                        Statement statement = conn.createStatement();
                        ResultSet result = statement.executeQuery(sql);
                        int count = 0;
                        while (result.next())
                        {
                            String author = result.getString(2);
                            String title = result.getString(3);
                            String content = result.getString("content");
                            String date = result.getString("date");
                            String output = "User #%d: %s - %s - %s - %s";
                            System.out.println(String.format(output, ++count, author, title, content, date));
                        }
                        System.exit(0);
                        break;
                    }
                    case 3:{
                        String sql = "UPDATE blog SET title=?, content=?, date=? WHERE author=?";
                        PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setString(1, "Advance Web Technology");
                        statement.setString(2, "Nothing.............");
                        statement.setString(3, "2021-07-12");
                        statement.setString(4, "Belvin");
                        int rowsUpdated = statement.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("An existing user was updated successfully!");
                            System.exit(0);
                        }
                        break;
                    }
                    case 4:{
                        String sql = "DELETE FROM blog WHERE author=?";
                        PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setString(1, "Pratham");
                        int rowsDeleted = statement.executeUpdate();
                        if (rowsDeleted > 0) {
                            System.out.println("A user was deleted successfully!");
                            System.exit(0);
                        }
                        break;
                    }
                    case 5:{
                        System.exit(0);
                    }
                    default:{
                        break;
                    }
                }
            }while(choice < 5);
            // code to execute SQL queries goes here...

            //Insert
//            String sql = "INSERT INTO blog (author, title, content, date) VALUES (?, ?, ?, ?)";
//
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, "Renish");
//            statement.setString(2, "Advance Java");
//            statement.setString(3, "Something Something");
//            statement.setString(4, "2023-01-07");
//
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("A new user was inserted successfully!");
//            }

            // Select Statement
//            String sql = "SELECT * FROM blog";
//
//            Statement statement = conn.createStatement();
//            ResultSet result = statement.executeQuery(sql);
//
//            int count = 0;
//
//            while (result.next()){
//                String author = result.getString(2);
//                String title = result.getString(3);
//                String content = result.getString("content");
//                String date = result.getString("date");
//
//                String output = "User #%d: %s - %s - %s - %s";
//                System.out.println(String.format(output, ++count, author, title, content, date));
//            }

            // If we want to do
//            String author = result.getString(2);
//            String content = result.getString("content");


            // Update
//            String sql = "UPDATE blog SET title=?, content=?, date=? WHERE author=?";
//
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, "Advance Web Technology");
//            statement.setString(2, "Nothing.............");
//            statement.setString(3, "2021-07-12");
//            statement.setString(4, "Belvin");
//
//            int rowsUpdated = statement.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("An existing user was updated successfully!");
//            }

            // Delete
//            String sql = "DELETE FROM blog WHERE author=?";
//
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, "Pratham");
//
//            int rowsDeleted = statement.executeUpdate();
//            if (rowsDeleted > 0) {
//                System.out.println("A user was deleted successfully!");
//            }



        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

//...........................................................................................

//try {
//        Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//        throw new RuntimeException(e);
//        }
//
//        try {
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc_db", "root", "");
//
//        String ins_query = "insert into blog (author, title, content) values (?,?,?)";
//        PreparedStatement prstmt = con.prepareStatement(ins_query);
//        Blog b = new Blog("Pratham","Advance Java","Something Something");
//        prstmt.setString(1,b.getB_author());
//        prstmt.setString(2,b.getB_title());
//        prstmt.setString(3,b.getB_content());
//
//        int ins_rows = prstmt.executeUpdate();
//
//        }
//        catch (SQLException e)
//        {
//        throw new RuntimeException(e);
//        }

//...........................................................................................
//import static jdk.internal.logger.DefaultLoggerFinder.SharedLoggers.system;
// Insert
//            String sql = "INSERT INTO blog (author, title, content, date) VALUES (?, ?, ?, ?)";
//
//            PreparedStatement statement = con.prepareStatement(sql);
//            statement.setString(1, "Dhanraj");
//            statement.setString(2, "Advance Java");
//            statement.setString(3, "Something Something");
//            statement.setString(4, "2003-08-19");
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("A new user was inserted successfully!");
//            }
//
//            // Select
//            String sql1 = "SELECT * FROM blog";
//
//            Statement statement1 = con.createStatement();
//            ResultSet result = statement1.executeQuery(sql1);
//
//            int count = 0;
//
//            while (result.next()){
//                String author = result.getString(2);
//                String title = result.getString(3);
//                String content = result.getString(4);
//                String date = result.getString(5);
//
//                String output = "blog #%d: %s - %s - %s - %s";
//                System.out.println(String.format(author, title, content, date, output, ++count));
//            }
//            // Update
//            String sql2 = "UPDATE blog SET author=?, title=?, content=?, date=? WHERE id=?";
//
//            PreparedStatement statement2 = con.prepareStatement(sql2);
//            statement.setString(2, "Dhanraj");
//            statement.setString(3, "Java");
//            statement.setString(4, "Something");
//            statement.setString(5, "2006-02-19");
//
//            int rowsUpdated = statement.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("An existing user was updated successfully!");
//            }
//            else{
//                System.out.println("Not Updated");
//            }

//............................................................................................

//            if(con != null)
//            {
//                System.out.println("Connection is Ready!!");
//
//                //Statement
//                Statement stmt = con.createStatement();
//                String gry = "INSERT INTO blog(author,title,content,date) VALUES('Pratham',5,'ICT')";
//                int i = stmt.executeUpdate(gry);
//                System.out.println("total rows " + i);
////                String quy = "SELECT * FROM users WHERE name LIKE 'D%'";
////                String gry = "DELETE FROM users where roll = 12";
//                String query = "select * from users";
//                ResultSet rs = stmt.executeQuery(query);
//                while(rs.next())
//                {
//                    System.out.println("ID: - " + rs.getString(1));
//                    System.out.println("Name: - " + rs.getString(2));
//                    System.out.println("Roll Number: - " + rs.getString(3));
//                    System.out.println("Department: - " + rs.getString(4));
//                }
//
//                con.close();
//            }
//            else
//            {
//                System.out.println("Connection Loss");
//            }
//        }
//        catch (SQLException e)
//        {
//            throw new RuntimeException(e);
//        }
//    }