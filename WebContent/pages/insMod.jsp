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
<form method="post">
<input type="hidden" name="idCity" value="${city.id}">
<input type="hidden" name="nameCity" value="${city.name}">
	Inserisci nuova città:
	Name:
	<input type="text" name="name" value="${city.name}"><br>
	Country: 
	<select name="code">
		<c:forEach items="${country}" var="country">
				<option value='${country.code}'>
				<c:choose>
					<c:when test="${city.countryCode}">${country.name}</c:when>
					<c:otherwise>${country.name}</c:otherwise>
				</c:choose>
			</c:forEach>
	</select><br>
	District:
	<input type="text" name="dist" value="${city.district}"><br>
	Population:
	<input type="text" name="pop" value="${city.population}"><br>
	<a href="/world-mvc/insert"><button type="submit">Aggiungi/Modifica</button></a>	
</form>
</body>
</html>