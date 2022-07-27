<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Cart,java.util.List,java.util.Map" %>
<%
//リクエストスコープに保存されたエラーメッセージを取得
Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
Cart totalQuant = (Cart) session.getAttribute("totalQuant");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.dropdown{
  display:none;
  margin:0;
  z-index: 100 !important;
  color:#000;
}

label,
li{
  display:block;
  padding:0;
  background:#333;
  font-family:sans-serif;
  letter-spacing:.05em;
  margin: 2vh 0 0 0;
}
li:hover,
label:hover{
  background:#330;
}
li::before,
label::before{
  content:"";
  display:block;
  position:absolute;
  right:5%;
  width:.2em;
  height:.2em;
  transform:rotate(135deg);
}
input[type="checkbox"]{
 display:none;
}
label[for="menu"]{
  display:block;
  background:#333;
}
label[for="menu"]::before{
  transform:rotate(225deg);
}
#menu:checked + .dropdown{
  display:block;
   margin:0;
}

#nav {
    list-style: none;
    display: flex;
    margin:0vh  0.5vw 0 40vw;
  }
   
  #nav li {
    width: 25vh;
    text-align: center;
    background-color: #333;
    height: 3vh;
    line-height: 3vh;
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
  #nav li a #text{
   width: 3vw;
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
   <header>
   <a class="logo" href=""></a>
    <ul id="nav">
        <li><a href="#">ABOUT</a></li><!-- リンク先未定-->
        <li>
        <label for="menu">CATEGORY</label>
			<input type="checkbox" id="menu">
			<ul class="dropdown">
			<form action="/HAYNTH/ItemCategoryServlet2" method="get" class="ctg_btn_form">
			  <li><button type="submit" name="ctg" value="accessorie" class="accessorie2">accessorie</button ></li>
			  <li><button type="submit" name="ctg" value="book" class="book2">book</button ></li>
			  <li><button type="submit" name="ctg" value="cosmetic" class="cosmetic2">cosmetic</button></li>
			  <li><button type="submit" name="ctg" value="food" class="food2">food</button ></li>
			  <li><button type="submit" name="ctg" value="gadget" class="gadget2">gadget</button ></li>
			  <li><button type="submit" name="ctg" value="outdoors" class="outdoors2">outdoors</button ></li>
			 </form>
			</ul>
        <li><a href="#">LOGIN</a></li><!-- リンク先未定-->
        <li><form action="/HAYNTH/CartServlet" method="post">
		        <img src="./css/btn_img/cart.png" >
			        	<% if(totalQuant != null){%><!--カートボタンを押したら-->
			        	<%= totalQuant.getQuantity() %>
			        	<%} %>
		      </form> 
        </li>
        <li>
	        <form action="#" method="post">
	        <input type="search" name="search" placeholder="キーワードを入力">
	        <input type="submit" name="submit" value="🔍">
      	</ul>
      </ul>
        
        </li>
        </form> 
    </ul>
</header>
</html>