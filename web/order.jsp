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
<div id="block">
    <div style="padding-left: 0px;">
        <nav id="menu">

            <ul class="parent-menu">
                <table border="10">
                    <tr>    
                    <td><li><img src="images/sport_tee.png"><a href="ordercontroller?param1=1&action=additem">Sports Tshirt </a></li></td>
                    <td><li><img src="images/sport_shorts.png"><a href="ordercontroller?param1=2&action=additem"></a>Sport Shorts</li></td>
                    <td><li><img src="images/sport_socks.png"><a href="ordercontroller?param1=3&action=additem">Comfy sport socks</a></li></td>
                    <td><li><img src="images/sport_hoodie.png"><a href="ordercontroller?param1=4&action=additem">Warm Hoodie</a></li></td>
                    
                    </tr> 
                    <tr>
                    <td><li><img src="images/tennis_ball.png"><a href="ordercontroller?param1=7&action=additem">Set of 4 Tennis Balls</a></li></td>
                    <td><li><img src="images/football.png"><a href="ordercontroller?param1=8&action=additem">Football Standard Size</a></li></td>
                    <td><li><img src="images/basketball.png"><a href="ordercontroller?param1=9&action=additem">Basketball</a></li></td>
                    <td><li><img src="images/soccerball.png"><a href="ordercontroller?param1=10&action=additem">Soccer ball</a></li></td>
                    <!--<td><li><img src="images/VegPizza.jpg"><a href="ordercontroller?param1=11&action=additem">Veg Pizza</a></li></td>
                     <td><li><img src="images/NonVegPizza.jpg"><a href="ordercontroller?param1=12&action=additem">Non Veg Pizza</a></li></td> -->
                    </tr>
                    <tr>
                    <td><li><img src="images/cap.png"><a href="ordercontroller?param1=13&action=additem">Fit Cap</a></li></td>
                    <td><li><img src="images/helmet.png"><a href="ordercontroller?param1=14&action=additem">Saftey Helmet</a></li></td>
                    <td><li><img src="images/shoes.png"><a href="ordercontroller?param1=15&action=additem">Running Shoes</a></li></td>
                    <td><li><img src="images/gaurdkit.png"><a href="ordercontroller?param1=16&action=additem">Safety Kit</a></li></td>
                    <!--<td><li><img src="images/Expresso.PNG"><a href="ordercontroller?param1=17&action=additem">Expresso</a></li></td>
                     <td><li><img src="images/ChocolateCake.PNG"><a href="ordercontroller?param1=18&action=additem">Chocolate Cake Pop</a></li></td> -->                 
                    </tr>

                </table>
            </ul>
        </nav>
    </div>
</div>    
</section>
<br><br><br>
<c:import url="/footer.jsp"/>  

