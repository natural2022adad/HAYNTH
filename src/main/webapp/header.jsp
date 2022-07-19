<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</style>
</head>
   <header>
   <a class="logo" href=""></a>
    <ul id="nav">
        <li><a href="#">ABOUT</a></li><!-- リンク先未定-->
        <li><a href="#">CATEGORY</a></li><!-- リンク先未定-->
        <li><a href="#">LOGIN</a></li><!-- リンク先未定-->
        <li><a href="#">MYPAGE</a></li><!-- リンク先未定-->
        <li>   <form action="#" method="post"><!-- リンク先未定-->
        <input type="search" name="search" placeholder="キーワードを入力"><input type="submit" name="submit" value="🔍"></li>
        </form> 
    </ul>
</header>
</html>