<%-- 
    Document   : manager
    Created on : Nov 27, 2016, 11:14:39 PM
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
    <p><c:out value="Message Sent"></c:out></p> 
    </div>    
<c:import url="/footer.jsp"/>  

