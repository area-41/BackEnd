package br.com.americanas.polotech.ProOri_02.IPhone;

public class IPhone9 implements IPhone {
    @Override
    public String exibirDetalhes() {

        return "I Phone 9";
    }
}

//        IPhoneFactory iPhoneX = new IPhoneFactory("I Phone X", 15, 8, 24, BigDecimal.valueOf(7000.0));
//        IPhoneFactory iPhone9 = new IPhoneFactory("I Phone 9", 17, 16, 48, BigDecimal.valueOf(10000.0));
//        IPhoneFactory iPhone13Mini = new IPhoneFactory("I Phone 13 Mini", 13, 8, 24, BigDecimal.valueOf(5000.0));
//        System.out.printf("\nModelo :%s\n", iPhoneX);
//