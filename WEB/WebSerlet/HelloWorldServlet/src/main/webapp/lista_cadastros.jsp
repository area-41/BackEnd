<%--
  Created by IntelliJ IDEA.
  User: conta
  Date: 28/02/2023
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista de Cadastrados</title>
</head>
<body>
    <h1 align="center">Clientes cadastrados:</h1>
    <c:forEach items="${lista_cadastros}" var="cadastro">
        <h3 align="center"><c:out value="${cadastro}" /></h3>
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