package br.com.americanas.helloworldservlet.operacao;

import java.math.BigDecimal;

public class DivisaoOperacao implements Operacao {

    private BigDecimal first;
    private BigDecimal second;
    private BigDecimal result;

    @Override
    public BigDecimal execute(BigDecimal first, BigDecimal second) {
        this.first = first;
        this.second = second;
        result = first.divide(second);
        return result;
    }

    @Override
    public String simboloMatematico() {
        return "/";
    }

    @Override
    public String toString() {
        return "Divisão: " + first + " / " + second + " = " + result;
    }
}


