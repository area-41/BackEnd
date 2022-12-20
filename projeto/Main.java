package br.com.americanas.polotech.LogPro.projeto;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean chave = true;
        Scanner scanner = new Scanner(System.in);
        String[] nomes = {};
        String[] senhas = {};
        String[] twitts = {};

        String[] menuOptions = {"Cadastrar", "Login", "Twittar"};
        while (chave) {
            chave = menu(scanner, menuOptions, chave);
            System.out.println("-----");
        }
    }


    private static boolean menu(Scanner scanner, String[] menu, boolean chave) {

        int numero = -1;

        do {
            // pega as opcoes do array e imprime com a opcao 0
            System.out.println("Digite uma das opcoes: ");
            System.out.println("[0] - Sair");
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("[%d] - %s%n", i + 1, menu[i]);
            }

            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();

                if (numero < 0 || numero > menu.length) {
                    System.out.println("##### Opção Inválida! #####");

                }
                if (numero != 0) {
                    System.out.println("Você digitou: " + numero);
                    if (numero == 1) {
                        System.out.println("--CADASTRAR--");
                        cadastrar();
                        break;
                    }
                    if (numero == 2) {
                        System.out.println("--LOGAR--");
                        break;
                    }
                    if (numero == 3) {
                        System.out.println("--TWITTAR--");
                        break;
                    }
                }
                if (numero == 0) {
                    System.out.println("--SAIR--");
                    return (chave=false);
                }
            }
        } while (numero > 0 || numero > menu.length);

        return (chave);
    }

    public static String cadastrar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInsira o seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Insira uma senha: ");
        String senha = sc.nextLine();
        System.out.println("| - Usuário cadastrado! - |\n"+nome+"\tsenha: "+senha.length()+" caracteres");
        //escreverNoArquivo(nome, senha);
        return nome;
    }

}
