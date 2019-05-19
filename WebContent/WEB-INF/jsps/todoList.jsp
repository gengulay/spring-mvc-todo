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
	<c:forEach items="${todoList}" var="todo">
		 <h2>${todo.id}</h2> 
		<h2>${todo.done}</h2>
		<h2>${todo.description}</h2>
		<br />
	</c:forEach>
</body>
</html>