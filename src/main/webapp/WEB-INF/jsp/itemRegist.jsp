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

<div class="item_wrap">
	<div class="item_img_wrap">
		<div class="item_img">
		<img src="<%= path %>g" alt="Koushin" class="koushin">
		</div>
			<h1>商品登録完了</h1>
				<div class="item_delete">
					<form action="" method="post" class="">
				              <button type="submit" value="CONFIRM"  name="CONFIRM"></button>
				    </form>
				</div>
			
		</div>
		<div class="item_alltotal">
		<p>合計2000円</p>
		</div>
		<div class="kakunin">
			<form action="/" method="post" class="">
				
		        <button type="submit" value="確認画面" name="確認画面"></button>
		    </form>
		</div>
			
</div>


<div class="footerarea">
</div>
</body>
</html>