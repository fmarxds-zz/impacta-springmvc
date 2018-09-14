<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="jspView" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="LINK_LISTA_PROJETOS" value="/cliente/detalhes" />

<jspView:page cabecalho="SIM" title="Cliente">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h3>Selecione o Cliente</h3>
				<div class="form-horizontal">
					<form action="${LINK_LISTA_PROJETOS}" method="GET">
						<div class="form-group">
							<label for="idCliente" class="control-label col-sm-3">Cliente:</label>
							<div class="col-sm-9">
								<select id="idCliente" name="idCliente" class="form-control">
									<c:forEach items="${lista_cliente}" var="cliente">
										<option value="${cliente.idCliente}">${cliente.nome}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-info" />
						</div>
					</form>
				</div>
			</div>
			<div class="col-sm-6">
				<c:if test="${not empty lista_clienteProjeto}">
					<h3>Projetos do Cliente</h3>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Cliente</th>
								<th>Documento</th>
								<th>Descrição</th>
								<th>Valor</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lista_clienteProjeto}" var="clienteProjeto">
								<tr>
									<td>${clienteProjeto.cliente}</td>
									<td>${clienteProjeto.documento}</td>
									<td>${clienteProjeto.descricao}</td>
									<td>${clienteProjeto.valor}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</jspView:page>