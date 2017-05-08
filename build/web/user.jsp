

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
        <h4><font color="green">Add New User</font></h4>
    <form action="managercontroller" method="post" class="form-inline">
        
       <input type="hidden" value="adduser" name="action"> 
       <c:if test="${msg3 != null}">
           <h3><p><c:out value="${msg3}"></c:out></p></h3>
    </c:if>
   <div class="form-group">
    <label for="exampleInputEmail1">Username:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" placeholder="username" name="username" id="username" class="form-control" required>
   </div>
    <br>
    <div class="form-group">
    <label for="exampleInputPassword1">Password:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="password" placeholder="password" name="password" class="form-control" id="password" required>
    </div>
    <br>
    <div class="form-group">
    <label for="exampleInputEmail1">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" placeholder="email" name="email" id="email" class="form-control" required>
    </div>
    <br>
    <div class="form-group">
    <label for="exampleInputEmail1">FirstName:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" placeholder="FirstName" name="fname" id="fname" class="form-control" required>
    </div>
    <br>
    <div class="form-group">
    <label for="exampleInputEmail1">LastName:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
    <input type="text" placeholder="LastName" name="lname" id="lname" class="form-control" required>
    </div>
    <br>
    <div class="form-group">
    <label>Role:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
     <select name="role" id="role" class="form-control">
          <option></option>

    <c:forEach var="list" items="${roleList}">
         <option value="${list.getRole()}">${list.getRole()}</option></c:forEach>
  
    </select>
    </div><br><br>
    <button type="submit" class="btn btn-default" value="Add User">Add User</button><br><br></form>
   
        </form>
<a href="manager.jsp"><span style="float:right;">Go back to Manager Page</span></a>
    </div>
    </div>
    
</div>    
<c:import url="/footer.jsp"/>  

