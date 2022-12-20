package br.com.americanas.polotech.LogPro.aula3;

public class Main {
    public static void main(String[] args) {
        int y = 10;
        int x = 0;
        /*
        boolean validator = true;

        for (;validator;) {
            System.out.println(--y);

            if(x == y) {
                validator= false;
            }
        }
        */
        int saldoUsuario = 5;
        int valorConta = 56;
        boolean usuarioCadatrado = true;

        while(usuarioCadatrado){
            System.out.println(--y + x++ + " da selecao " + (12 +32));
            usuarioCadatrado = y != x;
        }
    }
}
