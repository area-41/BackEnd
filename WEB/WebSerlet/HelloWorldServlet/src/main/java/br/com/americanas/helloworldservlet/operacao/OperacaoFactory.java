package br.com.americanas.helloworldservlet.operacao;

public class OperacaoFactory {

    public static Operacao create(String simboloMatematico) {
        Operacao operacao;
        switch (simboloMatematico) {
            case "Soma":
                operacao = new SomaOperacao();
                break;
            case "Subtração":
                operacao = new SubtracaoOperacao();
                break;
            case "Multiplicação":
                operacao = new MultiplicacaoOperacao();
                break;
            case "Divisão":
                operacao = new DivisaoOperacao();
                break;
            default:
                throw new RuntimeException("Operação não permitida.");
        }
        return operacao;
    }
}
