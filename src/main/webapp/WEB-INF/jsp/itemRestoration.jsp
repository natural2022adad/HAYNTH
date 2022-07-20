<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item" %>

<%
Item cng = (Item) request.getAttribute("cng");
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
		<img src="/HAYNTH/upload/<%= cng.getImage_path() %>" alt="Koushin" class="koushin">
		</div>
			<div class="item_price_wrap">
				<div class="item_price">
				<p><%= cng.getName() %>；<%= cng.getPrice() %>円</p>
				</div>
				<div class="item_quant">
				<p><%= cng.getQuantity() %></p>
				</div>
				<div class="item_littletotal">
		
				<p>カテゴリー：<%= cng.getCategory() %></p>
				<p>説明文：<%= cng.getExplanation() %></p>
				<p>画像パス：<%= cng.getImage_path() %></p>
				
				</div>
				<div class="item_delete">
					<form action="" method="post" class="">
				              <button type="submit" value=""  name="削除"></button>
				    </form>
				</div>
			</div>
		</div>
		
		<div class="itemconfirm">
			<form action="/HAYNTH/ItemRegistServlet" method="post" class="">
				
		     <input type="submit" value="登録">
		  </form>
		</div>
		<%
	//スコープに保存された
	request.setAttribute("cng", cng);
	%>	
</div>


<div class="footerarea">
</div>
</body>
</html>