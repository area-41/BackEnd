<%--
  Created by IntelliJ IDEA.
  User: conta
  Date: 01/03/2023
  Time: 08:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ficha de Cadastro</title>
</head>
<body>
    <h1 align="center">Cadastro realizado!</h1>
    <h2 align="center">Cadastrado para o tipo:'${tipo}' com os dados: ${ficha}</h2>
    <h5 align="center">
        <a href="/app"> Calculadora | </a>
        <a href="/app/historico"> Historico | </a>
        <a href="cadastro.jsp"> Cadastrar | </a>
        <a href="/app/lista_cadastros"> Cadastros |</a>
        <a href="scope.jsp"> Scope</a>
    </h5>
</body>
</html>
