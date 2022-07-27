<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item, model.Key,java.util.List" %>
<%
//リクエストスコープに保存された
List<Item> ctgList = (List<Item>) request.getAttribute("ctgList");
Key Jbk = (Key) request.getAttribute("Jbk");
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
<h1>ITEM_ID:<%= Jbk.getNumKey() %></h1>
</div>

<div class="manage_wrap">
<% for(Item c : ctgList) {%>
	<form action="/HAYNTH/ItemCategoryServlet" method="post" enctype="multipart/form-data">
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
			    <option value="<%= c.getCategory() %>"><%= c.getCategory() %></option>
			    <option value="book">Book</option>
			    <option value="cosmetic">Cosmetic</option>
			    <option value="fashion">Fashion</option>
			    <option value="food">Food</option>
			    <option value="gadget">Gadget</option>
			    <option value="outdoors">Outdoors</option>
			</select><br>
			
			<input type="text" name="itemName" value="<%= c.getName() %>"><br>
			<input type="number" name="itemPrice" value="<%= c.getPrice() %>"><br>
			<input type="number" name="itemQuat" value="<%= c.getQuantity() %>"><br>
			<textarea name="itemExplan" cols="50" rows="4" maxlength="80" placeholder="200字以内で入力してください。"><%= c.getExplanation() %></textarea><br>
			<% if(c.getImage_path() != null){%><p class="manage_img"><img src="/HAYNTH/upload/<%= c.getImage_path() %>"></p><%} %>
			<% if(c.getImage_path2() != null){%><p class="manage_img"><img src="/HAYNTH/upload/<%= c.getImage_path2() %>"></p><%} %>
			<% if(c.getImage_path3() != null){%><p class="manage_img"><img src="/HAYNTH/upload/<%= c.getImage_path3() %>"></p><%} %>
			<label class="input_botton">
				<% if(c.getImage_path() != null){%><input type="hidden" name="image_path" value="<%= c.getImage_path() %>"><%} %>
				<% if(c.getImage_path2() != null){%><input type="hidden" name="image_path2" value="<%= c.getImage_path2() %>"><%} %>
				<% if(c.getImage_path3() != null){%><input type="hidden" name="image_path3" value="<%= c.getImage_path3() %>"><%} %>
				<input type="file" name="item" onchange="OnFileSelect( this );" multiple>ADD<br>
			</label>
			<ul id="ID001" style="list-style: none; padding-left: 0;"></ul>
		</div>
		<div class="item_con_btn_wrap">
			<div class="itemconfirm">
				<input type="hidden" name="itemId" value="<%= c.getItem_id() %>">
				 <button type="submit" value="CHANGED" class="change"></button >
			</div>
		</div>
			
	</form>
	<%
	//スコープに保存された
	session.setAttribute("c", c);
	%>
 <% } %>
</div>

<div class="ctg_btn_footer">
	<form action="/HAYNTH/ItemCategoryServlet" method="get" class="ctg_btn_form">
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