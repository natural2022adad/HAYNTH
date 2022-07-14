<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div class="kanri_wrap">
<form action="/HAYNTH/KanriServlet" method="get">
<p>カテゴリ：
<select name="category" id="category">
    <option value="">--Please choose an option--</option>
    <option value="book">Book</option>
    <option value="cosmetic">Cosmetic</option>
    <option value="fashion">Fashion</option>
    <option value="food">Food</option>
    <option value="gadget">Gadget</option>
    <option value="outdoors">Outdoors</option>
</select></p>

<p>商品名：<input type="text" name="itemName"></p>
<p>値段：<input type="number" name="itemPrice"></p>
<p>個数：<input type="number" name="itemQuat"></p>
<p>説明文：<textarea name="itemExplan" cols="50" rows="4" maxlength="80" placeholder="200字以内で入力してください。"></textarea></p>
<p>画像アップロード：<input type="file" name="itemImg"></p>
<input type="submit" value="登録">

</form>

	
</div>

<div class="footerarea">
</div>
</body>
</html>