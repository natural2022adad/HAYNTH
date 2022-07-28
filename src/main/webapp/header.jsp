<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Cart,java.util.List,java.util.Map" %>
<%
//リクエストスコープに保存された
Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
Cart totalQuant = (Cart) session.getAttribute("totalQuant");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#nav {
    list-style: none;
    display: flex;
    margin:0vh  0.5vw 0 40vw;
  }
   
  #nav li {
    width: 25vh;
    text-align: center;
    background-color: #333;
    height: 5vh;
    line-height: 5vh;
    margin: 2vh 0 0 0;
    
  }
   
  #nav li a {
    text-decoration: none;
    color: #fff;
    font-weight: ;
    
  }
  #nav li img {
   width: 4vw;
    
  }
  #nav li a #text {
   width: 5vw;
  }
  
  .keyword {
  width: 18vw;
  height: 30vh;
  background-color: #333;
  position:absolute;
   margin:0;
   z-index: 100;
  }
  .input [type="search"] {
  
  }
  .keyword:focus{
  width: 18vw;
  height: 30vh;
  background-color: #333;
  position:absolute;
   margin:0;
   z-index: 100;
  }
 
</style>
</head>

   <a class="logo" href=""></a>
    <nav>
 	<form action="/HAYNTH/CartServlet2" method="post">
	     <ul id="nav">
		      <li><a href="/HAYNTH/CartServlet">ABOUT</a></li>
		      <li><a href="#">CATEGORY</a></li>
		      <li><a href="#">LOGIN</a></li>
		      <li><a href="#">
		      
		      		<button type="submit" value="<%= cart.size() %>" name="look_cart" class="look_cart" ></button>
				        <img src="./css/btn_img/cart.png" >
					        	<% if(totalQuant != null){%><!--カートボタンを押したら-->
					        	<%= totalQuant.getQuantity() %>
					        	<%} %>
				 </a></li>
	    </ul> 
     </form>
</nav>

</html>

