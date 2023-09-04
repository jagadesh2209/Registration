<%@page import="com.org.dto.Register"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>${msg}</h1>
			<table border="2px">
				<tr>
				<th>id</th>
				<th>name</th>
				<th>age</th>
				<th>gmail</th>
				<th>gender</th>
				<th>dob</th>
				<th>edit</th>
				<th>delete</th>
				</tr>
				
				<%
						List<Register> reg=(List<Register>) session.getAttribute("reg");
						for(Register e:reg){
				%>
				   <tr>
				   		<td><%=e.getId()%></td>
				   		<td><%=e.getName()%></td>
				   		<td><%=e.getAge()%></td>
				   		<td><%=e.getGmail()%></td>
				   		<td><%=e.getGender()%></td>
				   		<td><%=e.getDob()%></td>
				   		<td><a href="edit?id=<%=e.getId()%>">edit</a></td>
				   		<td><a href="delete?id=<%=e.getId()%>">delete</a></td>
				   	</tr>
				   	
				   	<% }
				   	
				   	%>
				</table>
</body>
</html>

				   		
				   		
				   		