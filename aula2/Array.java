package br.com.americanas.polotech.LogPro.aula2;

public class Array {
    public static void main(String[] args) {
        int contador = 0;
        int[] array = {1, 3, 5, 7, 8};

        for (int y = 0; y< array.length; y++) {
            System.out.println(array[y]);
        }

        do {
            System.out.println("Executou 1 vez"+" - Contador ->"+contador);
            contador++;
        } while (contador < 10);


        for (int inteiro: array) {
            System.out.println(inteiro);
        }
    }
}
