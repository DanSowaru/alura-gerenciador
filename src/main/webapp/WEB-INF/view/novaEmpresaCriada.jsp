<%--<%--%>
<%--    //scriplet--%>
<%--    String nomeEmpresa = (String) request.getAttribute("empresa");--%>
<%--    System.out.println(nomeEmpresa);--%>
<%--%>--%>

<%--
Não precisa do código acima porque não usa mais <%=%> novaEmpresa %>
Agora tá pegando direto da Requisição
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

<c:import url="logout-parcial.jsp" />

<c:if test="${not empty empresa}">
 Empresa ${empresa} cadastrada com sucesso!
</c:if>

<c:if test="${empty empresa}">
 Nenhuma empresa cadastrada!
</c:if>

</body>
</html>

