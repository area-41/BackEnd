<%--
  Created by IntelliJ IDEA.
  User: conta
  Date: 22/02/2023
  Time: 08:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro ADA</title>
    </head>
    <body>
    <div align="center">
        <form action="cadastrar" method="post">
            <p>Informe o NOME: <input type="text" name="name" required></p>
            <p>Informe o CPF: <input type="number" name="cpf" required></p>
            <p>Tipo de conta:
                <select name="tipo">
                    <option value="A">Cliente A</option>
                    <option value="B">Cliente B</option>
                    <option value="C">Cliente C</option>
                    <option value="D">Cliente D</option>
                </select>
            </p>
            <p><input type="submit" value="Cadastrar"></p>
        </form>
        <h5 align="center">
            <a href="/app"> Calculadora | </a>
            <a href="/app/historico"> Historico | </a>
            <a href="cadastro.jsp"> Cadastrar | </a>
            <a href="/app/lista_cadastros"> Cadastros |</a>
            <a href="scope.jsp"> Scope</a>
        </h5>
    </div>

</body>
</html>
