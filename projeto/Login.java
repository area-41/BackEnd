package br.com.americanas.polotech.LogPro.projeto;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Login {

    static String[] usuarios = TwitterADA.usuarios;

    public static boolean logar(boolean chaveLogin) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInsira o seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Insira sua senha: ");
        String senha = sc.nextLine();
        for (int i=0; i<usuarios.length; i++){
            System.out.println("Aqui" + Arrays.toString(usuarios));
            String[] nomes = Arrays.toString(usuarios).split(",");
            StringBuilder usuarioCadastro = new StringBuilder(nomes[0]);
            //String nomeBase = nomes[0].toString();
            StringBuilder senhaCadastro = new StringBuilder(nomes[1]);
            usuarioCadastro = usuarioCadastro.deleteCharAt(0);
            System.out.println("usuario:" + usuarioCadastro);
            senhaCadastro = senhaCadastro.deleteCharAt(0).deleteCharAt(senhaCadastro.length() - 1);
            System.out.println("Senha: " + senhaCadastro.length());
            if (nome.equals(usuarioCadastro.toString())) {
                System.out.println("Usuário encontrado");
                if (senha.equals(senhaCadastro.toString())) {
                    System.out.println("Senha Correta!");
                    chaveLogin = true;
                    return chaveLogin;
                } else {
                    System.out.println("Senha incorreta!");
                    break;
                }
            } else {
                System.out.println("Usuário inexistente.");
                break;
            }

        }
        for (String usuario : usuarios) {
        }
        return chaveLogin;
    }
}
