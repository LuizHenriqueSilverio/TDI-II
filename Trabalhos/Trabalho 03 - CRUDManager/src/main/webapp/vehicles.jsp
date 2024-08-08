<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="base-head.jsp"%>
		<title>CRUD MANAGER - VEÍCULOS</title>
	</head>
	
	<body>
		<%@include file="modal.html"%>
		<%@include file="nav-menu.jsp"%>
		
		<div id="container" class="container-fluid">
		
			<div id="alert" style="${not empty message ? 'display: block;' : 'display: none;'}" class="alert alert-dismissable ${alertType eq 1 ? 'alert-success' : 'alert-danger'}">
			  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			  ${message}
			</div>
			
			<div id="top" class="row">
	 			<div class="col-md-3">
			        <h3>Veículos</h3>
			    </div>
			 
			    <div class="col-md-6">
			        <div class="input-group h2">
			            <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar veículos">
			            <span class="input-group-btn">
			                <button class="btn btn-danger" type="submit">
			                    <span class="glyphicon glyphicon-search"></span>
			                </button>
			            </span>
			        </div>
			    </div>
			    
			    <div class="col-md-3">
			        <a href="/crud-manager/vehicle/form" class="btn btn-danger pull-right h2"><span class="glyphicon glyphicon-plus" /></span>&nbspAdicionar Veículo</a>
			    </div>
			    
     	</div>
     	
     	<hr />
     	
     	<div id="list" class="row">
     			<div class="table-responsive col-md-12">
     				<table class="table table-striped table-hover" cellspacing="0" cellpadding="0">
     					<thead>
			                <tr>
			                    <th>Tipo</th>
			                    <th>Marca</th>
			                    <th>Modelo</th>
			                    <th>Ano de Fabricação</th>
			                    <th>Placa</th>
			                    <th>Empresa</th>
			                    <th>Editar</th>
			                    <th>Excluir</th>
			                 </tr>
		            	</thead>
		            	<tbody>
		            		<c:forEach var="vehicle" items="${vehicles}">
			            		<tr>
				                    <td>${vehicle.getType()}</td>
				                    <td>${vehicle.getBrand()}</td>
				                    <td>${vehicle.getModel()}</td>
				                    <td>${vehicle.getYearOfManufacture()}</td>
				                    <td>${vehicle.getPlate()}</td>
				                    <td>${vehicle.getCompany().getName()}</td>				                    
				                    
				                    <td class="actions">
				                        <a class="btn btn-info btn-xs" 
				                           href="${pageContext.request.contextPath}/vehicle/update?vehicleId=${vehicle.getId()}" >
				                           <span class="glyphicon glyphicon-edit"></span>
				                        </a>
				                    </td>
				                    
				                    <td class="actions">
				                        <a class="btn btn-danger btn-xs modal-remove"
				                           data-vehicle-id="${vehicle.getId()}" 
				                           data-vehicle-name="${vehicle.getModel()}" data-toggle="modal" 
				                           data-target="#delete-modal"  href="#"><span 
				                           class="glyphicon glyphicon-trash"></span></a>
				                    </td>
				                </tr>
		            		</c:forEach>
		            	</tbody>
     				</table>
     			</div>
     		</div>
     		<script src="js/jquery.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<script type="text/javascript">
				$(document).ready(function() {
				    // fecha o alert após 3 segundos
				    setTimeout(function() {
				        $("#alert").slideUp(500);
				    }, 3000);
				    
				    // ao clicar no delete de algum post, pega o nome do usuário, 
				    // o id do usuário e a ação (delete) e envia para o modal 
				    $(".modal-remove").click(function () {
			            var sellerName = $(this).attr('data-seller-name');
			            var sellerId = $(this).attr('data-seller-id');
			            $(".modal-body #hiddenValue").text("o vendedor '"+sellerName+"'");
			            $("#id").attr( "value", sellerId);
			            $("#entityName").attr("value", sellerName);
			            $("#form").attr( "action","seller/delete");
			        })
				});
			</script>
	</body>
</html>