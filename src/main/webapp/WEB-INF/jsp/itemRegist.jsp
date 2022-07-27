<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item" %>

<%
//Item mng = (Item) session.getAttribute("mng");
//String filename=(String)session.getAttribute("filename");
//String path=(String)session.getAttribute("path");
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
			<form action="/HAYNTH/ItemManageServlet" method="get" >
		        <button type="submit"  value="" name=""class="btn_new_item_add"></button>
		    </form>
		</div>
			<%
			session.removeAttribute("mng"); 
			
			%>
</div>


<div class="footerarea">
</div>
</body>
</html>