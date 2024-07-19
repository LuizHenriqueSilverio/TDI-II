<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="base-head.jsp"%>
		<meta charset="UTF-8">
		<title>CRUD MANAGER - INSERIR VENDEDOR</title>
	</head>
	<body>
		<%@include file="nav-menu.jsp"%>
		
		<div id="container" class="container-fluid">
			<h3 class="page-header">Adicionar Vendedor</h3>
			
			<form action="${pageContext.request.contextPath}/seller/insert" method="POST">
				<input type="hidden" value="${seller.getId()}" name="postId">
				
				<div class="row">
					<div class="form-group col-md-6">
						<label for="content">Nome</label>
							<input type="text" class="form-control" id="seller_name" name="seller_name" 
							  autofocus="autofocus" placeholder="Nome do Vendedor" 
							  required oninvalid="this.setCustomValidity('Por favor, informe o nome do vendedor.')"
							  oninput="setCustomValidity('')">
					</div>
					
					
					
					<div class="form-group col-md-6">
						<label for="content">Email</label>
							<input type="email" class="form-control" id="seller_email" name="seller_email" 
							   autofocus="autofocus" placeholder="Email do Vendedor" 
							   required oninvalid="this.setCustomValidity('Por favor, informe o email do vendedor.')"
							   oninput="setCustomValidity('')">
					</div>
					
					
				
					<div class="form-group col-md-6">
						<label for="content">Telefone</label>
							<input type="number" class="form-control" id="seller_fone" name="seller_fone" 
								  autofocus="autofocus" placeholder="Telefone do Vendedor" 
								  required oninvalid="this.setCustomValidity('Por favor, informe o telefone do vendedor.')"
								  oninput="setCustomValidity('')">
					</div>
					
					<div class="form-group col-md-6">
							<label for="seller_company">Empresa</label>
							<select id="seller_company" class="form-control selectpicker" name="seller_company" 
								    required oninvalid="this.setCustomValidity('Por favor, informe a empresa.')"
								    oninput="setCustomValidity('')">
							  <option value="" disabled ${not empty seller ? "" : "selected"}>Selecione uma empresa</option>
							  <c:forEach var="company" items="${companies}">
							  	<option value="${company.getId()}">
							  		${company.getName()}
							  	</option>	
							  </c:forEach>
							</select>
					</div>
				</div>
				<hr />
				<div id="actions" class="row pull-right">
					<div class="col-md-12">
						<a href="${pageContext.request.contextPath}/sellers" class="btn btn-default">Cancelar</a>
						<button type="submit" class="btn btn-primary">${not empty post ? "Alterar Vendedor" : "Criar Vendedor"}</button>
					</div>
				</div>
			</form>
			
		</div>
	</body>
</html>