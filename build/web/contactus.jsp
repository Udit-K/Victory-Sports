
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header.jsp"/>
<section>
<center><p><i><b><c:out value="${message}"> </c:out></b></i></p></center>
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
						
                            <li >	
                                <a href="signup.jsp">Register</a>	
                            </li>
				<li>
				<a href="about.jsp">About</a>
                            </li>		
                            <li class="selected">
                                <a href="contactus.jsp">Contact Us</a>
                            </li>
			</ul>
		</div>
            </div>
                <div id="contents">
                    <div class="box">
					<div>
						<div class="body1">
                                                    <center>
                                                        <h1>Drop by at our store at</h1>
                                                        <p> <address>
                                                            101 North Tryon Street Charlotte NC
                                                        </address></p>
                                                        <p> Telephone : +1-801-VIC-000 </p>
                                                        <p> Login to contact support by e-mail </p>
                                                       
                                                        
                                                    </center>
							
							<div class="ads">
								
							</div>
							
						</div>
					</div>
				</div>
			</div>
    
    

</section>
<c:import url="/footer.jsp"/> 


