<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jspView" tagdir="/WEB-INF/tags"%>

<c:url var="LINK_PROJETO_CADASTRO" value="/projeto/cadastro" />
<c:url var="LINK_CRONOGRAMA_CADASTRO" value="/cronograma/cadastro" />
<c:url var="LINK_CLIENTE_DETALHE" value="/cliente" />
<c:url var="LINK_CLIENTE_PROJETOS" value="/cliente/lista" />

<jspView:page cabecalho="NAO" title="Menu de Opções">
	<div class="container">
		<h1>Menu</h1>
		<p>${mensagem_boasVindas}</p>
		<ul>
			<li><a href="${LINK_PROJETO_CADASTRO}">Cadastro de Projetos</a></li>
			<li><a href="${LINK_CRONOGRAMA_CADASTRO}">Cadastro de Cronogramas</a></li>
			<li><a href="${LINK_CLIENTE_DETALHE}">Detalhar projetos do Cliente</a></li>
			<li><a href="${LINK_CLIENTE_PROJETOS}">Listar todos os Clientes</a></li>
		</ul>
	</div>
</jspView:page>