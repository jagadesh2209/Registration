<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form:form action="update" modelAttribute="reg">
				ID		:<form:input path="id"/><br>
				name	:<form:input path="name"/><br>
				age		:<form:input path="age"/><br>
				gmail	:<form:input path="gmail"/><br>
				gender	:<form:input path="gender"/><br>
				dob		:<form:input path="dob"/><br>
						<form:button>UPDATE</form:button>
		</form:form>
</body>
</html>
