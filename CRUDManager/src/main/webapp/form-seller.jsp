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
			
			<form action="${pageContext.request.contextPath}/seller/${action}" method="POST">
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
							<label for="user">Usuário</label>
							<select id="user" class="form-control selectpicker" name="user" 
								    required oninvalid="this.setCustomValidity('Por favor, informe o usuário.')"
								    oninput="setCustomValidity('')">
							  <option value="" disabled ${not empty post ? "" : "selected"}>Selecione um usuário</option>
							  <c:forEach var="user" items="${users}">
							  	<option value="${user.getId()}"  ${post.getUser().getId() == user.getId() ? "selected" : ""}>
							  		${user.getName()}
							  	</option>	
							  </c:forEach>
							</select>
					</div>
				</div>
				
			</form>
			
		</div>
	</body>
</html>