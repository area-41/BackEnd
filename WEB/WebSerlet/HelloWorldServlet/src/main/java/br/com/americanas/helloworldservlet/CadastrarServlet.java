package br.com.americanas.helloworldservlet;

import br.com.americanas.helloworldservlet.cadastro.Cadastro;
import br.com.americanas.helloworldservlet.cadastro.CadastroFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CadastrarServlet", value = "/cadastrar")
public class CadastrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("name");
        BigDecimal cpf = new BigDecimal(request.getParameter("cpf"));
        String tipo = request.getParameter("tipo");

        Cadastro cadastro = CadastroFactory.create(tipo);
        var ficha = cadastro.execute(nome, cpf);
        var cadastros = recuperaCadastros(request);
        cadastros.add(cadastro);

        PrintWriter writer = response.getWriter();
        writer.println(cpf);

        request.setAttribute("ficha", ficha);
        request.setAttribute("tipo", tipo);
        request.getRequestDispatcher("/ficha.jsp").forward(request, response);

//        PrintWriter writer = response.getWriter();
//        writer.println("<html><body><h2>Cadastro realizado!</h2><br />" +
//                "<h3>Nome: " + nome + "</h3><br />" +
//                "<h3>CPF: " +  cpf +"</h3></body></html>");
    }

    private List<Cadastro> recuperaCadastros(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<Cadastro> cadastros = (List<Cadastro>) session.getAttribute("lista_cadastros");
        if (cadastros == null) {
            cadastros = new ArrayList<>();
            session.setAttribute("lista_cadastros", cadastros);
        }
        return cadastros;
    }

    public static String encriptCpf(BigDecimal cpf) throws NoSuchAlgorithmException {
        MessageDigest messageDigest =  MessageDigest.getInstance("SHA-256");
        messageDigest.update(cpf.byteValue());
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }
}
