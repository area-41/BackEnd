package br.com.americanas.polotech.Projeto2;

import java.util.Scanner;

public class Usuario {
    String nome;
    String senha;
    String twitt;

    public static String[] criaUsuario(String[] usuarios){
        Usuario usuario1 = new Usuario();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite o seu nome: ");
        usuario1.nome = scanner.nextLine();
        System.out.println("Digite a senha: ");
        usuario1.senha = scanner.nextLine();

        // adiciona um espaco no array e coloca o usuario
        int n = usuarios.length;
        String[] tempUsuario = new String[n+1];
        for (int i =0; i< n; i++) {
            tempUsuario[i] = usuarios[i];
        }
        tempUsuario[n] = usuario1.nome+";"+usuario1.senha;
        usuarios = tempUsuario;
        System.out.println("Usuário Cadastrado.");
        return usuarios;
    }
}
