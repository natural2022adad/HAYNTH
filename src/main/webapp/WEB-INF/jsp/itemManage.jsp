<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item, java.util.List" %>
<%
//Delete前のデータを格納している場合
List<Item> ctgList = (List<Item>) request.getAttribute("ctgList");
System.out.println("ctgList" + ctgList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="./css/t_style.css">
<script>

function OnFileSelect( inputElement )
{
	var fileList = inputElement.files;// ファイルリストを取得
	var fileCount = fileList.length;// ファイルの数を取得

	var loadCompleteCount = 0;
	var imageList = "";

	for ( var i = 0; i < fileCount; i++ ) {  // 選択されたファイルの数だけ処理する
		var fileReader = new FileReader();   // FileReaderを生成
		var file = fileList[ i ];            // ファイルを取得
		
		fileReader.onload = function() {         							// 読み込み完了時の処理を追加
			imageList += "<li><img src=\"" + this.result + "\" /></li>\r\n";// <li>,<img>タグの生成

			if ( ++loadCompleteCount == fileCount ) {						 // 選択されたファイルすべの処理が完了したら、<ul>タグに流し込む
				document.getElementById( "ID001" ).innerHTML = imageList;    // <ul>タグに<li>,<img>を流し込む
			}
		};
		fileReader.readAsDataURL( file );// ファイルの読み込み(Data URI Schemeの取得)
	}
}
</script>
<title>HAYNTH</title>
</head>
<body>
<div class="headerearea">
<jsp:include page="/header.jsp" />
<% if(ctgList != null){%>
<% for(Item c : ctgList) {%>
<p>ID:<%= c.getItem_id() %>の<%= c.getName() %>を削除しました。</p>
<p>復元する場合は数字を押してください</p>
	<form action="/HAYNTH/ItemRestorationServlet" method="post" class="">
		<input type="hidden" name="category" value="<%= c.getCategory() %>">
		<input type="hidden" name="name" value="<%= c.getName() %>">
		<input type="hidden" name="price" value="<%= c.getPrice() %>">
		<input type="hidden" name="quantity" value="<%= c.getQuantity() %>">
		<input type="hidden" name="explanation" value="<%= c.getExplanation() %>">
		<input type="hidden" name="image_path" value="<%= c.getImage_path() %>">
		<input type="hidden" name="itemId" value="<%= c.getItem_id() %>">
		<input type="submit" value="<%= c.getItem_id() %>" name="修正">
	</form>
	<p>このページを閉じると復元はできません！！</p>
	<% request.setAttribute("ctgList", ctgList); %>
<%} %>
<%} %>

</div>
<h1>商品登録画面</h1>
<div class="manage_wrap">
	<form action="/HAYNTH/ItemManageServlet" method="post" enctype="multipart/form-data">
		<div class="manage_title">
			<p class="ma_category">CATEGORY：</p>
			<p class="ma_name">NAME：</p>
			<p class="ma_price">PRICE：</p>
			<p class="ma_quantity">QUANTITY</p>
			<p class="ma_explanation">EXPLANATION：</p>
			<p class="ma_picture">PICTURE：</p>
		</div>
		<div class="manage_form">
			<select name="category" id="category">
			    <option value="">--Please choose an option--</option>
			    <option value="book">Book</option>
			    <option value="cosmetic">Cosmetic</option>
			    <option value="fashion">Fashion</option>
			    <option value="food">Food</option>
			    <option value="gadget">Gadget</option>
			    <option value="outdoors">Outdoors</option>
			</select><br>
			
			<input type="text" name="itemName"><br>
			<input type="number" name="itemPrice"><br>
			<input type="number" name="itemQuat"><br>
			<textarea name="itemExplan" cols="50" rows="4" maxlength="80" placeholder="200字以内で入力してください。"></textarea><br>
			<label class="input_botton">
				<input type="file" name="item" onchange="OnFileSelect( this );" multiple>SELECT<br>
			</label>
			<ul id="ID001" style="list-style: none; padding-left: 0;"></ul>
		</div>
			<input type="submit" value="CONFIRM">
		
	</form>
</div>

<form action="/HAYNTH/ItemCategoryServlet" method="get" >
<input type="submit" name="ctg" value="fashion">
<input type="submit" name="ctg" value="cosmetic">
<input type="submit" name="ctg" value="food">
<input type="submit" name="ctg" value="book">
<input type="submit" name="ctg" value="gatget">
<input type="submit" name="ctg" value="outdoors" >
</form>
<div class="footerarea">
</div>
</body>
</html>