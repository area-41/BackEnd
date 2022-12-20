package br.com.americanas.polotech.LogPro.aula2;

import java.util.Scanner;

public class EstruturaControle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informa sua idade: ");
        int idade = sc.nextInt();
        boolean isMaiorIdade = idade >= 18;

        if (isMaiorIdade) {
            System.out.println("Você é maior de idade. ");
        } else if (idade<10){
            System.out.println("Você é uma criança");
        } else {
            System.out.println("Você é menor de idade.");
        }

        String mensagem = isMaiorIdade ? "Você é maior de idade 2." : "Você é menor de idade 2.";
        System.out.println(mensagem);


        System.out.println("Escreva o dia da semana (0-7):");

        int diaSemana = sc.nextInt();
        switch (diaSemana) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terco");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sabado");
                break;
            default:
                System.out.println("Valor inválido.");
        }

        sc.close();
    }
}
