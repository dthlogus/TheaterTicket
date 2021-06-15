package br.com.senai.principal.modelo;

import br.com.senai.principal.util.Genero;
import br.com.senai.principal.util.Horario;

public class Atracao {

    private Integer id;
    private String nome;
    private String faixaEtaria;
    private Genero genero;
    private String diretor;
    private Horario horario;
    private Poltrona poltrona;

    public Atracao(){
        this.poltrona = new Poltrona();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Poltrona getPoltrona() {
        return this.poltrona;
    }

    @Override
    public String toString() {
        return "| ID: " + this.id + " | NOME DA PEÇA: " + this.nome + " | " + "|---- RECOMENDAÇÃO DE IDADE: " + this.faixaEtaria + " ANOS ---| GENERO: " + this.genero + " | " + "| DIRETOR: " + this.diretor + " |";
    }
}
