<%-- 
    Document   : adduserrole
    Created on : Nov 29, 2016, 1:59:34 AM
     Author     : Jyoti
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>

<a href="usercontroller?action=logout"><span style="float:right;">Logout</span></a>
</section>

<div id="common" style="overflow-x: auto">
    <div>
        <h2>Manager Page</h2>
        <h4><font color="green">Add Role</font></h4>
        <table class="table table-bordered" style="background-color: white;">
            <tr>
                <th>UserName</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email:</th>
                <th>Role</th>
                <th></th>
            </tr>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td><c:out value="${user.getUserName()}"></c:out></td>
                <input type="hidden" name="username" value="${user.getUserName()}">
                <td><c:out value="${user.getFirstName()}"></c:out></td>
                <td><c:out value="${user.getLastName()}"></c:out></td>
                <td><c:out value="${user.getEmail()}"></c:out></td> 
            </tr>
        <form method="post" class="form-inline" action="managercontroller?action=addrole&username=${user.getUserName()}">
                    <td>
                    <option></option>
                    <c:forEach var="list" items="${roleList}" >
                        <option value="${list.getRole()}"><c:out value="${list.getRole()}"></c:out></option></c:forEach>
                            </td>
                            <td>
                                <input type="submit" value="Add Role">
                        </form>
                        </td>
            </c:forEach>
        </table>
    </div>
    <a href="manager.jsp"><span style="float:right;">Go back to Manager Page</span></a>
</div>    
<c:import url="/footer.jsp"/>  

