<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Altera Empresa JSP</title>
</head>
<body>

<c:import url="logout-parcial.jsp" />

	<form action="${linkEntradaServlet}" method="post">
	
		Nome:
		<input
				type="text"
				name="nome"
				value="${empresa.nome}"
		/>
		Data Abertura
		<input
				type="text"
				name="data"
				value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"
		/>
		<input
				type="text"
				name="id"
				value="${empresa.id}"
				hidden="true"
		/>
		<input
				type="hidden"
				name="acao"
				value="AlteraEmpresa"

		/>
		<input
				type="submit"
		/>

	</form>

</body>
</html>