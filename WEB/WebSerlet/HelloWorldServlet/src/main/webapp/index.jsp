<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Calculadora</title>
    </head>
    <body>
        <div align="center">
            <form action="calcular" method="post">
                <p><h2>Informe os números e selecione a operação: </h2></p>
                <p><input type="number" name="first" required>
                    <select name="operator">
                        <option value="Soma"> Soma </option>
                        <option value="Subtração"> Subtração </option>
                        <option value="Multiplicação"> Multiplicação </option>
                        <option value="Divisão"> Divisão </option>
                    </select>
                    <input type="number" name="second" required>
                </p>
                <p><input type="submit" value="Calcular"></p>
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