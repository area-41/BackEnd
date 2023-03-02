package br.com.americanas.helloworldservlet.cadastro;

import java.math.BigDecimal;

public class CadastroA implements Cadastro {

    private String nome;
    private BigDecimal cpf;

    private String codigo;

    @Override
    public String execute(String nome, BigDecimal cpf) {
        this.nome = nome;
        this.cpf = cpf;
        codigo = String.format("%s%s", nome, cpf.toString());
        return codigo;
    }

    @Override
    public String tipo() {
        return "Cliente tipo A";
    }

    @Override
    public String toString() {
        String TIPO_A = "A";
        return "Nome: " + nome + " CPF: " + cpf + " Tipo: " + TIPO_A + "Codigo: " + codigo;
    }

}
