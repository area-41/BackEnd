package br.com.americanas.polotech.LogPro.aula4;

public class StringUtils {
    public static String formatarNome(String nome) {
        /*
        */
        String[] arrayString = nome.split(" ");
        String nomeCorreto = "";
        for(String parteNome : arrayString){
            nomeCorreto += formatarPalavra(parteNome) + "";
        }
        return nomeCorreto;

    }

    public static String formatarPalavra(String palavra){

        String nomeCorreto = palavra.substring(0, 1).toUpperCase() + palavra.substring(1).toLowerCase();
        return nomeCorreto;
    }
}
