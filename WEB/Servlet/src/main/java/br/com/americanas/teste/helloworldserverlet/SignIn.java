package br.com.americanas.teste.helloworldserverlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignInServlet", value = "/signin")
public class SignIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Integer cpf = Integer.valueOf(request.getParameter("cpf"));



        PrintWriter writer = response.getWriter();
        writer.println("<html><body><h2>Cadastro realizado!</h2><br />" +
                "<h3>Nome: " + name + "</h3><br />" +
                "<h3>CPF: " +  cpf +"</h3></body></html>");
    }
}
