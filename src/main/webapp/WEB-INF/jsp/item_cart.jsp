<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item,model.Key,java.util.List" %>
<%
//リクエストスコープに保存されたエラーメッセージを取得
List<Item> ctgList = (List<Item>) request.getAttribute("ctgList");
Key Jbk = (Key) request.getAttribute("Jbk");
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
<jsp:include page="/header.jsp" />
<h1>ITEM_ID:<%= Jbk.getNumKey() %></h1>
<% for(Item c : ctgList) {%>
<div class="item_wrap">
	<div class="item_img_wrap">
		<div class="item_img">
		<img src="/HAYNTH/upload/<%= c.getImage_path() %>" alt="Koushin" class="koushin">
		</div>
			<div class="item_price_wrap">
				<div class="item_price">
				<p><%= c.getName() %>；<%= c.getPrice() %>円</p>
				</div>
				<div class="item_quant">
				<p><%= c.getQuantity() %></p>
				</div>
				<div class="item_littletotal">
				
				<p>カテゴリー：<%= c.getCategory() %></p>
				<p>説明文：<%= c.getExplanation() %></p>
				<p>商品ID：<%= c.getItem_id() %></p>
				</div>
				<div class="item_delete">
					<form action="" method="post" class="">
				              <button type="submit" value="修正"  name="削除"></button>
				    </form>
				</div>
			</div>
		</div>
		<div class="item_alltotal">
	
		</div>
		<div class="itemconfirm">
			<form action="/HAYNTH/ItemRegistServlet" method="post" class="">
				
		     <input type="submit" value="登録">
		  </form>
		</div>
			
</div>
<% } %>
<div class="footerarea">
</div>
</body>
</html>