<%--
  Created by IntelliJ IDEA.
  User: conta
  Date: 01/03/2023
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Informacoes do Scope</title>
</head>
<body>
<h1 align="center">Informações do Scope:</h1>
<h5 align="center">${sessionScope.values()}</h5>
<c:forEach items="${sessionScope}">
    <h3 align="center"><c:out value="${sessionScope.values()}" /></h3>
</c:forEach>

<h5 align="center">
    <a href="/app"> Calculadora | </a>
    <a href="/app/historico"> Historico | </a>
    <a href="cadastro.jsp"> Cadastrar | </a>
    <a href="/app/lista_cadastros"> Cadastros |</a>
    <a href="scope.jsp"> Scope</a>
</h5>

</body>
</html>
