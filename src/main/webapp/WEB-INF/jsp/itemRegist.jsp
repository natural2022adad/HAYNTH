<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item" %>

<%
Item mng = (Item) session.getAttribute("mng");
String filename=(String)session.getAttribute("filename");
String path=(String)session.getAttribute("path");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="./css/t_style.css">
<title>HAYNTH</title>
</head>
<body>
<div class="headerearea">
</div>

<div class="item_regist_wrap">
	
		
		<h1>商品登録完了</h1>	
	
		<div class="kakunin">
			<form action="/HAYNTH/ItemManegeServlet" method="get" class="">
		        <button type="submit"  value="新規登録画面へ" name="新規登録"></button>
		    </form>
		</div>
			
</div>


<div class="footerarea">
</div>
</body>
</html>