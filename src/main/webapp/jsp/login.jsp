<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<form action="/AppLogin/LoginController" method= "post">
		Username: <input type= "text" name = "username" required><br>
		Password: <input type= "password" name = "password" required><br>
		<input type="submit" value="Login">
	</form>
	
	<font color="red">
        <% String errorMessage = (String) request.getAttribute("errorMessage");
           if (errorMessage != null) out.print(errorMessage); %>
    </font>

</body>
</html>