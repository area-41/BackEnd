package br.com.americanas.polotech.LogPro.aula1;
import java.util.Scanner;

public class Aula1Estudo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero por favor: ");
        int numero = sc.nextInt();

        System.out.println("Digite uma palavra por favor: ");
        String palavra = sc.next();

        System.out.println("e agora digite um numero com decimais, por favor: ");
        float numeroDecimal = sc.nextFloat();

        System.out.println("outro numero com decimais, por favor: ");
        double numeroDecimalDouble = sc.nextDouble();

        System.out.printf("A sua palavra: %s, o numero: %s e o decimal(float): %s em comparacao com o decimal(double): %s",
                (palavra), (numero), (numeroDecimal), (numeroDecimalDouble));

    }
}
