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
<form method="get">
		<h2>Insert your id city:</h2>
		<input type="text" name="id">
		<button type="submit" formaction="/world-mvc/city">Search</button>
			<p>ID: ${city.id}</p> 
			<p>Name: ${city.name}</p> 
			<p>Country Code: ${city.countryCode}</p>
			<p>District: ${city.district}</p>
			<p>Population: ${city.population}</p>
	</form>
</body>
</html>