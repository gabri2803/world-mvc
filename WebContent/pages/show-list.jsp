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
	<a href="/world-mvc/pages/index.jsp"><button type="button">Home</button></a>
	<a href="/world-mvc/continent-list"><button type="submit">Lista Continenti</button></a>
	<a href="/world-mvc/search-by"><button type="submit" >Search City</button></a>
	<a href="/world-mvc/insert?id=-1"><button type="submit" >Insert City</button></a>
	${tornaCont}
	<p style="color: green">${done}</p>
	
	<c:forEach items="${continent}" var="continent">
		<h2>
			Name: <a href="/world-mvc/country-list?nameCont=${continent}">${continent}
			</a>
		</h2>
	</c:forEach>
	<c:forEach items="${countryList}" var="country">
		<p>
			Name: <a href="/world-mvc/list-city?code=${country.code}">${country.name}</a>
			-- Population: ${country.population}
		</p>
	</c:forEach>
	<c:forEach items="${cityList}" var="city">
		<p>Name: ${city.name} Population: ${city.population}
		<a href="/world-mvc/insert?id=${city.id}"><button type="submit">Modifica</button></a>
		</p>
	</c:forEach>
	
</body>
</html>