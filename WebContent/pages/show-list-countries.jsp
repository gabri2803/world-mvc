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
	<c:forEach items="${countryList}" var="country">
		<p>
			Name: <a href="/world-mvc/list-city?code=${country.code}">${country.name}</a>
			-- Population: ${country.population}
		</p>
	</c:forEach>
</body>
</html>