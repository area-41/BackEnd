package br.com.americanas.polotech.Projeto2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
        static String[] usuarios = new String[0];
        static String[] twitts = new String[0];
        static boolean chaveLogin = false;
        static Usuario usuario = new Usuario();

    public static void main(String[] args) {

        String[] menu = {"Sair", "Cadastrar", "Login", "Twittar", "Imprimir Lista", "Timeline", "Timeline Individual"};
        boolean chave = true;
        Letreiro.letreiro();
        while (chave) {
            System.out.println("Digite uma das opções: ");
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("[%d] - %s%n", i, menu[i]);
            }
            try {
                Scanner sc = new Scanner(System.in);
                int value = sc.nextInt();
                switch (value) {
                    case 0 -> {
                        System.out.println("Sair\nAté mais tarde!!!");
                        chave = false;
                    }
                    case 1 -> {
                        System.out.println("--Cadastrar--");
                        usuarios = Usuario.criaUsuario(usuarios);
                    }
                    case 2 -> {
                        System.out.println("--Login--");
                        usuario.nome = Login.dados();
                        chaveLogin = Login.logar(chaveLogin);
                        if (chaveLogin) {
                            System.out.println("\n--->Logado");
                            usuario.nome = Login.usuario.nome;
                        }
                         else {
                            System.out.println("Acesso não permitido.");
                        }
                    }
                    case 3 -> {
                        System.out.println("--Twittar--");
                        if (chaveLogin) {
                            twitts = Twitt.criarTwitt(twitts);
                        } else {
                            System.out.println("Você precisa fazer o Login primeiro.");
                        }
                    }
                    case 4 -> {
                        System.out.println("--Imprimir Lista--");
                        for (int i = 0; i < usuarios.length; i++) {
                            String[] elementoSplit = Main.usuarios[i].split(";");
                            String usuarioCadastro = elementoSplit[0];
                            String senhaCadastro = elementoSplit[1];
                            System.out.println("Usuário: " + usuarioCadastro + " |-> senha com " + senhaCadastro.length() + " caracteres");
                        }
                    }
                    case 5 -> {
                        System.out.println("--Timeline--");
                        Twitt.imprimirTwitts(twitts);
                    }
                    case 6 -> {
                        System.out.println("--Timeline Individual--");
                        Twitt.imprimirTwittsIndividual(twitts);
                    }
                    default -> System.out.println("Opção numérica inválida");
                }
            }
            catch (RuntimeException e) {
                System.out.println("Valor inválido! ->" + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("------------");
            }
        }
    }
}
