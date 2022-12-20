package br.com.americanas.polotech.LogPro.aula5;

public class TesteCarro {
    public static void main(String[] args) {
        System.out.println("Carros produzidos: " + Carro.numeroDeCarros);

        Carro carrinho = new Carro();
        carrinho.cor = "Preto";
        carrinho.modelo = "Celta";
        carrinho.ano = "2006";
        carrinho.isAutomatico = false;

        Carro carrinho2 = new Carro();
        carrinho2.cor = "Branco";
        carrinho2.modelo = "Palio";
        carrinho2.ano = "2009";
        carrinho2.isAutomatico = false;



        System.out.println("O meu carro " + carrinho.modelo);
        System.out.println("O meu carro " + carrinho2.modelo);
        System.out.println("Carros produzidos: " + Carro.numeroDeCarros);
    }
}
