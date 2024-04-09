package br.com.americanas.polotech.ProOri_02.IPhone;

import java.util.*;

public class Main {
    /**
     * @author Victor Marques
     * @result Lista com os tipos de IPhones da loja.
     */
    public static void main(String[] args) {

        IPhoneFactory iPhoneFactory = new IPhoneFactory();
        System.out.printf("1 Telefone -> %s\n", iPhoneFactory.cadastrarIPhone(TypeIPhoneEnum.IPHONE_9).exibirDetalhes());
        System.out.printf("2 Telefone -> %s\n", iPhoneFactory.cadastrarIPhone(TypeIPhoneEnum.IPHONE_X).exibirDetalhes());
        System.out.printf("3 Telefone -> %s\n", iPhoneFactory.cadastrarIPhone(TypeIPhoneEnum.IPHONE_13_MINI).exibirDetalhes());
        
        List<IPhone> listaIPhones = new ArrayList<>();
        listaIPhones.add(iPhoneFactory.cadastrarIPhone(TypeIPhoneEnum.IPHONE_9));
        listaIPhones.add(iPhoneFactory.cadastrarIPhone(TypeIPhoneEnum.IPHONE_X));
        listaIPhones.add(iPhoneFactory.cadastrarIPhone(TypeIPhoneEnum.IPHONE_13_MINI));
//
        System.out.println("\nLista de I-Phones disponiveis na loja:");
        for (IPhone iphone : listaIPhones) {
            System.out.println(iphone.exibirDetalhes());
        }

        System.out.printf("\nQuantidade de modelos na loja: %s modelo(s).\n", listaIPhones.size());
        
    }
}
