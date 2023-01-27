package br.com.americanas.polotech.ProOri_02.IPhone;

import java.math.BigDecimal;

public class IPhoneFactory implements IPhone{

        private String modelo;
        private Integer tela;
        private Integer memoria;
        private Integer camera;
        private BigDecimal preco;

        public IPhoneFactory(String modelo, Integer tela, Integer memoria, Integer camera, BigDecimal preco) {
            this.modelo = modelo;
            this.tela = tela;
            this.memoria = memoria;
            this.camera = camera;
            this.preco = preco;
        }

    @Override
    public String toString() {
        return "I-Phone{ " +
                "modelo: " + modelo +
                "| tela: " + tela +
                "| memoria: " + memoria +
                "| camera: " + camera +
                "| preco: " + preco +
                '}';
    }

    public IPhoneFactory() {
    }

    @Override
        public void exibirDetalhes() {
            IPhoneFactory iPhoneFactory = new IPhoneFactory();
            for (TypeIPhoneEnum typeIPhoneEnum : TypeIPhoneEnum.values()) {
                System.out.println(typeIPhoneEnum.toString());
            }

        }
}
