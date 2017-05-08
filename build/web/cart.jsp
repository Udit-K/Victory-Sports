<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>

<a href="index.jsp"><span style="float:right;">Main Page</span></a>
</section>

<div id="common" style="overflow: auto">
    <center>
        <h1><font color="green">Your cart</font></h1><br><br>

        <table class="table table-bordered" style="background-color: white; width: auto ; border-color: black; border: 2px solid; width:80%" >
            <tr>
                <td><b>Quantity</b></td>
                <td><b>Description</b></td>
                <td><b>Price</b></td>
                <td><b>Amount</b></td>
                <td>  </td>
            </tr>

            <c:forEach var="order" items="${order}">
                <tr>
                    <c:forEach var="menu" items="${order.menuList}">
                    <form method="post" action="ordercontroller?action=updateItem">  
                        <td><input type="hidden" name="item" value="${menu.getMenuNumber()}">
                            <input type="text" name="quantity1" value="${order.getQuantity()}">&nbsp;
                            <button>Update</button>
                    </form>
                    </td>

                    <td><c:out value="${menu.getMenuItem()}"></c:out></td>
                    <td><c:out value="${menu.getPrice()}"></c:out></td>
                    <td><c:out value="${menu.getPrice()*order.getQuantity()}"></c:out></td>

                        <td>
                            <form method="post" action="ordercontroller?action=deleteItem">
                                <input type="hidden" name="itemdelete" value="${menu.getMenuNumber()}"> 
                            <button>Remove Item</button></form>
                    </td>
                </c:forEach>
                </tr>
            </c:forEach>
        </table>
        <br></center>
    <div style="padding-left: 90px;">    
        <p><b>To change the quantity</b>, enter the new quantity and click on the Update button.</p>
        <table>
            <tr>
                <td style="padding-right: 100px ;align:center">
                    <form method="post" action="ordercontroller?action=shopping">
                        <button> Continue Shopping</button><br><br>
                    </form></td>
                <td style="padding-right: 100px; align: center">
                    <form method="post" action="ordercontroller?action=checkout">
                        <button>Place Order</button>
                    </form></td>
            </tr>
        </table>
    </div>
</div> 
<c:import url="/footer.jsp"/>  

