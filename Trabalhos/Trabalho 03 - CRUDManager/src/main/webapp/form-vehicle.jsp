<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="base-head.jsp"%>
		<meta charset="UTF-8">
		<title>CRUD MANAGER - ${action eq "insert" ? "ADICIONAR " : "EDITAR "} VEÍCULO</title>
	</head>
	
	<body>
		<%@include file="nav-menu.jsp"%>
		<div id="container" class="container-fluid">
			<h3 class="page-header">${action eq "insert" ? "Adicionar " : "Editar "} Veículo</h3>
			
			<form action="${pageContext.request.contextPath}/vehicle/${action}" method="POST">
				<input type="hidden" value="${vehicleEdit.getId()}" name="vehicleId">
				
				<div class="row">
					<div class="form-group col-md-6">
						<label for="content">Tipo</label>
							<input type="text" class="form-control" id="vehicle_type" name="vehicle_type" 
							  autofocus="autofocus" placeholder="Tipo de Veículo" 
							  required oninvalid="this.setCustomValidity('Por favor, informe o tipo do veículo.')"
							  oninput="setCustomValidity('')"
							  value="${vehicleEdit.getType()}"
							  >
					</div>
					
					
					
					<div class="form-group col-md-6">
						<label for="content">Brand</label>
							<input type="text" class="form-control" id="vehicle_brand" name="vehicle_brand" 
							   autofocus="autofocus" placeholder="Marca do Veículo" 
							   required oninvalid="this.setCustomValidity('Por favor, informe a marca do veículo.')"
							   oninput="setCustomValidity('')"
							   value="${vehicleEdit.getBrand()}"
							   >
					</div>
					
					
				
					<div class="form-group col-md-6">
						<label for="content">Modelo</label>
							<input type="text" class="form-control" id="vehicle_model" name="vehicle_model" 
								  autofocus="autofocus" placeholder="Modelo do veículo" 
								  required oninvalid="this.setCustomValidity('Por favor, informe o modelo do veículo.')"
								  oninput="setCustomValidity('')"
								  value="${vehicleEdit.getModel()}"
								  >
					</div>
					
					<div class="form-group col-md-6">
						<label for="content">Ano de Fabricação</label>
							<input type="number" class="form-control" id="vehicle_yearOfManufacture" name="vehicle_yearOfManufacture" 
								  autofocus="autofocus" placeholder="Ano de Fabricação do Veículo" 
								  required oninvalid="this.setCustomValidity('Por favor, informe o ano de fabricação do veículo.')"
								  oninput="setCustomValidity('')"
								  value="${vehicleEdit.getYearOfManufacture()}"
								  >
					</div>
					
					<div class="form-group col-md-6">
						<label for="content">Plate</label>
							<input type="text" class="form-control" id="vehicle_plate" name="vehicle_plate" 
								  autofocus="autofocus" placeholder="Placa do veículo" 
								  required oninvalid="this.setCustomValidity('Por favor, informe a placa do veículo.')"
								  oninput="setCustomValidity('')"
								  value="${vehicleEdit.getPlate()}"
								  >
					</div>
					
					<div class="form-group col-md-6">
							<label for="vehicle_company">Empresa</label>
							<select id="vehicle_company" class="form-control selectpicker" name="vehicle_company" 
								    required oninvalid="this.setCustomValidity('Por favor, informe a empresa.')"
								    oninput="setCustomValidity('')">
							  <option value="" disabled ${not empty vehicleEdit ? "" : "selected"}>Selecione uma empresa</option>
							  <c:forEach var="company" items="${companies}">
							  	<option value="${company.getId()}" 
							  		${sellerEdit.getCompany().getId() eq company.getId() 
							  		? "selected" : ""}>
							  		${company.getName()}
							  	</option>	
							  </c:forEach>
							</select>
					</div>
				</div>
				<hr />
				<div id="actions" class="row pull-right">
					<div class="col-md-12">
						<a href="${pageContext.request.contextPath}/vehicles" class="btn btn-default">Cancelar</a>
						<button type="submit" class="btn btn-primary">${action eq "insert" ? "Criar " : "Editar "} Veículo</button>
					</div>
				</div>				
			</form>
		</div>
		
		
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script type="text/javascript">
		 $(document).ready(function()) {
			 setTimeout(function() {
			 	$("#alert").slideUp(500);
			 }, 5000);
			 
			 
		 });
		</script>
	</body>
</html>