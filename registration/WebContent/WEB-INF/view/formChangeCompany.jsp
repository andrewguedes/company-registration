<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/ChangeCompany" var="linkNewCompany"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
		<title>Insert title here</title>
		<style><%@ include file="../css/reset.css"  %></style>
		<style><%@ include file="../css/base.css"  %></style>
		<style><%@ include file="../css/menu.css"  %></style>
		<style><%@ include file="../css/change-company.css"  %></style>	
	</head>
	<body>
		<c:import url="menu.jsp"/>
		
		<form class="form-change-company" action="${linkNewCompany }" method="post">
		
			<label class="form-label">Nome:</label> 
			<input class="form-input" type="text" name="name" value="${company.name }" />
			
			<label class="form-label">Data Abertura:</label> 
			<input class="form-input" type="date" name="date" value="<fmt:formatDate value="${company.openingDate}" pattern="yyyy-MM-dd"/>" />
			
			<input type="hidden" name="id" value="${company.id }">
			<input class="form-button" type="submit" />
		</form>
	</body>
</html>