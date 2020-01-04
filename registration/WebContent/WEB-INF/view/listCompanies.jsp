<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.andrew.registration.model.Company"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html class="container">
	<head>
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
		<title>Empresas</title>
		<style><%@ include file="../css/reset.css"  %></style>
		<style><%@ include file="../css/base.css"  %></style>
		<style><%@ include file="../css/menu.css"  %></style>
		<style><%@ include file="../css/list-companies.css"  %></style>
	</head>
	<body>
		<c:import url="menu.jsp"/>
				
		<c:if test="${not empty company}">
			Empresa ${ company } cadastrada com sucesso!
		</c:if>
		
		<ul class="ul-container">
			<c:forEach items="${companies}" var="company">				
				<li class="li-container">
					<label class="li-label">${company.name }</label>
					
					<label class="li-date"><fmt:formatDate value="${company.openingDate }" pattern="dd/MM/yyyy"/></label> 
					
					<a class="li-edit" href="/registration/ShowCompany?id=${company.id }">
						<%@ include file="../images/icons/brush.svg" %>
					</a>
					
					<a class="li-remove" href="/registration/RemoveCompany?id=${company.id }">
						<%@ include file="../images/icons/trash-fill.svg" %>
					</a>
				</li>
			</c:forEach>
		</ul>
		
	</body>
</html>



