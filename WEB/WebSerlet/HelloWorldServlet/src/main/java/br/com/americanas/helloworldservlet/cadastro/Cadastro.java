package br.com.americanas.helloworldservlet.cadastro;

import java.math.BigDecimal;

public interface Cadastro {

    String execute (String nome, BigDecimal cpf);

    String tipo();
}
