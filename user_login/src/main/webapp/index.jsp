<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
 
		<h2>Hello World</h2>
		<h3>
			<a href="hello?name=Eric">Click Here 2</a>
		</h3>
		
		<form action="login" method="get">
			Username : <input type="text" name="username">
			<br>
			Password : <input type="password" name="password">
			<br>
			<input type="submit" value="Login">
		</form>
		
		<h2 style="color:red">
			${message}  
		</h2>
 
</body>
</html>