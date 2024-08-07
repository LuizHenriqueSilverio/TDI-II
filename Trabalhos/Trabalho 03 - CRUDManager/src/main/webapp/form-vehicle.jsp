<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="base-head.jsp"%>
		<title>CRUD MANAGER - ${action eq "insert" ? "ADICIONAR " : "EDITAR "} VEÍCULO</title>
	</head>
	
	<body>
		<%@include file="nav-menu.jsp"%>
		<h3 class="page-header">${action eq "insert" ? "Adicionar " : "Editar "} Veículo</h3>
	</body>
</html>