package br.com.americanas.polotech.LogPro.Projeto2;

import java.io.IOException;
import java.util.Scanner;

public class Login {
        static Usuario usuario = new Usuario();
    public static String dados(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nInsira o seu nome: ");
        usuario.nome = sc.nextLine();
        System.out.println("Insira sua senha: ");
        usuario.senha = sc.nextLine();

        return usuario.nome;
    }
    public static boolean logar(boolean chaveLogin) throws IOException {
        String[] usuarios = Main.usuarios;

        for (int i=0; i<=usuarios.length; i++){
            String[] elementoSplit = usuarios[i].split(";");
            String usuarioCadastro =  elementoSplit[0];
            String senhaCadastro = elementoSplit[1];
            if (usuario.nome.equals(usuarioCadastro)) {
                System.out.println("Usuário encontrado");
                if (usuario.senha.equals(senhaCadastro)) {
                    System.out.println("Senha Correta!");
                    return chaveLogin = true;
                } else {
                    System.out.println("Senha incorreta!");
                    return chaveLogin = false;
                }
            }
            if (i== usuarios.length-1){
                System.out.println("Usuário inexistente.");
                return chaveLogin = false;
            }
        }
        return chaveLogin;
    }
}
