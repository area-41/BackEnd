package br.com.americanas.polotech.ProOri_02.IPhone;

public class IPhoneFactory {
    public IPhone cadastrarIPhone(TypeIPhoneEnum typeIPhoneEnum) {
        if (typeIPhoneEnum.equals(TypeIPhoneEnum.IPHONE_9)) {
            return new IPhone9();
        } else if (typeIPhoneEnum.equals(TypeIPhoneEnum.IPHONE_X)) {
            return new IPhone_X();
        } else if (typeIPhoneEnum.equals(TypeIPhoneEnum.IPHONE_13_MINI)) {
            return new IPhone_13_Mini();
        }
        return null;
    }
}
