<%-- 
    Document   : manager
    Created on : Nov 12, 2016, 11:14:19 PM
     Author     : Jyoti
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>
<a href="usercontroller?action=logout"><span style="float:right;">Logout</span></a>
</section>
<div id="common" center>
    <div>
        <h2>Manager Page</h2>
        <center>
            <h4><font color="green">Delete Orders</font></h4>
            <form method="post" action="managercontroller" class="form-inline">
                <a href="managercontroller?action=deleteordersall">Confirm Delete all orders?</button>
                </a></form>
        </center>
        <br>
        <a href="manager.jsp"><span style="float:right;">Go back to Manager Page</span></a>
    </div>
</div>    
<c:import url="/footer.jsp"/>