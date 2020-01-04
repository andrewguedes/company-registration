<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/LoginAction" var="linkLogin"/>

<!DOCTYPE html>
<html class="container">
<head>
	<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
	<title>Registration Companies</title>
	<style><%@ include file="../css/reset.css"  %></style>
	<style><%@ include file="../css/base.css"  %></style>
	<style><%@ include file="../css/login.css"  %></style>	
</head>
<body>
	<div class="login-container">
		<form class="form-login" action="${linkLogin }" method="post">	
			<label class="input-label">Login:</label> 
			<input class="input-login" type="text" name="login" autofocus/>
			<label  class="input-label">Senha:</label> 
			<input class="input-login" type="password" name="password"  />
			<input class="button-login" type="submit" value="Login"/>
		</form>
	</div>
</body>
</html>