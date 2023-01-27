package br.com.americanas.polotech.ProOri_02.IPhone;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    /**
     * @author Victor Marques
     * @result Lista com os tipos de IPhones da loja.
     */
    public static void main(String[] args) {

        IPhoneFactory iPhoneX = new IPhoneFactory("I Phone X", 15, 8, 24, BigDecimal.valueOf(7000.0));
        IPhoneFactory iPhone9 = new IPhoneFactory("I Phone 9", 17, 16, 48, BigDecimal.valueOf(10000.0));
        IPhoneFactory iPhone13Mini = new IPhoneFactory("I Phone 13 Mini", 13, 8, 24, BigDecimal.valueOf(5000.0));
        System.out.printf("\nModelo :%s\n", iPhoneX);

        List<IPhoneFactory> listaIPhones = new ArrayList<>();
        listaIPhones.add(iPhoneX);
        listaIPhones.add(iPhone9);
        listaIPhones.add(iPhone13Mini);

        System.out.println("\nLista de I-Phones disponiveis na loja:\n");
        for (IPhoneFactory iphone : listaIPhones) {
            System.out.println(iphone);
        }

//        Collections.sort(listaIPhones);


    }
}
