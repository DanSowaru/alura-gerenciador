<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List, br.com.alura.aluragerenciador.modelo.Empresa" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--usa-se o prefixo c, de core, como consenso--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Java Standard Taglib</title>
</head>
<body>

<c:if test="${not empty empresa}">
    Empresa ${empresa} cadastrada com sucesso!
</c:if>

Lista de empresas: <br/>
<ul>
    <c:forEach items="${empresas}" var="empresa">
        <li>
                ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
            <a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
            <a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">edita</a>

        </li>
        <%--
                    A Expression Language acima executa sem o get e sem o (). Faz o mesmo que o abaixo:
                    <li>${empresa.getNome()}</li>
        --%>
    </c:forEach>
</ul>

<h1>OU</h1>

<ul>
    <%
        List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
        for (Empresa empresa : lista) {
    %>
    <li><%= empresa.getNome() %>
    </li>
    <%
        }
    %>
</ul>

</body>
</html>