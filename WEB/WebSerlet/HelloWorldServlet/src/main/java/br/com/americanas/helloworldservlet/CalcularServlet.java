package br.com.americanas.helloworldservlet;

import br.com.americanas.helloworldservlet.operacao.Operacao;
import br.com.americanas.helloworldservlet.operacao.OperacaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CalcularServlet", value = "/calcular")
public class CalcularServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Integer first = Integer.valueOf(request.getParameter("first"));
//        Integer second = Integer.valueOf(request.getParameter("second"));
//
//        Integer calculo = first + second;

//        PrintWriter writer = response.getWriter();
//        writer.println("<html><body>O resultado da soma foi: " + calculo + "</body></html>");

//        request.setAttribute("result", result);
//        request.getRequestDispatcher("/result.jsp").forward(request, response);

//        BigDecimal result = operacao.execute(first, second);

        BigDecimal first = new BigDecimal(request.getParameter("first"));
        BigDecimal second = new BigDecimal(request.getParameter("second"));
        String operator = request.getParameter("operator");

        Operacao operacao = OperacaoFactory.create(operator);
        var result = operacao.execute(first, second);
        var operacoes = recuperaOperacoes(request);
        operacoes.add(operacao);

        request.setAttribute("result", result);
        request.setAttribute("operator", operator);
        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }

    private List<Operacao> recuperaOperacoes(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<Operacao> operacoes = (List<Operacao>) session.getAttribute("historico_operacoes");
        if (operacoes == null) {
            operacoes = new ArrayList<>();
            session.setAttribute("historico_operacoes", operacoes);
        }
        return operacoes;
    }
}
