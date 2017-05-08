package com.girlzone.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.apache.jasper.tagplugins.jstl.core.Catch;

public class JavaConnectDb {

    public static Connection connectDb() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad?autoReconnect=true&useSSL=false", "root", "root");
            Statement myStmt = conn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from user");
            while (myRs.next()) {
                //System.out.println(myRs.getString("name") + ", " + myRs.getString("email"));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return conn;

    }
}

/*
package com.girlzone.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.apache.jasper.tagplugins.jstl.core.Catch;

public class JavaConnectDb {

    public static Connection connectDb() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://assignment2.czcorxm8kkgd.us-west-2.rds.amazonaws.com:3306/nbad?user=bnakka&password=Baby2312");
            Statement myStmt = conn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from user");
            while (myRs.next()) {
                //System.out.println(myRs.getString("name") + ", " + myRs.getString("email"));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return conn;

    }
}
*/