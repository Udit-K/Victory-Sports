/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mystarbucks.dao;

import com.mystarbucks.business.Menu;
import com.mystarbucks.business.Order;
import com.mystarbucks.util.DBUtil;
import com.mystarbucks.business.Password;
import com.mystarbucks.business.Role;
import com.mystarbucks.business.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author jyoti
 */
public class UserDB {

    public static Password getPassword(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Password password = null;
        String query = "SELECT * FROM userpassword "
                + "WHERE UserName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            password = new Password();
            if (rs.next()) {
                password.setUserName(rs.getString("UserName"));
                password.setPassword(rs.getString("UserPassword"));
                password.setSalt(rs.getString("Salt"));

            }
            return password;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int insertUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO users (UserName, UserPassword, Email, FirstName, LastName, PhoneNumber, Address, City, State, Zipcode) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
            ps.setString(6, String.valueOf(user.getPhoneNumber()));
            ps.setString(7, user.getAddress());
            ps.setString(8, user.getCity());
            ps.setString(9, user.getState());
            ps.setString(10, String.valueOf(user.getZipcode()));

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int insertUSerPassword(String username, String passwordhash, String salt) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO userpassword (UserName, UserPassword, Salt) "
                + "VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, passwordhash);
            ps.setString(3, salt);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean validateUser(String password, String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean value = true;
        String query = "SELECT UserName, UserPassword FROM userpassword "
                + "WHERE UserName = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            User user = new User();
            while (rs.next()) {
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("UserPassword"));
            }
            //value = (user.getUserName()).equals(username) && (user.getPassword()).equals(password);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return value;
    }

    public static int insertRole(String role) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO roles (RoleName) "
                + "VALUES (?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, role);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int insertUserRole(String username, String role) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO userrole (UserName,RoleName) "
                + "VALUES (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, role);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<User> selectUsers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> userList = new ArrayList<User>();

        String query = "SELECT * FROM users";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setUserName(rs.getString("UserName"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                userList.add(user);
            }

            return userList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static User selectUserRole(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> userList = new ArrayList<User>();

        String query = "SELECT * FROM userrole "
                + "WHERE UserName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setUserName(rs.getString("UserName"));
                user.setRole(rs.getString("RoleName"));

            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Role> getRoles() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Role> roleList = new ArrayList<Role>();

        String query = "SELECT * FROM roles";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Role role = null;
            while (rs.next()) {
                role = new Role();
                role.setRole(rs.getString("RoleName"));
                roleList.add(role);
            }

            return roleList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static User getUser(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM users "
                + "WHERE UserName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            User user = new User();
            while (rs.next()) {

                user.setUserName(rs.getString("UserName"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("UserPassword"));

            }

            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    public static int updateRole(String username, String role) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE userrole SET "
                + "RoleName = ? "
                + "WHERE UserName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, role);
            ps.setString(2, username);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static String getUserRole(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String role = null;
        String query = "SELECT RoleName FROM userrole "
                + "WHERE UserName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                role = (rs.getString("RoleName"));
            }
            return role;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    public static ArrayList<String> getUsernameRole(String role) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> list = new ArrayList<String>();
        String username = null;
        String query = "SELECT UserName FROM userrole "
                + "WHERE RoleName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, role);
            rs = ps.executeQuery();
            while (rs.next()) {
                username = (rs.getString("UserName"));
                list.add(username);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    public static ArrayList<User> getUsers(String filepath) {
        ArrayList<User> userList = new ArrayList<User>();

        File file = new File(filepath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String username = t.nextToken();
                String email = t.nextToken();
                String firstname = t.nextToken();
                String lastname = t.nextToken();
                String password = t.nextToken();
                String role = t.nextToken();

                User user = new User();
                user.setUserName(username);
                user.setEmail(email);
                user.setFirstName(firstname);
                user.setLastName(lastname);
                user.setPassword(password);
                user.setPassword(password);
                user.setRole(role);

                userList.add(user);

                line = in.readLine();
            }
            in.close();
            return userList;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    public static ArrayList<Order> selectOrders() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Order> orderList = new ArrayList<Order>();

        String query = "select orders.OrderID, orders.OrderStatus, orders.Quantity*menu.price as Amount, menu.MenuItem, orders.OrderTime, orders.ProcessTime, orders.ResponseTime, orders.Quantity, orders.UserName from orders \n"
                + "join menu on menu.MenuNumber = orders.MenuNumber;";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Order order = null;
            while (rs.next()) {
                order = new Order();
                order.setOrderId(rs.getString("OrderID"));
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setUsername(rs.getString("UserName"));
                order.setOrderTime(rs.getString("OrderTime"));
                order.setProcessingTime(rs.getString("ProcessTime"));
                order.setResponseTime(rs.getString("ResponseTime"));
                order.setMenuItem(rs.getString("MenuItem"));
                order.setQuantity(rs.getInt("Quantity"));
                order.setTotal(rs.getDouble("Amount"));
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<User> selectCustomers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> userList = new ArrayList<User>();

        String query = "SELECT users.UserName, Email, FirstName, LastName, PhoneNumber, Address, City, State, Zipcode FROM users join userrole on users.UserName=userrole.UserName where RoleName= 'Customer'";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setUserName(rs.getString("UserName"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPhoneNumber(Integer.parseInt(rs.getString("PhoneNumber")));
                user.setAddress(rs.getString("Address"));
                user.setCity(rs.getString("City"));
                user.setState(rs.getString("State"));
                user.setZipcode(Integer.parseInt(rs.getString("Zipcode")));
                userList.add(user);
            }
            System.out.println("customerList" + userList.toString());
            return userList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<User> selectStaff() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> userList = new ArrayList<User>();

        String query = "SELECT users.UserName, Email, FirstName, LastName, RoleName FROM users join userrole on users.UserName=userrole.UserName where RoleName= 'Manager' or Rolename = 'Waiter'";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setUserName(rs.getString("UserName"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setRole(rs.getString("RoleName"));
                userList.add(user);
            }
            System.out.println("staffList" + userList.toString());
            return userList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

}
