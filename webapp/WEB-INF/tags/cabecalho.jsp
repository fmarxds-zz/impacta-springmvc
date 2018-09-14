<c:url var="LINK_HOME" value="/" />
<c:url var="LINK_PROJETO" value="/projeto/cadastro" />
<c:url var="LINK_CRONOGRAMA" value="/cronograma/cadastro" />
<c:url var="LINK_CLIENTE_DETALHE" value="/cliente" />
<c:url var="LINK_CLIENTE_PROJETOS" value="/cliente/lista" />

<div class="navbar navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${LINK_HOME}">HOME</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${LINK_PROJETO}">Projetos</a></li>
				<li><a href="${LINK_CRONOGRAMA}">Cronogramas</a></li>
				<li><a href="${LINK_CLIENTE_DETALHE}">Clientes</a></li>
				<li><a href="${LINK_CLIENTE_PROJETOS}">Detalhes Cliente</a></li>
			</ul>
		</div>
	</div>
</div>