package br.com.americanas.polotech.LogPro.aula5;


import java.util.Scanner;

public class ExercicioProva {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int colunas = 0;
        do {
            System.out.println("Informe o número de colunas (mínimo 5): ");
            colunas = scanner.nextInt();

            if (colunas >= 5) {

                int linhas = colunas;
                int mid = colunas / 2 + 1;
                int a = mid;
                int b = mid;
                int chave = 1;

                if(colunas % 2 == 0){
                    a -= 1;
                    linhas -= 1;
                }
                for(int i = 1; i <= linhas; i++){
                    for(int j = 1; j <= colunas; j++){
                        if(j <= a || j >= b)
                            System.out.print("*");
                        else{
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                    a -= chave;
                    b += chave;
                    if(a == 1){
                        chave = -1;
                    }
                }
            } else {
                System.out.println("É necessário informar um número maior ou igual a 5");
            }
        } while(colunas < 5);
    }
}
