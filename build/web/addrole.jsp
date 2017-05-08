<%-- 
    Document   : manager
    Created on : Nov 15, 2016, 11:25:39 AM
     Author     : Jyoti
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>

<a href="usercontroller?action=logout"><span style="float:right;">Logout</span></a>
</section>

<div id="common">
    <div>
    <h2>Manager Page</h2>

    <center>
         <h4><font color="green">Add New Role</font></h4>
    <form action="managercontroller" method="post" class="form-inline">
       <input type="hidden" value="roleupdate" name="action"> 
       <c:if test="${msg2 != null}">
           <h3><p><c:out value="${msg2}"></c:out></p></h3>
    </c:if>
   <div class="form-group">
    <label for="exampleInputEmail1">Username:</label>
    <input type="text" placeholder="Rolename" name="rolename"  id="rolename" class="form-control" required></div>
    <br><br>
    <button type="submit" class="btn btn-default" value="Add Role">Add Role</button><br><br></form>
        </form>
<a href="manager.jsp"><span style="float:right;">Go back to Manager Page</span></a>

    </center>
    
    </div>
    
    
    
    
</div>    
<c:import url="/footer.jsp"/>  

