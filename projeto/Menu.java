package br.com.americanas.polotech.LogPro.projeto;

import java.io.IOException;
import java.util.Scanner;

public class Menu {


    public static boolean menu(boolean chave) {
        String[] menu = {"Cadastrar", "Login", "Twittar"};
        while (chave) {
            System.out.println("Digite uma das opções: ");
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("[%d] - %s%n", i, menu[i]);
            }
            try {
                Scanner sc = new Scanner(System.in);
                int value = sc.nextInt();
                switch (value) {
                    case 0:
                        System.out.println("Sair\nObrigado e até breve!!!");
                        chave = false;
                        break;
                    case 1:
                        System.out.println("--Cadastrar--");
                        Cadastro.cadastrar();
                        break;
                    case 2:
                        System.out.println("--Login--");
                        chave = Login.logar(chave);
                        System.out.println(chave);
                        if (chave) {
                            System.out.println("\n--->Logado");
                            break;
                        }
                        if (chave == false) {
                            System.out.println("nao permitido");
                        } else {
                            System.out.println("Erro");
                        }
                        break;
                    case 3:
                        System.out.println("--Twittar--");
                        if (chave) {
                            Twitt.twittar();
                        }
                        break;
                    default:
                        System.out.println("Opção numérica inválida");
                }
            } catch (RuntimeException e) {
                System.out.println("Valor inválido! ->" + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("------------");

            }
            return chave;
        }
    return chave;}
}