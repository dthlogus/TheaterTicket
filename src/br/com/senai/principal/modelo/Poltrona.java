package br.com.senai.principal.modelo;

public class Poltrona {

    private Integer id;
    private Integer qtPlateiaA;
    private Integer qtPlateiaB;
    private Integer qtFrisa;
    private Integer qtCamarote;
    private Integer qtBalcaoNobre;

    public void Poltrona(){
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

    public void comprarPlateiaA(Integer quantidade) {
        if ((this.qtPlateiaA - quantidade) < 0){
            System.out.println("Não pode ser feita essa compra, a quantidade de poltrona A fica abaixo de zero");
        }else{
            this.qtPlateiaA -= quantidade;
        }
    }

    public Integer getQtPlateiaB() {
        return qtPlateiaB;
    }

    public void comprarPlateiaB(Integer quantidade) {
        if ((this.qtPlateiaB - quantidade) < 0){
            System.out.println("Não pode ser feita essa compra, a quantidade de poltrona B fica abaixo de zero");
        }else{
            this.qtPlateiaB -= quantidade;
        }
    }

    public Integer getQtFrisa() {
        return qtFrisa;
    }

    public void comprarFrisa(Integer quantidade) {
        if ((this.qtFrisa - quantidade) < 0){
            System.out.println("Não pode ser feita essa compra, a quantidade de frisa fica abaixo de zero");
        }else{
            this.qtFrisa -= quantidade;
        }
    }

    public Integer getQtCamarote() {
        return qtCamarote;
    }

    public void comprarCamarote(Integer quantidade) {
        if ((this.qtCamarote - quantidade) < 0){
            System.out.println("Não pode ser feita essa compra, a quantidade de camarote fica abaixo de zero");
        }else{
            this.qtCamarote -= quantidade;
        }
    }

    public Integer getQtBalcaoNobre() {
        return qtBalcaoNobre;
    }

    public void comprarBalcaoNobre(Integer quantidade) {
        if ((this.qtBalcaoNobre - quantidade) < 0){
            System.out.println("Não pode ser feita essa compra, a quantidade de balcão nobre fica abaixo de zero");
        }else{
            this.qtBalcaoNobre -= quantidade;
        }
    }

    @Override
    public String toString() {
        String retorno = String.format("Quantidade de Poltronas A: %d \nQuantidade de Poltrona B: %d \nQuantidade de Frisa: %d \nQuantidade Camarote: %d\nQuantidade Balcão nobre: %d\n");
        return retorno;
    }
}