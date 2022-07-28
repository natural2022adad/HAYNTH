<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item, model.Key,java.util.List" %>

<%
List<Item> ctgList = (List<Item>) session.getAttribute("ctgList");
Item mng = (Item) session.getAttribute("mng");
Key Jbk = (Key) request.getAttribute("Jbk");
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

<% for(Item c : ctgList) {%>
<h1><%= c.getName() %></h1>
<div class="item_con_wrap">
	<div class="item_con_img_wrap">
		<div class="item_con_img">
			<img src="/HAYNTH/upload/<%= c.getImage_path() %>" alt="Item_img" class="item_con_img">
			<div class="item_con_img_mini_wrap">
				<div class="item_con_img_mini">
					<img src="/HAYNTH/upload/<%= c.getImage_path() %>" alt="Item_img" class="item_con_img_img">
					<% if(c.getImage_path2() != null){%><img src="/HAYNTH/upload/<%= c.getImage_path2() %>" alt="Item_img" class="item_con_img_img2"><%} %>
					<% if(c.getImage_path3() != null){%><img src="/HAYNTH/upload/<%= c.getImage_path3() %>" alt="Item_img" class="item_con_img_img2"><%} %>
				</div>
			</div>
		</div>
	</div>
		<div class="item_con_price_wrap">
			<form action="/HAYNTH/CartServlet2" method="get" class="" style="text-align=light">
				<div class="item_con_explan_wrap">
				<p><%= c.getExplanation() %></p>
				</div>
				<div class="item_con_price">
				<p><%= c.getPrice() %>円</p>
				</div>
				<div class="item_con_quant">
				
				<% if(c.getQuantity() > 0){%>
				<p><input type="number" name="quantity" min="1" max="<%= c.getQuantity() %>" value="1"class=""></p> <!-- ここの値を飛ばしている -->
				<p>Stock:<%= c.getQuantity() %></p>
				<%}%>
				<% if(c.getQuantity() == 0){%>
				<p>Sold Out!</p>
				<%}%>
				</div>
				<div class="item_con_name">
				</div>
				<div class="item_con_littletotal">
				<p>Category：<%= c.getCategory() %></p>
				</div>
				<% if(c.getQuantity() > 0){%>
				<div class="item_ctg_confirm">
					<input type="hidden" value=<%= c.getItem_id() %> name="item_id" >
					<button type="submit" value=<%= c.getItem_id() %> name="ctg"class="in_cart" ></button >
				</div>
				<%}%>
				<div class="item_ctg_confirm">
						<button type="submit" value=<%= c.getItem_id() %> name="buy"class="buy" ></button >
				</div>
			</form>
		</div>
</div>

		
<% } %>
<% request.setAttribute("ctgList", ctgList); %>

<div class="ctg_btn">
	<form action="/HAYNTH/ItemCategoryServlet2" method="get" class="ctg_btn_form">
		<button type="submit" name="ctg" value="accessorie" class="accessorie"></button >
		<button type="submit" name="ctg" value="cosmetic" class="cosmetic"></button >
		<button type="submit" name="ctg" value="food" class="food"></button >
		<button type="submit" name="ctg" value="book" class="book"></button >
		<button type="submit" name="ctg" value="gadget" class="gadget"></button >
		<button type="submit" name="ctg" value="outdoors" class="outdoors"></button >
		<button type="submit" name="ctg" value="allitem" class="allitem"></button >
	</form>
</div>
<div class="footerarea">
</div>
</body>
</html>