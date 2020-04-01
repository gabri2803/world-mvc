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
	ID: ${city.id} <br>
	Inserisci nuova città:
	Name:
	<input type="text" name="name" value="${city.name}"><br>
	Country: 
	<select name="code">
		<c:forEach items="${country}" var="country">
				<option value='${country.code}'>${country.name}
			</c:forEach>
	</select><br>
	District:
	<input type="text" name="dist"><br>
	Population:
	<input type="text" name="pop"><br>
	<a href="/world-mvc/insert"><button type="submit">Aggiungi/Modifica</button></a>	
</form>
</body>
</html>