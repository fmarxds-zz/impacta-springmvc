<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="title" required="true"%>
<%@ attribute name="cabecalho" required="true"%>
<%@ attribute name="extraScripts" fragment="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>${title}</title>
</head>
<body>
	<c:choose>
		<c:when test="${cabecalho == 'SIM'}">
			<%@ include file="/WEB-INF/tags/cabecalho.jsp"%>
			<p style="margin-top: 50px;">
			<jsp:doBody />
		</c:when>
		<c:otherwise>
			<jsp:doBody />
		</c:otherwise>
	</c:choose>
	<script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<jsp:invoke fragment="extraScripts" />
</body>
</html>