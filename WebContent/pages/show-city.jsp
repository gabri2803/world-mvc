<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get">
		<h2>Insert your name city:</h2>
		<input type="text" name="nameCity">
		<button type="submit" formaction="/world-mvc/city">Search</button>
			<p id="idCity">ID: ${city.id}</p> 
			<p id="cityName">Name: ${city.name}</p> 
			<p id="countryCode">Country Code: ${city.countryCode}</p>
			District: ${city.district}<br>
			Population: ${city.population}
	</form>
	${errore}
	<a href="/world-mvc/insert"><button type="submit">Modifica</button></a>
	<a href="/world-mvc/pages/index.jsp"><button type="button">Back</button></a>
</body>
</html>