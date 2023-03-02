package br.com.americanas.helloworldservlet.cadastro;

import java.math.BigDecimal;

public class CadastroD implements Cadastro {
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
        return "Cliente tipo D";
    }

    @Override
    public String toString() {
        String TIPO_D = "D";
        return "Nome: " + nome + " CPF: " + cpf + " Tipo: " + TIPO_D + "Codigo: " + codigo;
    }
}
