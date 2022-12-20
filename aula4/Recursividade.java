package br.com.americanas.polotech.LogPro.aula4;

import java.util.Random;

public class Recursividade {
    public static void main(String[] args) {
        int resultadoSoma = somar(1, 3);
        System.out.printf("Resultado da soma:%s \n", resultadoSoma);

        String nomeCorreto = StringUtils.formatarNome("r0d0lf0 FerReirA");
        System.out.println(nomeCorreto);

        int numeroAleatorio = numeroAleatorio(3);
        System.out.printf("O número escolhido foi o %S ", numeroAleatorio);

    }

    public static int somar(int numero1, int numero2) {
        int resultado = numero1 + numero2;
        //System.out.println(resultado);
        return resultado;
    }


    public static int numeroAleatorio(int numero) {
        System.out.print("Executando 1 vez.\n");
        Random random = new Random();
        int numeroAleatorio = random.nextInt(10);
        if (numeroAleatorio == numero) {
            System.out.println("Acertou o numero.");
            return numeroAleatorio;

        }
        return numeroAleatorio(numero);
    }

}
