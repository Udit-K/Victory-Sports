<%-- 
    Document   : login
    Created on : Nov 25, 2016, 8:45:11 PM
     Author     : Jyoti
--%>
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
                     		
                            <li class="selected">
				<a href="login.jsp">Login</a>
                            </li>
						
                            <li>	
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
<center>
    <div  id="common">
        <form name="login" action="usercontroller" method="post" class="form-inline">
            <input type="hidden" value="login" name="action" />    
            <h1>Member Login </h1> 
            <p><i><c:out value="${message}"></c:out></i></p>
         
                <div class="form-group">
                    <label for="exampleInputName2">Username:</label>
                    <input type="text" placeholder="Username" name="username" id="username" class="form-control" required>
                </div>
                <br><br>
                <div class="form-group">
                    <label for="exampleInputName2">Password:</label>
                    <input type="password" placeholder="Password" name="password" id="password" class="form-control" required>
                </div>
                <br>
                <button type="submit" value="Login" onclick="login()" class="btn btn-default">Login</button>
                <br>
                <br>
                <br>
                <a href="signup.jsp">Not a member? Get started here.</a>
                
                   <br>
                <br>
                <br>
            </form>
        </div>
    </center> 
            </section>
            </div>

<c:import url="/footer.jsp"/>             
