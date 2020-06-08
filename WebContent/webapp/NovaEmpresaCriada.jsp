<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Status</title>
</head>
<body>
	<c:if test="${ not empty empresa}">
		<p>Empresa ${empresa}, cadastrada com sucesso!</p>
	</c:if>

	<c:if test="${empty empresa }">
		<p>Empresa não cadastrada!</p>
	</c:if>

	<script type="text/javascript">
		setTimeout(function redirecionar() {
			window.location.href = "/gerenciador/webapp/ListaEmpresa.jsp";
		}, 5000);
	</script>
</body>
</html>