package br.com.senai.principal.modelo;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private Cliente cliente;
    private List<Atracao> atracoes = new ArrayList<>();
    private Double valorTotal = 0.0;


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Atracao> getAtracoes() {
        return atracoes;
    }

    public void adiconarAtracao(Atracao atracao) {
        this.atracoes.add(atracao);
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
