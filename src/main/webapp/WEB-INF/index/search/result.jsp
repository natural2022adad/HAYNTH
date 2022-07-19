<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="model.Item,model.Search,java.util.List" %>
    <%
    List<Item> itemList=(List<Item>)request.getAttribute("itemList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
<c:forEach var="item" items="{$itemList}">
	<p>CATEGORY:<c:out value="{$item.category}"/></p>
	<p>NAME:<c:out value="{$item.name}"/></p>
	<p>EXPLANATION:<c:out value="{$item.explamation}"/></p>
	<p>PRICE:<c:out value="{$item.price}"/></p>
	<p>QUANTITY:<c:out value="{$item.quantity}"/></p>
</c:forEach>


 -->
</body>
</html>