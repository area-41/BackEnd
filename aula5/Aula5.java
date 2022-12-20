package br.com.americanas.polotech.LogPro.aula5;

import java.util.Scanner;

public class Aula5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Qual o nome do contato?");
//        String nome = scanner.nextLine();

        Contato primeiroContato = new Contato();
        primeiroContato.nome = "Rodolfo";
        primeiroContato.telefone = "9989-9889";

        Contato[] contatos = new Contato[3];
        /*
        int contador = 0;
        while (contatos[contador] == null && contador < contatos.length) {
            System.out.println("Qual o nome do contato?");
            String nome = scanner.nextLine();
            contatos[contador] = nome;
            contador++;
        }

        */
        System.out.println(primeiroContato.nome);
        System.out.println(primeiroContato.telefone);

        for (int i = 0; i < contatos.length; i++) {

            System.out.println("Qual o nome do contato?");
            String nomeInformado = scanner.nextLine();
            System.out.println("Qual o telefone do contato?");
            String telefoneInformado = scanner.nextLine();

            Contato contato = new Contato();
            contato.nome = nomeInformado;
            contato.telefone = telefoneInformado;

            if (contatos[i] == null) {
                contatos[i] = contato;

            }
        }

        for(Contato contato : contatos) {
            System.out.println("Nome: " + contato.nome);
            System.out.println("Telefone: " + contato.telefone);
        }

    }
}
