<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item, servlet.ItemCategoryServlet,java.util.List" %>
<%
//リクエストスコープに保存されたエラーメッセージを取得
List<Item> ctgList = (List<Item>) request.getAttribute("ctgList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/t_style.css">

<title>HAYNTH</title>
</head>
<body>
<div class="headerearea">
<form action="/HAYNTH/ItemCategoryServlet" method="get" >
<input type="submit" name="ctg" value="fashion">
<input type="submit" name="ctg" value="cosmetic">
<input type="submit" name="ctg" value="food">
<input type="submit" name="ctg" value="book">
<input type="submit" name="ctg" value="gatget">
<input type="submit" name="ctg" value="outdoors">
<input type="submit" name="ctg" value="allitem">
</form>
</div>
<h1><%= ItemCategoryServlet.key %></h1>
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
				<div class="item_ctg_quant">
					<p><%= c.getQuantity() %> pic</p>
				</div>
				<div class="item_ctg_explan">
					<p><%= c.getCategory() %></p>
					<p><%= c.getExplanation() %></p>
				</div>
				<div class="item_ctg_id">
					<p>ITEM_ID：<%= c.getItem_id() %></p>
				</div>
				<div class="item_ctg_delete">
					<form action="/HAYNTH/ItemCategoryServlet" method="get" >
				              <input type="submit" value="<%= c.getItem_id() %>"  name="delete" id="btn">
				    </form>
				</div>
				<div class="item_ctg_confirm">
					<form action="/HAYNTH/ItemCategoryServlet" method="get" class="">
						<input type="submit" value="<%= c.getItem_id() %>" name="修正">
					</form>
				</div>
			</div>
		</div>
		
	<% } %>
</div>
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
<div class="footerarea">
</div>
</body>
</html>