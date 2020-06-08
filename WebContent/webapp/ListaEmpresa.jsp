<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas Cadastradas</title>
</head>

<body>
	<!-- Acesso a classes que contém as informações e persistencia -->
	<jsp:useBean id="dao" class="br.com.gerenciador.dao.EmpresaDAO" />
	<jsp:useBean id="empresa" class="br.com.gerenciador.modelo.Empresa" />
	<label style="color: red;"> Lista de empresas: </label>
	<br>


	<ul>
		<c:forEach items="${dao.listar}" var="empresa">
			<li>${empresa.nome} - <fmt:formatDate value="${empresa.data}"
					pattern="yyyy-MM-dd"/>
				<a href="/gerenciador/editaEmpresa?id=${empresa.id}">editar</a>
				<a href="/gerenciador/removeEmpresa?id=${empresa.id}">remove</a>
			</li>
		</c:forEach>

	</ul>

</body>
</html>