package br.com.americanas.polotech.LogPro.aula2;

import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {

        try {
            Scanner sc =new Scanner(System.in);
            System.out.println("Qual a posicao:");
            int posicao = sc.nextInt();
            int array[] = new int[1];
            array[0] = 1;

            String texto = null;
            System.out.println(texto);

        } catch (RuntimeException e) {
            System.out.println("Valor invalido." + e.getMessage());
        } finally {
            System.out.println("Texto final.");

        }
    }
}
