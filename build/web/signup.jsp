
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>
<div id="header">
		<div id="logo">
                    <a href="main.jsp">
                        <h1 id="brandLogo">Victory Sports</h1>
                    </a>
                 
                </div>
                    <div id="navigation">
			<ul>
                            <li >
				<a href="main.jsp">Home</a>
                            </li>
                     		
                            <li >
				<a href="login.jsp">Login</a>
                            </li>
						
                            <li class="selected">	
                                <a href="signup.jsp">Register</a>	
                            </li>
				<li>
				<a href="about.jsp">About</a>
                            </li>		
                            <li>
                                <a href="contactus.jsp">Contact Us</a>
                            </li>
			</ul>
		</div>
            </div>
<section>

<div id="common">
    <div>
       <center>
            <h3><font color="green">Let's get you started with Victory Sports</font></h3>
            <form action="usercontroller" method="post" class="form-inline">

                <input type="hidden" value="signup" name="action"> 
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
                    <label for="exampleInputEmail1">LastName:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <input type="text" placeholder="LastName" name="lname" id="lname" class="form-control" required>
                </div><br>

                <div class="form-group">
                     <label for="exampleInputEmail1">Role:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                     <select name="role">
                    <option value="Customer">Customer</option>
                    <option value="Manager">Manager</option>
                    <option value="Designer">Vendor</option>
                </select>
                </div>


                 <!--   <div class="form-group">
                        <label for="exampleInputEmail1">Phone Number:   </label>
                        <input type="number" placeholder="Phone Number" name="number" id="number" class="form-control" required>
                    </div> <br>

                    <div class="form-group">
                        <label for="exampleInput">Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <input type="text" placeholder="Address" name="address" id="address" class="form-control" required>
                    </div> <br>
                    <div class="form-group">
                        <label for="exampleInputEmail1">City:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <input type="text" placeholder="City" name="city" id="city" class="form-control" required>
                    </div> <br>
                    <div class="form-group">
                        <label for="exampleInputEmail1">State:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <input type="text" placeholder="State" name="state" id="state" class="form-control" required>
                    </div> <br>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Zipcode:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </label>
                        <input type="number" placeholder="Zipcode" name="zipcode" id="zipcode" class="form-control" required>
                    </div> 

                    <br><br> -->
                 <br>
                    <button type="submit" class="btn btn-default" value="Sign Up">Sign Up</button><br><br>
                    <br>
                    <br>
                    </form>
                </div>
                </div>

                
</section>
                <c:import url="/footer.jsp"/>  


