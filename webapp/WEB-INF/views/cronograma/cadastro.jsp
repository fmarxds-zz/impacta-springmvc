<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="jspView" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="LINK_CRONOGRAMA_CADASTRAR" value="/cronograma/cadastro" />

<jspView:page cabecalho="SIM" title="Cadastro de Cronograma">
	<h3>${mensagem_erro}</h3>
	<h3 style="color: red;">${mensagem_status_cadastro}</h3>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<h3>Incluir novo Cronograma para Projeto</h3>
			<div class="form-horizontal">
				<form action="${LINK_CRONOGRAMA_CADASTRAR}" method="POST">
					<div class="form-group">
						<label for="idProjeto" class="control-label col-sm-3">Selecione o Projeto:</label>
						<div class="col-sm-9">
							<select id="idProjeto" name="idProjeto" class="form-control">
								<c:forEach items="${lista_projetos}" var="projeto">
									<option value="${projeto.idProjeto}">${projeto.documento}-${projeto.descricao}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="data" class="control-label col-sm-3">Data:</label>
						<div class="col-sm-9">
							<input type="date" id="data" name="data" class="form-control" required />
						</div>
					</div>
					<div class="form-group">
						<label for="duracao" class="control-label col-sm-3">Duração:</label>
						<div class="col-sm-9">
							<input type="number" id="duracao" name="duracao" class="form-control" required />
						</div>
					</div>
					<div class="form-group">
						<label for="descricao" class="control-label col-sm-3">Descricao:</label>
						<div class="col-sm-9">
							<input type="text" id="descricao" name="descricao" class="form-control" required />
						</div>
					</div>
					<!-- 				<div class="form-group"> -->
					<!-- 					<label for="concluido" class="control-label col-sm-3">Status:</label> -->
					<!-- 					<div class="col-sm-9"> -->
					<!-- 						<input type="text" id="concluido" name="concluido" class="form-control" required /> -->
					<!-- 					</div> -->
					<!-- 				</div> -->
					<div class="form-group">
						<input type="submit" value="Incluir" class="btn btn-info" />
					</div>
				</form>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</jspView:page>