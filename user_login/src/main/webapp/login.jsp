<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta charset="windows-1256">
<title>Login Page</title>
</head>
<body>

<form:form method="POST" action="authenticate" modelAttribute="user">
	<table>
		<tr>
			<td> <form:label  path="username">Name : </form:label></td>
			<td><form:input path="username"/></td>
		</tr>
		<tr>
			<td> <form:label path="password">Password : </form:label></td>
			<td><form:password path="password"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Login"></td>
		</tr>
	</table>
</form:form>

	<h2 style="color:red">
				${message}  
	</h2>
</body>
</html>