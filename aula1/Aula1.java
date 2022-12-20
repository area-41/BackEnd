package br.com.americanas.polotech.LogPro.aula1;

public class Aula1 {

    public static void main(String[] args) {

        System.out.println("Hello World Polo Tech");

        String minhaPrimeiraVariavel = "STRING IMUTAVEL";

        System.out.println(minhaPrimeiraVariavel.toLowerCase() + " SQN");

        String segundaVariavel = new String("STRING imutavel");
        System.out.println(minhaPrimeiraVariavel.equals(segundaVariavel));


        byte b1 = 1;
        short s1 = 2;
        int i1 = 3;
        long l1 = 4;

        // boolean
        int numero4 = 1;
        int numero5 = 2;
        boolean isNumero4MaiorQueNumero5 = numero4 > numero5;
        System.out.println(isNumero4MaiorQueNumero5);

        double salario = 3000;
        int tempoEmpresa = 3;
        boolean isElegivelAumento = salario >= 3000 || tempoEmpresa >= 2;
        System.out.println(isElegivelAumento);

        // += -=
        int numero6 = 17;
        numero6 %= 3;
        numero6++;
        --numero6;
        System.out.println(numero6);


    }

    public static class HelloWorldTech {
        public static void main(String[] args) {
            System.out.println("Hello Word Tech");
        }
    }
}
