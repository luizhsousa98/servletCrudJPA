<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/alterarEmpresa" var="linkServletAlteraEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edital</title>
</head>
<body>

	<form action="${linkServletAlteraEmpresa}" method="post">

		<label value="Nome:" /> <br> <input type="text" name="nome" value="${empresa.nome}"/>

		<label value="Data:" /><br> <input type="date" name="data" value="<fmt:formatDate value="${empresa.data}"
					pattern="yyyy-MM-dd"/>"/>

		<label value="Codigo da Empresa:" /><br> <input type="hidden"
			name="id" value="${empresa.id }"> <input type="submit"
			value="Alterar" />

	</form>

</body>
</html>