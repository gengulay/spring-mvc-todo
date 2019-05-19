<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/addTodo"
		method="post" modelAttribute="todo">
		<p>Description</p>
		<form:input path="description" />
		<p>PersonName</p>
		<form:select path="personName" items="${personList}" />
		<input type="submit" value="Add Todo">
	</form:form>
</body>
</html>