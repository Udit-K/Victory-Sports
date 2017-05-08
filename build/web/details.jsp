<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>
<c:set var="customerList" value="${customerList}" scope="session"></c:set>
<c:set var="orderList" value="${orderList}" scope="session"></c:set>    
<c:set var="staffList" value="${staffList}" scope="session"></c:set>
    <a href="contact.jsp"><span style="float:right;">&nbsp; &nbsp; Contact Us</span></a>
    <a href="usercontroller?action=logout"><span style="float:right;"> &nbsp; &nbsp; Logout</span></a>
    <a href="index.jsp"><span style="float:right;">&nbsp; &nbsp; Home</span></a>
</section>
<div id="common" style="overflow-x: auto;">
    <center>
        <h1><font color="green">Data Insights</font></h1><br><br>

        <table class="table table-bordered" style="background-color: white; width: auto ; border-color: black; border: 2px solid; width:80%" >
            <tr align= "middle"> <h3><font color="red">Order Details</font></h3></tr>
            <tr>
                <td><b>Customer Name</b></td>
                <td><b>Menu Item</b></td>
                <td><b>Quantity</b></td>
                <td><b>Order Time</b></td>
                <td><b>Amount</b></td>
                <td><b>Order Status</b></td>
                <td><b></b></td>  
            </tr>

        <c:forEach var="order" items="${orderList}">
            <tr>
                <td><c:out value="${order.username}"></c:out></td>
                <td><c:out value="${order.menuItem}"></c:out></td>
                <td><c:out value="${order.quantity}"></c:out></td>
                <td><c:out value= "${order.processingTime}"></c:out></td>
                <td><c:out value= "${order.amount}"></c:out></td>
                <td><c:out value= "${order.orderStatus}"></c:out></td>
                </tr>
        </c:forEach>
    </table>
        
    <table class="table table-bordered" style="background-color: white; width: auto ; border-color: black; border: 2px solid; width:80%" >
        <tr align="middle"> <h3><font color="red">Customer Details</font></h3></tr>
        <tr>
            <td><b>Customer Name</b></td>
            <td><b>Email</b></td>
            <td><b>First name</b></td>
            <td><b>Last Name</b></td>
            <!--<td><b>Phone Number</b></td>
            <td><b>Delivery Address</b></td>-->
            <td><b></b></td>  
        </tr>

        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><c:out value="${customer.userName}"></c:out></td>
                <td><c:out value="${customer.email}"></c:out></td>
                <td><c:out value="${customer.firstName}"></c:out></td>
                <td><c:out value= "${customer.lastName}"></c:out></td>
                <%--<td><c:out value= "${customer.phoneNumber}"></c:out></td>
                <td><c:out value= "${customer.address} , ${customer.city} ,
                       ${customer.state} , ${customer.zipcode}"></c:out></td> --%>
                </tr>
        </c:forEach>
    </table>
        
    <table class="table table-bordered" style="background-color: white; width: auto ; border-color: black; border: 2px solid; width:80%" >
        <tr align="middle"> <h3><font color="red">Staff Details</font></h3></tr>
        <tr>
            <td><b>Staff Name</b></td>
            <td><b>Email</b></td>
            <td><b>First name</b></td>
            <td><b>Last Name</b></td>
            <td><b>Role</b></td>
            <td><b></b></td>  
        </tr>
        <c:forEach var="staff" items="${staffList}">
            <tr>
                <td><c:out value="${staff.userName}"></c:out></td>
                <td><c:out value="${staff.email}"></c:out></td>
                <td><c:out value="${staff.firstName}"></c:out></td>
                <td><c:out value= "${staff.lastName}"></c:out></td>
                <td><c:out value= "${staff.role}"></c:out></td>
                </tr>
        </c:forEach>
    </table>