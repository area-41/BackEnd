package br.com.americanas.helloworldservlet.cadastro;


public class CadastroFactory {

    public static Cadastro create(String tipo) {
        Cadastro cadastro;
        switch (tipo) {
            case "A":
                cadastro = new CadastroA();
                break;
            case "B":
                cadastro = new CadastroB();
                break;
            case "C":
                cadastro = new CadastroC();
                break;
            case "D":
                cadastro = new CadastroD();
                break;
            default:
                throw new RuntimeException("Opção inválida.");
        }
        return cadastro;
    }
}
