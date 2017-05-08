/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girlzone.servlet;

import com.girlzone.business.Order;
import com.girlzone.business.Role;
import com.girlzone.business.User;
import com.girlzone.dao.ConnectionPool;
import com.girlzone.dao.OrdersDB;
import com.girlzone.util.PasswordUtil;
import com.girlzone.dao.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jyoti
 */
public class ManagerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManagerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagerController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();

        String action = request.getParameter("action");

        HttpSession session = request.getSession();
        String url = "null";

        if (action.equals("getrole")) {

            ArrayList<Role> role = new ArrayList<Role>();
            role = UserDB.getRoles();
            session.setAttribute("roleList", role);
            url = "/user.jsp";
        }

        if (action.equals("adduser")) {

            String username = request.getParameter("username");
            String firstname = request.getParameter("fname");
            String lastaname = request.getParameter("lname");
            String role = request.getParameter("role");
            String email = request.getParameter("email");

            String password = request.getParameter("password");
            try {
                PasswordUtil.checkPasswordStrength(password);
            } catch (Exception ex) {
                Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
                String pass = "Password too weak";
                session.setAttribute("password", pass);
                sc.getRequestDispatcher("/user.jsp")
                        .forward(request, response);
            }
            String passwordhash = null;

            String salt = PasswordUtil.getSalt();
            try {
                passwordhash = PasswordUtil.hashAndSaltPassword(password, salt);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
            }

            User user = new User();
            user.setEmail(email);
            user.setLastName(lastaname);
            user.setFirstName(firstname);
            user.setPassword(passwordhash);
            user.setRole(role);
            user.setUserName(username);

            // Integer i=UserDB.insertUser(user);
            Integer i = UserDB.insertUser(user);
            UserDB.insertUSerPassword(username, passwordhash, salt);

            if (i == 1) {
                if (!(role.isEmpty())) {
                    UserDB.insertUserRole(username, role);
                    url = "/manager.jsp";
                } else {
                    url = "/manager.jsp";
                }

            } else {
                String msg3 = "User already exist";
                request.setAttribute("msg3", msg3);
                url = "/user.jsp";
            }

        }

        if (action.equals("adduserrole")) {
            ArrayList<User> userList = new ArrayList<User>();
            ArrayList<Role> role = new ArrayList<Role>();
            role = UserDB.getRoles();
            session.setAttribute("roleList", role);

            userList = UserDB.selectUsers();

            session.setAttribute("userList", userList);

            url = "/adduserrole.jsp";

        }

        if (action.equals("addrole")) {
            String role = request.getParameter("role");
            String username = request.getParameter("username");

            log("Role " + role);
            log("Username " + username);

            User user = UserDB.selectUserRole(username);
            if (user.getRole() != null && user.getUserName() != null) {
                UserDB.updateRole(username, role);
            } else {
                Integer i = UserDB.insertUserRole(username, role);
            }

            //log("Role "+i);
            //System.out.print("Role "+i);
            url = "/manager.jsp";

        }

        if (action.equals("roleupdate")) {

            String role = request.getParameter("rolename");

            UserDB user = new UserDB();
            Integer i = user.insertRole(role);
            if (i == 1) {
                url = "/manager.jsp";
            } else {
                String msg2 = "Role already exist";
                request.setAttribute("msg2", msg2);
                url = "/addrole.jsp";

            }

        }

        if (action.equals("deleteorders")) {

            OrdersDB order = new OrdersDB();
            order.deleteOrders();

            url = "/deleteorders.jsp";

        }

        if (action.equals("deleteordersall")) {

            OrdersDB order = new OrdersDB();
            order.deleteOrders();

            url = "/manager.jsp";

        }

        if (action.equals("viewdetails")) {
            ArrayList<User> customerList = UserDB.selectCustomers();
            ArrayList<Order> orderList = UserDB.selectOrders();
            ArrayList<User> staffList = UserDB.selectStaff();
            request.setAttribute("customerList", customerList);
            request.setAttribute("orderList", orderList);
            request.setAttribute("staffList", staffList);
            url = "/details.jsp";

        }

        sc.getRequestDispatcher(url)
                .forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
