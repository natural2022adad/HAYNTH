<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ItemManage" %>

<%
ItemManage mng = (ItemManage) session.getAttribute("mng");
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
<p>商品登録画面</p>
<div class="item_wrap">
	<div class="item_img_wrap">
		<div class="item_img">
		<img src="/HAYNTH/upload/<%= mng.getFilename() %>" alt="Koushin" class="koushin">
		</div>
			<div class="item_price_wrap">
				<div class="item_price">
				<p><%= mng.getItemName() %>；<%= mng.getItemPrice() %>円</p>
				</div>
				<div class="item_quant">
				<p><%= mng.getItemQuat() %></p>
				</div>
				<div class="item_littletotal">
				<p>小計<%= mng.getItemQuat()*mng.getItemPrice() %>円</p>
				<p>カテゴリー：<%= mng.getCategory() %></p>
				<p>説明文：<%= mng.getItemExplan() %></p>
				<p>画像パス：<%= mng.getFilename() %></p>
				
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