package br.com.americanas.polotech.LogPro.aula4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recursividade_Fibonacci {
    public static void main(String[] args) {

        while (true) {
            int respostaMenu = menu();
            System.out.printf("Os %s da escala Fibonacci: %s",respostaMenu, fib(respostaMenu));
            System.out.println();

        }
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantas termos da escala Fibonacci deseja?");
        int n = sc.nextInt();
        return n;
    }

    public static List fib(int respostaMenu) {
        int ultimo = 1, penultimo = 1;

        // Object[] objetoQueaceitatudo = new Object[];
        List<Integer> fibonacci = new ArrayList<Integer>();
        fibonacci.add(0,0);
        fibonacci.add(1,1);
        fibonacci.add(2,1);

        if (respostaMenu == 1 || respostaMenu == 2) {
            System.out.println(1);
        } else {
            int count = 4;
            while (count<= respostaMenu) {
                int termo = ultimo + penultimo;
                fibonacci.add(termo);
                penultimo = ultimo;
                ultimo = termo;
                count += 1;
            }
        }

        return fibonacci;
    }
}
