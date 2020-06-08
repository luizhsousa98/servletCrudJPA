<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Empresa</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa}" method="post">

		<label value="Nome:" /> <br> <input type="text" name="nome">

		<label value="Data:" /><br> <input type="date" name="data">

		<input type="submit" name="cadastrar" value="Cadastrar" />
	</form>

</body>
</html>