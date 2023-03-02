package br.com.americanas.helloworldservlet;

import br.com.americanas.helloworldservlet.operacao.Operacao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HistoricoServlet", value = "/historico")
public class HistoricoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        var operacoes = (List<Operacao>) session.getAttribute("historico_operacoes");
        if (operacoes == null) {
            operacoes = new ArrayList<>();
        }
        request.setAttribute("historico_operacoes", operacoes);
        request.getRequestDispatcher("/historico.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
