

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
                    		
                            <li >
                                <a href="contact.jsp">Email Us</a>
                            </li>
                            <li >	
                                <a href="usercontroller?action=logout"><span style="float:right;">Logout</span></a>	
                            </li>
			</ul>
		</div>
            </div>
<section>
<center><p><i><b><c:out value="${message}"> </c:out></b></i></p></center>

    <div  id="common">
        <div class="container text-center">
            <center>
                <h3>Sports is what keeps your soul alive </h3>
            <p><em>We have different options for you</em></p>
                
            </center>
            
            <br>
            
            <div >
                <div class="col-sm-4">
                    <p><strong>Sports Apparel</strong></p><br>
                    <img id="mainpic" src="images/apparel_main.png" alt="apparel">
                </div>
                <div class="col-sm-4">
                    <p><strong>Sports Equipments</strong></p><br>
                    <img id="mainpic" src="images/equipment_main.png" alt="equipments">
                </div>
                <div class="col-sm-4">
                    <p><strong>Sports Accessories </strong></p><br>
                    <img  id="mainpic"src="images/access_main.png" alt="accessories">
                </div>
            </div>
        </div>
        <section id="orderM">
             <center>
                 <br>
                 <br>
                 <br>
            <a href="ordercontroller?action=order">Order</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            
             </center>
            <a href="contact.jsp">Email Us!</a>
        </section>
       
    </div>
</section>
<c:import url="/footer.jsp"/> 