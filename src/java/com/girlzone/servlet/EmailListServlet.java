/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girlzone.servlet;

import com.girlzone.util.MailUtilGmail;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jyoti
 */
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, IOException {

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";        
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } 
        else if (action.equals("addcontact")) {
            // get parameters from the request
            String username = request.getParameter("nameuser");
            String email = request.getParameter("email");
            String message = request.getParameter("message");
            
            // send email to user
            String to = email;
            String from = "email_list@victory.com";
            String subject = "Welcome to our email list";
            String body = "Dear " + username + ",\n"
                    + "Thank you for your request. We will contact you soon."
                    + "\n\n Regards,\n Victory Sports";
            boolean isBodyHTML = false;
            
            try
            {
                MailUtilGmail.sendMail(to, from, subject, body, isBodyHTML);
            }
            catch (MessagingException e)
            {
                String errorMessage = 
                    "ERROR: Unable to send email. " + 
                        "Check Tomcat logs for details.<br>" +
                    "NOTE: You may need to configure your system " + 
                        "as described in chapter 14.<br>" +
                    "ERROR MESSAGE: " + e.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                this.log(
                    "Unable to send email. \n" +
                    "Here is the email you tried to send: \n" +
                    "=====================================\n" +
                    "TO: " + email + "\n" +
                    "FROM: " + from + "\n" +
                    "SUBJECT: " + subject + "\n" +
                    "\n" +
                    body + "\n\n");
            }            
            url = "/confirmcontact.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }    
}
