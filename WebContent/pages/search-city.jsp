<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/world-mvc/search-by" method="get">
	<a href="/world-mvc/search-by">Cerca un altra città</a><br>
		Nome città: <input type="text" name="name"><br> Nazione: <select name="country" >
			<option value=''>Nessuna nazione
			<c:forEach items="${country}" var="country">
				<option value='${country.code}'>${country.name}
			</c:forEach>
			</select>	<br>	
		<button type="submit" formaction="/world-mvc/search-by">Search</button>
		<p>
		<c:forEach items="${city}" var="city">
		<p>${city.name}</p> 
		</c:forEach>
		</p>
	</form>
</body>
</html>