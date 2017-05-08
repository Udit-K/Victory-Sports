/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girlzone.servlet;

import com.girlzone.business.Order;
import com.girlzone.business.Password;
import com.girlzone.business.User;
import com.girlzone.dao.OrdersDB;
import com.girlzone.util.PasswordUtil;
import com.girlzone.dao.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
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
public class UserController extends HttpServlet {

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
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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

        String abc = "hi";
        String action = request.getParameter("action");
        String url = "";

        if (abc.equals("hi")) {
            String serverInfo = request.getServerName() + " :: " + request.getServerPort();

            Cookie cookie1 = new Cookie("host", request.getServerName());
            cookie1.setMaxAge(60 * 60 * 24 * 365 * 2);
            cookie1.setPath("/");
            response.addCookie(cookie1);

            Cookie cookie2 = new Cookie("port", String.valueOf(request.getServerPort()));
            cookie2.setMaxAge(60 * 60 * 24 * 365 * 2);
            cookie2.setPath("/");
            response.addCookie(cookie2);

            Cookie cookie = new Cookie("server", serverInfo);

            log("Cookie" + cookie1.getValue());
            response.addCookie(cookie);
            response.addCookie(cookie);
            url = "/index.jsp";

        }

        ServletContext sc = getServletContext();

        HttpSession session = request.getSession();
        // String url = "/index.jsp";
        String msg;
        User user = null;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (action == null) {
            url = "/index.jsp";
        }

        if (action.equals("deleteorder")) {
            String orderId = request.getParameter("param1");
            OrdersDB.updateOrder(orderId);
            ArrayList<Order> orderList = UserDB.selectOrders();
            session.setAttribute("orderList", orderList);
            url = "/waiter.jsp";

        }

        if (action.equals("deleteorderbar")) {
            String orderId = request.getParameter("param1");
            //OrdersDB.deleteOrder(orderId);

            List<Order> orderList = OrdersDB.getOrders();
            session.setAttribute("orderList", orderList);

            url = "/barattend.jsp";

        }

        if (action.equals("signup")) {
            String usernameCustomer = request.getParameter("username");
            String firstname = request.getParameter("fname");
            String lastaname = request.getParameter("lname");
            String role = request.getParameter("role");
            String email = request.getParameter("email");
            String passwordCustomer = request.getParameter("password");
            //String address = request.getParameter("address");
            //String city = request.getParameter("city");
            //String state = request.getParameter("state");
            //String zipcode = request.getParameter("zipcode");
            //String phonenumber = request.getParameter("number");
            try {
                PasswordUtil.checkPasswordStrength(password);
            } catch (Exception ex) {
                Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
                String pass = "Password too weak";
                session.setAttribute("password", pass);
                sc.getRequestDispatcher("/signup.jsp")
                        .forward(request, response);
            }
            String passwordhash = null;
            String salt = PasswordUtil.getSalt();
            try {
                passwordhash = PasswordUtil.hashAndSaltPassword(passwordCustomer, salt);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
            }

            User userCustomer = new User();
            userCustomer.setEmail(email);
            userCustomer.setLastName(lastaname);
            userCustomer.setFirstName(firstname);
            userCustomer.setPassword(passwordhash);
            userCustomer.setRole(role);
            userCustomer.setUserName(usernameCustomer);
            //userCustomer.setAddress(address);
            //userCustomer.setCity(city);
            //userCustomer.setZipcode(Integer.parseInt(zipcode));
            //userCustomer.setState(state);
            //userCustomer.setPhoneNumber(Integer.parseInt(phonenumber));
            // Integer i=UserDB.insertUser(userCustomer);
            Integer i = UserDB.insertUser(userCustomer);
            UserDB.insertUSerPassword(username, passwordhash, salt);

            if (i == 1) {
                if (!(role.isEmpty())) {
                    UserDB.insertUserRole(username, role);
                    url = "/login.jsp";
                }
            } else {
                String msg3 = "User already exist";
                request.setAttribute("msg3", msg3);
                url = "/signup.jsp";
            }
        }
        if (action.equals("login")) {
            Password pass;
            pass = UserDB.getPassword(username);
            String passwordhash = null;

            try {
                String salt = pass.getSalt();
                passwordhash = PasswordUtil.hashPassword(password + salt);
                log("passwordHash" + passwordhash);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Boolean value = UserDB.validateUser(passwordhash, username);
            log("Value" + value);

            if (value) {
                user = UserDB.getUser(username);
                String role = UserDB.getUserRole(username);
                user.setRole(role);
                session.setAttribute("user", user);

                log("Role " + role);

                if (role.equals("Manager")) {
                        url = "/manager.jsp";
                } else if (role.equals("Designer")) {
                        ArrayList<Order> orderList = UserDB.selectOrders();
                        request.setAttribute("orderList", orderList);
                        url = "/waiter.jsp";
                } else if (role.equals("Customer")) {

                        String cookie_customername = user.getUserName();
                        Cookie c = new Cookie("cookie_customername", cookie_customername);
                        c.setMaxAge(60 * 60 * 24 * 365 * 2);
                        c.setPath("/");
                        response.addCookie(c);

                        log(user.getUserName());
                        url = "/index.jsp";
                }

            } else {
                msg = "Invalid Credentials";
                request.setAttribute("message", msg);
                url = "/login.jsp";
            }

            //user = UserDB.getUser(username);
        } else if (action.equals("logout")) {

            if (session.getAttribute("user") != null) {
                session.invalidate();
                url = "/login.jsp";
            } else {
                url = "/login.jsp";
            }
        }
        sc.getRequestDispatcher(url)
                .forward(request, response);

        processRequest(request, response);
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
