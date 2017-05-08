

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
				<a href="index.jsp">Home</a>
                            </li>
                     				
                            <li class="selected">
                                <a href="contact.jsp">Contact Us</a>
                            </li>
			</ul>
		</div>
            </div>
</section>

<div id="common">
    <div>
        
        <center><div style="width:500px; border: 4px solid;">
                <form action="emaillistservlet" method="post" class="form-inline">
                    <input type="hidden" value="addcontact" name="action"> 
                    <br>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Username:</label>
                        <input type="text" placeholder="Username" name="nameuser"  id="nameuser" class="form-control" required></div>
                    <br><br>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <input type="text" placeholder="Email" name="email"  id="email" class="form-control" required></div>
                    <br><br>
                    <div class="form-group">
                        <label for="comment">Message:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <textarea class="form-control" rows="5" cols="25" id="message" name="message"></textarea>
                    </div><br><br>
                    <button type="submit" class="btn btn-default">Submit</button><br><br></form>
                </form>
            </div>
        </center>
    </div>
</div>    
<c:import url="/footer.jsp"/>  

