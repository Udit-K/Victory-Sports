<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>
<c:set var="orderList" value="${orderList}" scope="session"></c:set>    
    <a href="usercontroller?action=logout"><span style="float:right;">Logout</span></a>
    <section>
        <div id="common" style="overflow: auto">
            <h2>Process Orders</h2>

            <table class="table table-bordered" style="background-color: white; width: auto ; border-color: black; border: 2px solid; width:80%" >
                <tr align="middle"> <h3><font color="red">Order Details</font></h3></tr>
                <tr>
                    <td><b>Customer Name</b></td>
                    <td><b>Menu Item</b></td>
                    <td><b>Quantity</b></td>
                    <td><b>Process Time</b></td>
                    <td><b>Amount</b></td>
                    <td><b>Order Status</b></td>
                    <td><b></b></td>  
                </tr>
                <!--orders.OrderID, orders.OrderStatus, orders.Quantity*menu.price as Amount, "
                               + "orders.ProcessTime, orders.ResponseTime, orders.Quantity, orders.UserName, menu.MenuItem-->
            <c:forEach var="order" items="${orderList}">
                <tr>
                    <td><c:out value="${order.username}"></c:out></td>
                    <td><c:out value="${order.menuItem}"></c:out></td>
                    <td><c:out value="${order.quantity}"></c:out></td>
                    <td><c:out value= "${order.processingTime}"></c:out></td>
                    <td><c:out value= "${order.amount}"></c:out></td>
                    <td><c:out value= "${order.orderStatus}"></c:out></td>
                    <td><a href="usercontroller?action=deleteorder&param1=${order.orderId}">Process Order</a></td>
                </tr>
            </c:forEach>
        </table>
        <div style="padding-left: 250px;">


        </div>
    </div>    

    <c:import url="/footer.jsp"/>  

