<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item,model.Cart, java.util.ArrayList, java.util.*" %>
<%
//ArrayList<Cart> cart = new ArrayList<Cart>();
//session.setAttribute("cart", cart);
Map<String, Integer> cart = new LinkedHashMap<String, Integer>();
session.setAttribute("cart", cart);
System.out.println("index.jp_cart" + cart);

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


<div class="item_wrap">
	<div class="item_img_wrap">
		<div class="kakunin">
			<form action="/HAYNTH/ItemCategoryServlet2" method="get" class="">
			<br><br><br>
			<button type="submit" name="ctg" value="allitem" class="allitem"></button >
		    </form>
		</div>
	</div>	
</div>


<footer>
<div class="footerarea">

</div>
</footer>
</body>
</html>