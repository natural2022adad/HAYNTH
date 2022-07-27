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
    margin: -2vh 0 0 0;
    
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
  $nav_bg: #860255; // purple
$nav_bg2: #EF4B3F ; // Orange
$search_bg: rgba(0,0,0,0.1) ; // Search box
$search_bg_hover: rgba(0,0,0,0.3) ; // Search box

body{
  background: #2E2F40;
  font-family: 'Montserrat', sans-serif;
}

nav {
 max-width: 1000px;
 height: 0px;
 border-bottom: 100px solid $nav_bg;
 border-left: 40px solid transparent;
 position: relative;
 margin: 0 auto;
 box-shadow: 20px 17px 27px rgba(0, 0, 0, 0.15);
  
  &::before{
    content: '';
    margin-top: 10%;
    display: block;
  }
 
  .inner{
    width: 100%;
    height: 100px;
    position: absolute;
    right: 0;
    overflow: hidden;
    background: $nav_bg;
    /* Webkit (Safari/Chrome 10) */ 
    background-image: -webkit-gradient(linear, left top, right top, color-stop(0, $nav_bg), color-stop(100, $nav_bg2));
    /* IE10+ */ 
    background-image: -ms-linear-gradient(left, $nav_bg 0%, $nav_bg2 100%);
    /* Mozilla Firefox */ 
    background-image: -moz-linear-gradient(left, $nav_bg 0%, $nav_bg2 100%);
    /* Opera */ 
    background-image: -o-linear-gradient(left, $nav_bg 0%, $nav_bg2 100%);
    /* Webkit (Chrome 11+) */ 
    background-image: -webkit-linear-gradient(left, $nav_bg 0%, $nav_bg2 100%);
    /* W3C Markup */ 
    background-image: linear-gradient(to right, $nav_bg 0%, $nav_bg2 100%);
  }
  
  .active{
    top: 80px!important;
    position: relative;
    transition: all .3s;
  }
  
  ul{
    float: right;
    list-style-type: none;
    line-height: 6.2;
    padding: 0;
    margin: 0;
    transition: all .3s;
    position: relative;
    top: 0;
  }
  
  li{
    display: inline-block;
    margin: 0;
  
    &::before{
      content: ' / ';
      margin: 0 10px;
      color: rgba(255, 255, 255,0.5);
    }
    
    &:first-child{
      &::before{
        display: none;
      }
    }
  }
    
  .search{
    width: 80px;
    height: 0px;
    float: right;
    color: #fff;
    font-size: 18px;
    border-bottom: 100px solid $search_bg;
    border-left: 40px solid transparent;
    position: relative;
    transition: .3s;
    
    &::before{
      content: '';
    }
    
    &:hover{
      border-bottom: 100px solid $search_bg_hover;
    }
  }
  
  .fa-search{
    position: relative;
    left: 25px;
    top: 38px;
  }
  
  input[type=search]{
      background: transparent;
    border: none;
    border-bottom: 2px solid #fff;
    -webkit-appearance: none;
  }
  input.search_box, {
    position: absolute;
    font-size: 16px;
    color: #fff;
    line-height: 4;
    top: -100px;
    width: 320px;
    right: 130px;
    transition: all .3s;
  }  
  .search_box_active{
    top: 15px!important;
    transition: all .3s;
  }
  
  input:focus{
    outline: none;
  }
  
  input::-webkit-input-placeholder {
    color: #fff;
  }
  
  input[type="search"]::-webkit-search-cancel-button {
    -webkit-appearance: none;
    height: 1px;
    width: 15px;
    background: transparent;
    border-radius: 50%;
    
    &::before{
    content: '+';
    color: #fff;
    font-weight: bold;
    -webkit-transform: rotate(45deg);
    font-size: 21px;
    position: absolute;
    top: -10px;
    }
    
  }
  
  a{
    color: #fff;
    text-decoration: none;
  }
 
}
</style>
</head>
   <header>
   <a class="logo" href=""></a>
    <!-- <ul id="nav">
        <li><a href="#">ABOUT</a></li>
        <li><a href="#">CATEGORY</a></li>
        <li><a href="#">LOGIN</a></li>
        <li><form action="/HAYNTH/CartServlet" method="post">
		        <img src="./css/btn_img/cart.png" >
			        	<% if(totalQuant != null){%>
			        	<%= totalQuant.getQuantity() %>
			        	<%} %>
		      </form> 
        </li>
        <li>
        <div class="keyword">
	        <form action="#" method="post">
	        <input type="search" name="search" placeholder="キーワードを入力">
	        <input type="submit" name="submit" value="🔍">
        </div>
        </li>
        </form> 
    </ul>-->
    <nav>
  <div class="inner">
    <input class="search_box" type=search placeholder="Search...">
    <div class="search"><i class="fa fa-search"></i></div>   
     <ul id="nav">
      <li><a href="#">ABOUT</a></li>
      <li><a href="#">CATEGORY</a></li>
      <li><a href="#">LOGIN</a></li>
      <li><a href="#"><form action="/HAYNTH/CartServlet" method="post">
		        <img src="./css/btn_img/cart.png" >
			        	<% if(totalQuant != null){%><!--カートボタンを押したら-->
			        	<%= totalQuant.getQuantity() %>
			        	<%} %>
		      </form> </a></li>
    </ul> 
  </div>
</nav>
</header>
</html>

<script>
//Search Toggle //
$( ".search" ).click(function() {
 $( "ul" ).toggleClass( "active" );
 $( ".search_box" ).toggleClass( "search_box_active" );
});
</script>