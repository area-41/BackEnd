package br.com.americanas.helloworldservlet;

import br.com.americanas.helloworldservlet.operacao.Operacao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListaCadastroServlet", value = "/lista_cadastros")
public class ListaCadastroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        var cadastros = (List<Operacao>) session.getAttribute("lista_cadastros");
        if (cadastros == null) {
            cadastros = new ArrayList<>();
        }
        request.setAttribute("lista_cadastros", cadastros);
        request.getRequestDispatcher("/lista_cadastros.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
