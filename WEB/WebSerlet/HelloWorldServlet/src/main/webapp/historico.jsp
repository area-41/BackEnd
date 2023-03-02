<%--
  Created by IntelliJ IDEA.
  User: conta
  Date: 27/02/2023
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Historico de operações</title>
</head>
<body>
  <h1 align="center">Operações realizadas foram:</h1>
    <c:forEach items="${historico_operacoes}" var="operacao">
      <h3 align="center"><c:out value="${operacao}"/></h3>
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