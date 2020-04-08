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
	<a href="/world-mvc/country-list">Indietro</a>
	<a href="/world-mvc/insert?id=-1"><button>Insert City</button></a>
	<h1>${message}</h1>
	<c:forEach items="${cityList}" var="city">
		<p>
			Name: ${city.name} Population: ${city.population}
			<a href="/world-mvc/insert?id=${city.id}"><button>Modifica</button></a>
		</p>
	</c:forEach>
</body>
</html>