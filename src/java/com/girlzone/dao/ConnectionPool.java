/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package com.girlzone.dao;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/nbad");
        } catch (NamingException e) {
            System.out.println(e);
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

   public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://assignment2.czcorxm8kkgd.us-west-2.rds.amazonaws.com:3306/nbad?user=bnakka&password=Baby2312");
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }   

    public void freeConnection(Connection c) {
        try {if(c!= null){
            c.close();
        c = null;
        }} catch (SQLException e) {
            System.out.println(e);
        }
    }

}
*/



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.girlzone.dao;


import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nbad?user=root&password=root");
//Connection con = DriverManager.getConnection(
//   "jdbc:mysql://assignment2.c4xxw8dys01u.us-west-2.rds.amazonaws.com:3306/nbad?user=skothar4&password=password");      
           return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }    
    
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/nbad");
        } catch (NamingException e) {
            System.out.println(e);
        }
    } 

    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

   // public Connection getConnection() {
     //   try {
    //        return dataSource.getConnection();
   //     } catch (SQLException e) {
   //         System.out.println(e);
   //         return null;
  //      }
//    }

    public void freeConnection(Connection c) {
        try {if(c!= null){
            c.close();
        c = null;
        }} catch (SQLException e) {
            System.out.println(e);
        }
    }
}
