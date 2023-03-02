package br.com.americanas.helloworldservlet.cadastro;

import java.math.BigDecimal;

public class CadastroB implements Cadastro {

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
        return "Cliente tipo B";
    }

    @Override
    public String toString() {
        String TIPO_B = "B";
        return "Nome: " + nome + " CPF: " + cpf + " Tipo: " + TIPO_B + "Codigo: " + codigo;
    }
}
