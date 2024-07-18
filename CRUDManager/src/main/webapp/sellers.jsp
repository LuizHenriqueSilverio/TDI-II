<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="base-head.jsp"%>
		<title>CRUD Manager - Vendedores</title>
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
			        <h3>Vendedores</h3>
			    </div>
			 
			    <div class="col-md-6">
			        <div class="input-group h2">
			            <input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar vendedores">
			            <span class="input-group-btn">
			                <button class="btn btn-danger" type="submit">
			                    <span class="glyphicon glyphicon-search"></span>
			                </button>
			            </span>
			        </div>
			    </div>
			    <div class="col-md-3">
			        <a href="/crud-manager/seller/form" class="btn btn-danger pull-right h2"><span class="glyphicon glyphicon-plus" /></span>&nbspAdicionar Vendedor</a>
			    </div>
     		</div>
		</div>
	</body>
</html>