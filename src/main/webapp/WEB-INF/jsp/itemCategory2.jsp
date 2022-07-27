<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item, model.Key,model.Cart, javax.servlet.http.HttpSession,java.util.List,java.util.Map" %>
<%
//リクエストスコープに保存されたエラーメッセージを取得

Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
List<Item> ctgList = (List<Item>) session.getAttribute("ctgList");
Key Jbk = (Key) request.getAttribute("Jbk");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/t_style.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>HAYNTH</title>
</head>
<body>
<header>
<jsp:include page="/header2.jsp" />
</header>
<main>
<h1><%= Jbk.getKey() %></h1>
<div class="wrap">
<div class="item_ctg_wrap">
	<% for(Item c : ctgList) {%>
	<div class="item__ctg_img_wrap">
		<div class="item_ctg_img">
			<img src="/HAYNTH/upload/<%= c.getImage_path() %>" alt="item_img" class="img_ctg">
		</div>
			<div class="item_ctg_name_wrap">
				<div class="item_ctg_price">
					<p><%= c.getName() %></p>
					<p>¥<%= c.getPrice() %></p>
				</div>
				<% if(c.getQuantity() > 0){%>
				<div class="item_ctg_quant">
					<p><%= c.getQuantity() %> pic</p>
				</div>
				<%}%>
				<% if(c.getQuantity() == 0){%>
				<div class="item_ctg_quant">
					<p>Sold Out!</p>
				</div>
				<%}%>
				<div class="item_ctg_explan">
					<p><%= c.getCategory() %></p>
					<p><%= c.getExplanation() %></p>
				</div>
				<div class="item_ctg_id">
					<p>ITEM_ID：<%= c.getItem_id() %></p>
				</div>
				
				<div class="item_ctg_confirm">
					<form action="/HAYNTH/ItemCategoryServlet2" method="get" class="">
					<button type="submit" value="<%= c.getItem_id() %>" name="detail"class="detail"></button >
					</form>
				</div>
			</div>
		</div>
		
	<% } %>
</div>

<% 
//request.setAttribute("Jbk", Jbk);
System.out.println("Jbk"+Jbk);

//request.setAttribute("ctgList", ctgList); 

%>

<script>
	var btn = document.getElementById('btn');
	btn.addEventListener('click', function() {
	    var result = window.confirm('商品をDeleteしますか？');
	    
	    if( result ) {
	        console.log('OKがクリックされました');
	        return true;
	    }
	    else {
	        console.log('キャンセルがクリックされました');
	        return false;
	    }
	})
</script>

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
</div>

</main>
<footer>
</footer>
</body>
</html>