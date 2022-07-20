<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item" %>

<%
Item mng = (Item) session.getAttribute("mng");
String filename=(String)session.getAttribute("filename");//いらない？
String path=(String)session.getAttribute("path");//いらない？
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
<p>商品登録画面</p>
<div class="item_wrap">
	<div class="item_img_wrap">
		<div class="item_img">
		<img src="/HAYNTH/upload/<%= mng.getName() %>" alt="Koushin" class="koushin">
		</div>
			<div class="item_price_wrap">
				<div class="item_price">
				<p><%= mng.getName() %>；<%= mng.getPrice() %>円</p>
				</div>
				<div class="item_quant">
				<p><%= mng.getQuantity() %></p>
				</div>
				<div class="item_littletotal">
				<p>小計<%= mng.getQuantity()*mng.getPrice() %>円</p>
				<p>カテゴリー：<%= mng.getCategory() %></p>
				<p>説明文：<%= mng.getExplanation() %></p>
				<p>画像パス：<%= mng.getImage_path() %></p>
				
				</div>
				<div class="item_delete">
					<form action="" method="post" class="">
				              <button type="submit" value=""  name="削除"></button>
				    </form>
				</div>
			</div>
		</div>
		<div class="item_alltotal">
		<p>合計2000円</p>
		</div>
		<div class="itemconfirm">
			<form action="/HAYNTH/ItemRegistServlet" method="post" class="">
				
		     <input type="submit" value="登録">
		  </form>
		</div>
			
</div>


<div class="footerarea">
</div>
</body>
</html>