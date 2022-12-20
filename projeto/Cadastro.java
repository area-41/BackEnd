package br.com.americanas.polotech.LogPro.projeto;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Cadastro {

    static Usuario usuario = new Usuario();

    public static String[] cadastrar() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInsira o seu nome: ");
        usuario.nome = sc.nextLine();
        System.out.println("Insira uma senha: ");
        usuario.senha = sc.nextLine();

        // PARA CONFIRMACAO DE SENHA ---
        boolean chave = true;
        while (chave) {
            System.out.println("Confirme sua senha: ");
            String senhaConfirmacao = sc.nextLine();
            if (usuario.senha.equals(senhaConfirmacao)) {
                System.out.println("ok");
                chave = false;
            } else {
                System.out.println("Senhas diferentes");
            }
        }


        System.out.println("| - Usuário cadastrado! - |");
        System.out.println("\tNome: "+usuario.nome+"\n\tSenha: "+usuario.senha.length()+" caracteres");
        String nome = usuario.nome;
        String senha = usuario.senha;
        String[] usuario = new String[]{nome, senha};
        //String[] senhas = {};
        //escreverNoArquivo(nome, senha);

        Cadastro.arquivar(usuario, TwitterADA.usuarios);
        return (usuario);
    }

    public static String[] arquivar(String[]usuario, String[]usuarios) {
        if (usuarios[0].equals("0")){

            int n = 0;
            String newUsuarios[] = new String[n+1];

            for (int i=0; i<n; i++)
                newUsuarios[i]= usuarios[i];

            newUsuarios[n]= Arrays.stream(usuario).toList().toString();
            //System.out.println(Arrays.stream(newUsuarios).toList());
            return TwitterADA.usuarios = newUsuarios;

        } else {
            int n = usuarios.length;
            String newUsuarios[] = new String[n+1];
            int i;
            for (i=0; i<n; i++)
                newUsuarios[i]= usuarios[i];

            newUsuarios[n]= Arrays.stream(usuario).toList().toString();
            //System.out.println(Arrays.stream(newUsuarios).toList());
            return TwitterADA.usuarios = newUsuarios;
        }
    }

/*
    private static String escreverNoArquivo(String nome, String senha) throws IOException {
        File arquivo = new File("usuarios.txt");
        if (arquivo.exists()) {
            FileReader arquivoLido = null;
            try {
                arquivoLido = new FileReader("usuarios.txt");
            } catch (FileNotFoundException e) {
                System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
                throw new RuntimeException(e);
            }
            BufferedReader lerArq = new BufferedReader(arquivoLido);

            lerArq.lines().forEach(System.out::println);

            String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
            while (linha != null) {
                System.out.printf("%s\n", linha);

                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arquivoLido.close();
        }

        return null;
    }
*/


}
