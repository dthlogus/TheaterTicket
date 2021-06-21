package br.com.senai.principal.modelo;

import br.com.senai.principal.util.FaixaEtaria;
import br.com.senai.principal.util.Genero;
import br.com.senai.principal.util.Horario;

public class AtracaoCliente {

    private String nome;
    private FaixaEtaria faixaEtaria;
    private Genero genero;
    private String diretor;
    private Horario horario;
    private Integer qtPlateiaA = 0;
    private Integer qtPlateiaB = 0;
    private Integer qtFrisa = 0;
    private Integer qtCamarote = 0;
    private Integer qtBalcaoNobre = 0;
    private Double valorTotal = 0.00;


    public AtracaoCliente(Atracao atracao){
        this.nome = atracao.getNome();
        this.faixaEtaria = atracao.getFaixaEtaria();
        this.genero = atracao.getGenero();
        this.diretor = atracao.getDiretor();
        this.horario = atracao.getHorario();
    }


    public String getNome() {
        return nome;
    }

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public Horario getHorario() {
        return horario;
    }

    public String getAtracaoCompleta(){
        return "| NOME DA PEÇA: " + this.nome + " | " + "|---- RECOMENDAÇÃO DE IDADE: " + this.faixaEtaria + " ANOS ---| GENERO: " + this.genero + " | " + "| DIRETOR: " + this.diretor + " |"+ "| HORARIO: " + this.horario + " |";
    }

    public Integer getQtPlateiaA() {
        return qtPlateiaA;
    }

    public void setQtPlateiaA(Integer qtPlateiaA) {
        this.qtPlateiaA += qtPlateiaA;
    }

    public Integer getQtPlateiaB() {
        return qtPlateiaB;
    }

    public void setQtPlateiaB(Integer qtPlateiaB) {
        this.qtPlateiaB += qtPlateiaB;
    }

    public Integer getQtFrisa() {
        return qtFrisa;
    }

    public void setQtFrisa(Integer qtFrisa) {
        this.qtFrisa += qtFrisa;
    }

    public Integer getQtCamarote() {
        return qtCamarote;
    }

    public void setQtCamarote(Integer qtCamarote) {
        this.qtCamarote += qtCamarote;
    }

    public Integer getQtBalcaoNobre() {
        return qtBalcaoNobre;
    }

    public void setQtBalcaoNobre(Integer qtBalcaoNobre) {
        this.qtBalcaoNobre += qtBalcaoNobre;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
