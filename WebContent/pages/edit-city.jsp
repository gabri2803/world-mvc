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
<form method="post" action="/world-mvc/insert">
<input type="hidden" name="idCity" value="${city.id}">
	Inserisci nuova città:
	Name:
	<input type="text" name="name" value="${city.name}"><br>
	Country: 
	<select name="code">
		<c:forEach items="${countryList}" var="country">
				<c:choose>
					<c:when test="${city.countryCode == country.code}">
						<option value="${country.code}" selected>${country.name}</option>
					</c:when>
					<c:otherwise>
						<option value="${country.code}">${country.name}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
	</select><br>
	District:
	<input type="text" name="dist" value="${city.district}"><br>
	Population:
	<input type="text" name="pop" value="${city.population}"><br>
	<input type="submit" value="Salva"></input>
</form>
</body>
</html>