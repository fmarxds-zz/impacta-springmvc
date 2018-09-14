<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="jspView" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="LINK_PROJETO_CADASTRAR" value="/projeto/cadastro" />

<jspView:page cabecalho="SIM" title="Cadastro de Projetos">
	<h3>${mensagem_erro}</h3>
	<h3 style="color: red;">${mensagem_status_cadastro}</h3>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<h3>Incluir novo Projeto</h3>
			<div class="form-horizontal">
				<form action="${LINK_PROJETO_CADASTRAR}" method="POST">
					<div class="form-group">
						<label for="idCliente" class="control-label col-sm-3">Selecione o cliente:</label>
						<div class="col-sm-9">
							<select id="idCliente" name="idCliente" class="form-control">
								<c:forEach items="${lista_clientes}" var="cliente">
									<option value="${cliente.idCliente}">${cliente.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="documento" class="control-label col-sm-3">Documento:</label>
						<div class="col-sm-9">
							<input type="text" id="documento" name="documento" class="form-control" required pattern="[0-9]*" />
						</div>
					</div>
					<div class="form-group">
						<label for="descricao" class="control-label col-sm-3">Descricacao:</label>
						<div class="col-sm-9">
							<input type="text" id="descricao" name="descricao" class="form-control" required />
						</div>
					</div>
					<div class="form-group">
						<label for="duracao" class="control-label col-sm-3">Duração:</label>
						<div class="col-sm-9">
							<input type="number" id="duracao" name="duracao" class="form-control" required />
						</div>
					</div>
					<div class="form-group">
						<label for="valor" class="control-label col-sm-3">Valor:</label>
						<div class="col-sm-9">
							<input type="text" id="valor" name="valor" class="form-control" required pattern="[0.00-9.00]*" />
						</div>
					</div>
					<div class="form-group">
						<input type="submit" value="Incluir" class="btn btn-info" />
					</div>
				</form>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</jspView:page>