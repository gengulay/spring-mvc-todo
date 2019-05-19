<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${personList}" var="person">
		<h2>
			<a href="${pageContext.request.contextPath}/personList/person/${person.name}"> ${person.name} </a>
		</h2>
		<h2>${person.age}</h2>
		<h2>${person.id}</h2>
		<br />
	</c:forEach>
</body>
</html>