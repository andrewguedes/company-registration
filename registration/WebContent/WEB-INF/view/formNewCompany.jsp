<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/CreateCompany" var="linkNewCompany"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
		<title>Registrar Empresa</title>
		<style><%@ include file="../css/reset.css"  %></style>
		<style><%@ include file="../css/base.css"  %></style>
		<style><%@ include file="../css/menu.css"  %></style>
		<style><%@ include file="../css/change-company.css"  %></style>
	</head>
	<body>
		<c:import url="menu.jsp"/>
			
		<form class="form-change-company" action="${linkNewCompany }" method="post">
			
			<label class="form-label">Nome:</label> 
			<input class="form-input" type="text" name="name"  />
			
			<label class="form-label">Data Abertura:</label> 
			<input class="form-input" type="date" name="date"  />
			
			<input class="form-button" type="submit" />
		</form>
	
	</body>
</html>