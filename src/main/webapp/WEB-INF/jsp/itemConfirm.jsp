<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item" %>

<%
Item mng = (Item) session.getAttribute("mng");
//String filename=(String)session.getAttribute("filename");//いらない？
//String path=(String)session.getAttribute("path");//いらない？
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
<jsp:include page="/header.jsp"/>
</div>
<h1>商品確認画面</h1>
<div class="item_con_wrap">
	<div class="item_con_img_wrap">
		<div class="item_con_img">
			<img src="/HAYNTH/upload/<%= mng.getImage_path() %>" alt="Item_img" class="item_con_img_img">
			<% if(mng.getImage_path2() != null){%><img src="/HAYNTH/upload/<%= mng.getImage_path2() %>" alt="Item_img" class="item_con_img_img"><%} %>
			<% if(mng.getImage_path3() != null){%><img src="/HAYNTH/upload/<%= mng.getImage_path3() %>" alt="Item_img" class="item_con_img_img"><%} %>
		</div>
	</div>
		<div class="item_con_price_wrap">
			<div class="item_con_explan_wrap">
			<p><%= mng.getExplanation() %></p>
			</div>
			<div class="item_con_price">
			<p><%= mng.getPrice() %>円</p>
			</div>
			<div class="item_con_quant">
			<p><%= mng.getQuantity() %></p>
			</div>
			<div class="item_con_name">
			<p><%= mng.getName() %></p>
			</div>
			<div class="item_con_littletotal">
			<p>Category：<%= mng.getCategory() %></p>
			</div>
		</div>
</div>
		<div class="item_con_btn_wrap">
			<div class="itemconfirm">
				<form action="/HAYNTH/ItemManageServlet" method="get" class="">
		    		 <button type="submit" value="修正" class="change"></button >
		  		</form>
			</div>
			<div class="itemconfirm">
				<form action="/HAYNTH/ItemRegistServlet" method="post" class="">
					<button type="submit" value="登録" class="registration"></button >
		  		</form>
			</div>
		</div>




<div class="footerarea">
</div>
</body>
</html>