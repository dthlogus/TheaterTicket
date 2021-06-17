package br.com.senai.principal.modelo;

public class Poltrona {

    private Integer id;
    private Integer qtPlateiaA;
    private Integer qtPlateiaB;
    private Integer qtFrisa;
    private Integer qtCamarote;
    private Integer qtBalcaoNobre;

    public Poltrona(){
        this.qtPlateiaA = 25;
        this.qtPlateiaB = 100;
        this.qtFrisa = 30;
        this.qtCamarote = 50;
        this.qtBalcaoNobre = 50;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtPlateiaA() {
        return qtPlateiaA;
    }

    public Boolean comprarPlateiaA(Integer quantidade) {
        if ((this.qtPlateiaA - quantidade) < 0){
            System.out.println("Não pode ser feita essa compra, a quantidade de poltrona A fica abaixo de zero");
            return false;
        }else{
            this.qtPlateiaA -= quantidade;
            return true;
        }
    }

    public Integer getQtPlateiaB() {
        return qtPlateiaB;
    }

    public Boolean comprarPlateiaB(Integer quantidade) {
        if ((this.qtPlateiaB - quantidade) < 0){
            System.out.println("Não pode ser feita essa compra, a quantidade de poltrona B fica abaixo de zero");
            return false;
        }else{
            this.qtPlateiaB -= quantidade;
            return true;
        }
    }

    public Integer getQtFrisa() {
        return qtFrisa;
    }

    public Boolean comprarFrisa(Integer quantidade) {
        if ((this.qtFrisa - quantidade) < 0){
            System.out.println("Não pode ser feita essa compra, a quantidade de frisa fica abaixo de zero");
            return false;
        }else{
            this.qtFrisa -= quantidade;
            return true;
        }
    }

    public Integer getQtCamarote() {
        return qtCamarote;
    }

    public Boolean comprarCamarote(Integer quantidade) {
        if ((this.qtCamarote - quantidade) < 0){
            System.out.println("Não pode ser feita essa compra, a quantidade de camarote fica abaixo de zero");
            return false;
        }else{
            this.qtCamarote -= quantidade;
            return true;
        }
    }

    public Integer getQtBalcaoNobre() {
        return qtBalcaoNobre;
    }

    public Boolean comprarBalcaoNobre(Integer quantidade) {
        if ((this.qtBalcaoNobre - quantidade) < 0){
            System.out.println("Não pode ser feita essa compra, a quantidade de balcão nobre fica abaixo de zero");
            return false;
        }else{
            this.qtBalcaoNobre -= quantidade;
            return true;
        }
    }

    @Override
    public String toString() {
        String retorno = String.format("Quantidade de Poltronas A: %d \nQuantidade de Poltrona B: %d \nQuantidade de Frisa: %d \nQuantidade Camarote: %d\nQuantidade Balcão nobre: %d\n",
                this.qtPlateiaA,this.qtPlateiaB,this.qtFrisa,this.qtCamarote,this.qtBalcaoNobre);
        return retorno;
    }
}
