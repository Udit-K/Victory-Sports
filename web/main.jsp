<%-- 
    Document   : main
    Created on : 1 May, 2017, 1:33:46 PM
    Author     : babys

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>
<section>
<center><p><i><b><c:out value="${message}"> </c:out></b></i></p></center>
<div  id="common">
        <div id="background">
            <div id="page">
                <div id="navigation">
                        <ul>
                            <li class="selected">
                                <a href="main.jsp">Home</a>
                            </li>
                            <li>
                                <a href="about.jsp">About</a>
                            </li>
                            <li>
                                <a href="login.jsp">Login</a>
                            </li>

                            <li>
                                <a href="signup.jsp">Sign Up</a>
                            </li>
                            <li>
                                <a href="contactus.jsp">Contact</a>
                            </li>
                        </ul>
                    </div>
                
                <div id="contents">
                    <div id="adbox">
                        <img src="images/homeimage.jpg" alt="Img">
                        
                    </div>
                </div>
            </div>
        </div>
</div>

</section>

<c:import url="/footer.jsp"/> 
--%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Victory Sports - One place for your all sporting needs</title>
	<link rel="stylesheet" href="styles/style.css" type="text/css">
</head><
<body>
    <div id="background">
        <div id="page">
            <div id="header">
                
		<div id="logo">
                    
                    <a href="main.jsp">
                        <h1 id="brandLogo">Victory Sports</h1>
                    </a>
                    
                  
 			
                  
                </div>
                    <div id="navigation">
			<ul>
                            <li class="selected">
				<a href="main.jsp">Home</a>
                            </li>
                     		
                            <li>
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
            
	<div id="contents">
            
		<img src="images/sports_banner.png" alt="Img">
                	  <center>
                    <img id ="inspire" src="images/inspire.png" alt ="sports quote"/>
                </center>
                 <div id="footer">
                     
                     
                    <ul class="navigation">
                        <li class="selected">
				<a href="main.jsp">Home</a>
                            </li>
                     		
                            <li>
				<a href="login.jsp">Login</a>
                            </li>
						
                            <li>	
                                <a href="registration.jsp">Register</a>	
                            </li>
				<li>
				<a href="about.html">About</a>
                            </li>		
                            <li>
                                <a href="contact.html">Contact Us</a>
                            </li>
                    </ul>
                  
		<p>
                    
                    <br>    
			© 2017 Victory Sports. All Rights Reserved
                </p>
              
		</div>
	
        </div>
        </div></div>
</body>
</html>