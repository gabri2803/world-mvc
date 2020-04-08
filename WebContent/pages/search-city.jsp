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
<a href="/world-mvc/continent-list"><button>Lista Continenti</button></a>
	<form action="/world-mvc/search-by" method="get">
		Nome città: <input type="text" name="name"><br> Nazione: <select name="country" >
			<option value=''>Nessuna nazione</option>
			<c:forEach items="${countryList}" var="country">
				<option value='${country.code}'>${country.name}</option>
			</c:forEach>
			</select>	<br>	
		<input type="submit" value="Search"></input>
	</form>
	<p>
		<c:forEach items="${cityList}" var="city">
				<p>${city.name}</p> 
			</c:forEach>
	</p>
</body>
</html>