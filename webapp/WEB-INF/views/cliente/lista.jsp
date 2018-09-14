<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="jspView" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jspView:page cabecalho="SIM" title="Clientes">
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Cliente</th>
					<th>Projetos</th>
					<th>Valor</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista_clientes_projetos}" var="cliente">
					<tr>
						<td>${cliente.cliente}</td>
						<td>${cliente.quantidade}</td>
						<td>${cliente.total}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</jspView:page>