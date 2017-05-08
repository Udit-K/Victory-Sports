/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girlzone.dao;

import com.girlzone.util.DBUtil;
import com.girlzone.business.Menu;
import com.girlzone.business.Order;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author jyoti
 */
public class OrdersDB {

    public static ArrayList<Menu> selectMenus() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        ResultSet rs = null;
        ArrayList<Menu> menuList = new ArrayList<Menu>();

        String query = "SELECT * FROM menu";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Menu menu = null;
            while (rs.next()) {
                menu = new Menu();
                menu.setMenuNumber(Integer.parseInt(rs.getString("MenuNumber")));
                menu.setMenuType(rs.getString("MenuType"));
                menu.setPrice(Double.parseDouble(rs.getString("Price")));
                menu.setMenuItem(rs.getString("MenuItem"));

                menuList.add(menu);
            }

            return menuList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static Menu getMenuDetails(int number) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM menu "
                + "WHERE MenuNumber = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(number));
            rs = ps.executeQuery();
            Menu menu = null;
            if (rs.next()) {
                menu = new Menu();
                menu.setMenuNumber(Integer.parseInt(rs.getString("MenuNumber")));
                menu.setMenuType(rs.getString("MenuType"));
                menu.setPrice(Double.parseDouble(rs.getString("Price")));
                menu.setMenuItem(rs.getString("MenuItem"));
            }

            return menu;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Order> getOrders() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        ResultSet rs = null;
        ArrayList<Order> orderList = new ArrayList<Order>();

        String query = "SELECT * FROM orders";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            Order order = null;

            while (rs.next()) {
                ArrayList<Menu> menuList = new ArrayList<Menu>();
                order = new Order();
                order.setOrderId(rs.getString("OrderID"));
                order.setOrderTime(rs.getString("OrderTime"));
                order.setProcessingTime(rs.getString("ProcessTime"));
                order.setResponseTime(rs.getString("ResponseTime"));
                order.setMenuNumber(Integer.parseInt((rs.getString("MenuNumber"))));
                order.setQuantity(Integer.parseInt(rs.getString("Quantity")));
                order.setProcessorNumber(Double.parseDouble(rs.getString("ProcessorNumber")));
                order.setServerNumber(Double.parseDouble(rs.getString("ServerNumber")));

                Integer menuNumber = order.getMenuNumber();

                Menu menu = getMenuDetails(menuNumber);
                menuList.add(menu);
                order.setMenuList(menuList);
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

    public static void insertOrder(Order order, String userName) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String id1 = "232";
        String id2 = "123";
        String tableNum="12";
        String orderStatus = "New";

        String query
                = "INSERT INTO orders (UserName,OrderTime,ProcessTime,ResponseTime,MenuNumber,Quantity,OrderStatus) "
                + "VALUES (?,Now(), Now(), Now(), ?, ?, 'New')";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, String.valueOf(order.getMenuNumber()));
            ps.setString(3, String.valueOf(order.getQuantity()));      

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static void insertAmount(String userName, Double amount) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String id1 = "232";
        String id2 = "123";

        String query
                = "INSERT INTO useramount (UserName, Total) "
                + "VALUES (?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, String.valueOf(amount));

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static void insertOrderDetails(Order order, int Tablenumber) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO ordersdetails (OrderID, MenuNumber, Quantity) "
                + "VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, String.valueOf(Tablenumber));
            ps.setString(2, String.valueOf(order.getMenuNumber()));
            ps.setString(3, String.valueOf(order.getQuantity()));

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int deleteOrders() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM orders";
        try {
            ps = connection.prepareStatement(query);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int updateOrder(String OrderId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String orderStatus = "Completed";

        String query = "Update orders set OrderStatus=? where OrderID=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, orderStatus);
            ps.setString(2, OrderId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static Order getOrder(String OrderId, String filepath) throws ParseException {
        Order order = new Order();
        File file = new File(filepath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String orderNumber = t.nextToken();
                if (orderNumber.equalsIgnoreCase(OrderId)) {

                    String number = t.nextToken();
                    String orderTime = t.nextToken();
                    String processTime = t.nextToken();
                    String responseTime = t.nextToken();
                    String menuNumber = t.nextToken();
                    String quantity = t.nextToken();
                    String processorNumber = t.nextToken();
                    String serverNumber = t.nextToken();

                    SimpleDateFormat df = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
                    Date date1 = df.parse(orderTime);
                    Date date2 = df.parse(processTime);
                    Date date3 = df.parse(responseTime);

                    order.setMenuNumber(Integer.parseInt(menuNumber));

                    order.setOrderId(OrderId);
                    order.setOrderTime(orderTime);
                    order.setProcessingTime(orderTime);
                    order.setProcessorNumber(Double.parseDouble(processorNumber));
                    order.setServerNumber(Double.parseDouble(serverNumber));
                    order.setQuantity(Integer.parseInt(quantity));
                    order.setResponseTime(orderTime);

                    line = in.readLine();
                }

            }
            in.close();
            return order;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    public static List<Order> geTableOrders(String TNumber, String filepath) throws ParseException {
        List<Order> orderList = new ArrayList<Order>();
        File file = new File(filepath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                Order order = new Order();
                String orderNumber = t.nextToken();
                String number = t.nextToken();
                if (number.equalsIgnoreCase(TNumber)) {
                    String orderTime = t.nextToken();
                    String processTime = t.nextToken();
                    String responseTime = t.nextToken();
                    String menuNumber = t.nextToken();
                    String quantity = t.nextToken();
                    String processorNumber = t.nextToken();
                    String serverNumber = t.nextToken();

                    SimpleDateFormat df = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
                    Date date1 = df.parse(orderTime);
                    Date date2 = df.parse(processTime);
                    Date date3 = df.parse(responseTime);

                    order.setMenuNumber(Integer.parseInt(menuNumber));

                    order.setOrderId(orderNumber);
                    order.setOrderTime(orderTime);
                    order.setProcessingTime(orderTime);
                    order.setProcessorNumber(Double.parseDouble(processorNumber));
                    order.setServerNumber(Double.parseDouble(serverNumber));
                    order.setQuantity(Integer.parseInt(quantity));
                    order.setResponseTime(orderTime);

                    orderList.add(order);
                    line = in.readLine();
                }

            }
            in.close();
            return orderList;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }

    }
}
