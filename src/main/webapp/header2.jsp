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
/**/
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
/**/
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
*, *:before, *:after {
	padding: 0;
	margin: 0;
	/*box-sizing: border-box;*/
}
ol, ul {
	list-style: none;
}
a {
	text-decoration: none;
	color: inherit;
}
.cp_cont {
	height: 65vh;
}
.cp_offcm01 {
	position: absolute;
	top: 20px;
	right: 20px;
	display: inline-block;
}
/* menu */
.cp_offcm01 .cp_menu {
	position: fixed;
	top: 0;
	right: -100vw;
	width: 250px;
	height: 100%;
	cursor: pointer;
	-webkit-transition: 0.83s transform;
	        transition: 0.83s transform;
	-webkit-transition-timing-function: cubic-bezier(.38,.52,.23,.99);
	        transition-timing-function: cubic-bezier(.38,.52,.23,.99);
	background-color: #607D8B;
	opacity: 0.9;
}
.cp_offcm01 .cp_menu ul {
	margin: 0;
	padding: 0;
}
.cp_offcm01 .cp_menu li {
	list-style: none;
}
.cp_offcm01 .cp_menu li a {
	display: block;
	padding: 20px;
	text-decoration: none;
	color: #ffffff;
	/*border-bottom: 1px solid #ffffff;*/
}

.cp_offcm01 #cp_toggle01 {
	position: absolute;
	display: none;
	opacity: 0;
}
.cp_offcm01 #cp_toggle01:checked ~ .cp_menu {
	-webkit-transform: translateX(-100vw);
	        transform: translateX(-100vw);
}
/* menu toggle */
.cp_offcm01 #cp_toggle01 ~ label {
	display: block;
	padding: 0.5em;
	cursor: pointer;
	-webkit-transition: 0.5s transform;
	        transition: 0.5s transform;
	-webkit-transition-timing-function: cubic-bezier(.61,-0.38,.37,1.27);
	        transition-timing-function: cubic-bezier(.61,-0.38,.37,1.27);
	text-align: center;
	color: #333333;
}
.cp_offcm01 #cp_toggle01:checked ~ label {
	-webkit-transform: translateX(-250px);
	        transform: translateX(-250px);
}
.cp_offcm01 #cp_toggle01 ~ label::before {
	font-family: 'FontAwesome';
	content: '\f0c9';
	font-size: 2em
}
.cp_offcm01 #cp_toggle01:checked ~ label::before {
	content: '\f00d';
}
/* contents */
.cp_contents {
	color: #333333;
	text-align: center;
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
			        	<% if(totalQuant != null){%>
			        		<% if(totalQuant.getQuantity() > 0){%><!--カートボタンを押したら-->
			        			<%= totalQuant.getQuantity() %>
			        		<%} %>
			        	<%} %>
		      </form> 
        </li>
        <li>
        <div class="cp_cont">
			<div class="cp_offcm01">
				
        		<input type="checkbox" id="cp_toggle01">
				<label for="cp_toggle01"><span><img src="./css/btn_img/mushi.png" ></span></label>
				<div class="cp_menu">
					<ul>
					<li>
						<form action="#" method="post">
				        <input type="search" name="search" placeholder="キーワードを入力">
				        <input type="submit" name="submit" value="🔍">
		        		</form> 
	        		</li>
					<li><a href="#">menu2</a></li>
					<li><a href="#">menu3</a></li>
					<li><a href="#">menu4</a></li>
					<li><a href="#">menu5</a></li>
					</ul>
				</div>
			</div>
			</div>
		</li>
    </ul>
</header>
</html>