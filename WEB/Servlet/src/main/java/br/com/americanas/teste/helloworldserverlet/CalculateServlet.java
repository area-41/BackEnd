package br.com.americanas.teste.helloworldserverlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", value = "/calcular")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer first = Integer.valueOf(request.getParameter("first"));
        Integer second = Integer.valueOf(request.getParameter("second"));

        Integer calculo = first + second;

        PrintWriter writer = response.getWriter();
        writer.println("<html><body>O resultado da soma foi: " + calculo + "</body></html>");
    }
}
