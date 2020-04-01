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
		Insert Country Name:
		<input type="text" name="nameCountry">
		Insert Continent Name:
		<input type="text" name="continentName"> <br>
		<button type="submit" formaction="/world-mvc/country">Search</button>
		<p>
		Codice Nazione: ${country.code} <br>
		Nome Nazione: ${country.name} <br>
		Continente: ${country.continent} <br>
		Popolazione: ${country.population} <br>
		Estensione Geografica: ${country.surfaceArea}
		</p>
	</form>
	<a href="/world-mvc/pages/index.jsp"><button type="button">Back</button></a>
</body>
</html>