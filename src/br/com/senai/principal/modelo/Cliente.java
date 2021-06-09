package br.com.senai.principal.modelo;

public class Cliente {

    private String nome;
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return String.format("Nome do usuário: %s \nCpf do usuário: %s\n",this.nome, this.cpf);
    }
}
