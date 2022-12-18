package br.com.americanas.polotech.Projeto2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Twitt {

    static Usuario usuario = new Usuario();

    public static String[] criarTwitt(String[] twitts){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva o que esta pensando: ");
        usuario.twitt = scanner.nextLine();
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formaterData = DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm |");
        usuario.nome = Main.usuario.nome;
        System.out.printf("%s -> Twitt publicado por %s: %s\n",(data.format(formaterData)), (usuario.nome), (usuario.twitt));

        // adiciona um espaco no array e coloca o usuario
        int n = twitts.length;
        String[] tempTwitt = new String[n+1];
        for (int i =0; i< n; i++) {
            tempTwitt[i] = twitts[i];
        }

        tempTwitt[n] = data.format(formaterData)+";"+Main.usuario.nome+"; Twittou: "+usuario.twitt;
        twitts = tempTwitt;

        return twitts;
    }

    public static String[] imprimirTwitts(String[] twitts) {
        for (String twitt : twitts) {
            String[] elementoSplit = twitt.split(";");
            System.out.println("Data:" + elementoSplit[0] + " Usuário: " + elementoSplit[1] + " " + elementoSplit[2]);
        }
        return twitts;
    }

    public static String[] imprimirTwittsIndividual(String[] twitts) {
        for (String twitt : twitts) {
            String[] elementoSplit = twitt.split(";");
            String usuarioTwitter =  elementoSplit[1];
            if (usuarioTwitter.equals(Main.usuario.nome)){
                System.out.println("Data:" + elementoSplit[0] + " Usuário: " + elementoSplit[1] + " " + elementoSplit[2]);
            }
        }
        return twitts;
    }
}
