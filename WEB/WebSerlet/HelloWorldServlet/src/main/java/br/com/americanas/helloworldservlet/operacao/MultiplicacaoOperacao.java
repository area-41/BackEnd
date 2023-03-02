package br.com.americanas.helloworldservlet.operacao;

import java.math.BigDecimal;

public class MultiplicacaoOperacao implements Operacao {

    private BigDecimal first;
    private BigDecimal second;
    private BigDecimal result;

    @Override
    public BigDecimal execute(BigDecimal first, BigDecimal second) {
        this.first = first;
        this.second = second;
        result = first.multiply(second);
        return result;
    }

    @Override
    public String simboloMatematico() {
        return "multiplicação";
    }

    @Override
    public String toString() {
        return "Multiplicação: " + first + " * " + second + " = " + result;
    }
}
