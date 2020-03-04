<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="jquery-ui.js"></script>
<link rel="stylesheet" href="jquery-ui.css">
<script type="text/javascript">
	jQuery(document).ready(function(){
		//alert('ready');		
	});
	
	
	function openUpdateUser(user_id,username,password,role){
		/* $("#editUserDiv" ).dialog();
		 jQuery("#user_id").val(user_id);
		 jQuery("#usernameInput").val(username);
		 jQuery("#passwordInpt").val(userpassword);
		 jQuery("#roleInput").val(role);*/
		// var url = "openUpdate?user_id="+user_id+"&username="+username+"&password="+password+"&role="+role;
		//jQuery("#updateUserDiv").show();
		 //jQuery("#updateUserDiv").dialog();
		// jQuery("#updateUserDiv").load(url);
		 window.location = "openUpdate?user_id="+user_id+"&username="+username+"&password="+password+"&role="+role;
	}
	
	function deleteUser(user_id){
		var deleteForm = document.deleteForm;
		deleteForm.user_id.value = user_id;
		deleteForm.submit()
	}
	
	function openAddUser(){
		window.location = "openAddUser";
	}
</script>
</head>
<body>
 
	<h2>
			${message} 
		</h2>
		
	<input type="button" value="Add new user" onclick="openAddUser()"/>
	<table border="1" cellpadding="0" cellspacing="0">
		<thead style="background-color:gray;">
			<td>User ID</td>
			<td>User Name</td>
			<td>Password</td>
			<td>Role</td>
			<td>&nbsp;</td>
		</thead>
		<c:forEach var="user" items="${userList}" > 
			<tr>	
				<td>${user.user_id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.role}</td>
				 <td>
				 	<img src="edit.png" width="20" height="20" onclick="openUpdateUser('${user.user_id}','${user.username}','${user.password}','${user.role}')" />
				 		&nbsp;
				 	<img src="delete.jpg" width="20" height="20" onclick="deleteUser('${user.user_id}')" />
				 </td>  
			</tr>
		</c:forEach>
	</table>
	<div id="updateUserDiv" style="display: none;"> </div>
	
	<form:form  name="deleteForm" method="POST" action="deleteUser" modelAttribute="user">  
		<form:hidden   path="user_id"  />
	</form:form>
</body>
</html>