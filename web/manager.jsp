<%-- 
    Document   : manager
    Created on : Nov 22, 2016, 1:17:39 AM
     Author     : Jyoti
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>
<a href="contact.jsp"><span style="float:right;">&nbsp; &nbsp; Contact Us</span></a>
<a href="usercontroller?action=logout"><span style="float:right;"> &nbsp; &nbsp; Logout</span></a>
<a href="index.jsp"><span style="float:right;">&nbsp; &nbsp; Home</span></a>
</section>

<div id="common"><center>
    <div>
    <h2>Manager Page</h2>
    <div style="float:left">
        <table cellspacing="100">
        <td style="padding-right: 100px"><li><img src="images/AddUser.jpg" height="250" width="250"><a href="managercontroller?action=getrole">&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; Add Users</a></li></td> &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
        <td style="padding-right: 100px"><li><img src="images/DeleteOrders.PNG" height="250" width="250"> <a href="managercontroller?action=deleteorders">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; Delete All Orders</a></li></td>
        <td style="padding-right: 100px"><li><img src="images/ViewDetails.jpg" height="250" width="250"><a href="managercontroller?action=viewdetails">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;View Details</a></li></td>
        </table>
    </div> 
           </div></center>
</div>    
<c:import url="/footer.jsp"/>  

