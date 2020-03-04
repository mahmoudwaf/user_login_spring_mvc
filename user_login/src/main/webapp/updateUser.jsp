<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<script type="text/javascript">
	function back(){
		 window.location = "home";
	}
</script>
</head>
<body>
 
		<form:form method="POST" action="updateUser"  modelAttribute="user">
		<form:hidden path="user_id"/>
		<table>	
			<tr>
				<td>Username</td>
				<td><form:input  path="username" id="usernameInput"></form:input></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input  path="password" id="passwordInput"></form:input></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><form:input  path="role" id="roleInput"></form:input></td>
			</tr>
			<tr>
				<td> </td>
				<td><input type="submit" value="Save"><input type="button" value="Back" onclick="back()"></td>
			</tr>
		</table>
		</form:form>
	 <h2 style="color:red">
				${message}  
	</h2>
</body>
</html>