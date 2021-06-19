package br.com.senai.principal.modelo;

import java.util.HashMap;
import java.util.Map;

public class Cliente {

    private String nome;
    private String cpf;
    private Map<Integer,AtracaoCliente> atracoesCliente = new HashMap<>();

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

    public void adicionarAtracao(Atracao atracao){
        AtracaoCliente atracaoCliente = new AtracaoCliente(atracao);
        atracoesCliente.put(atracao.getId(), atracaoCliente);
    }

    public Map<Integer, AtracaoCliente> getAtracaoCliente() {
        return atracoesCliente;
    }

    public void atracoesPoltronasCompradas(){
        for (Integer index = 1; index <= atracoesCliente.size(); index++){
            AtracaoCliente ac = atracoesCliente.get(index);
            System.out.println(ac.getAtracaoCompleta());
            String mensagem = "";
            if (ac.getQtPlateiaA() > 0){
               mensagem = mensagem.concat(" Poltronas na plateia A - " + ac.getQtPlateiaA());
            }
            if (ac.getQtPlateiaB() > 0){
                mensagem = mensagem.concat(" Poltronas na plateia B - " + ac.getQtPlateiaB());
            }
            if (ac.getQtFrisa() > 0){
                mensagem = mensagem.concat("Poltronas no frisa - " + ac.getQtFrisa());
            }
            if (ac.getQtCamarote() > 0){
                mensagem = mensagem.concat(" Poltronas no camarote - " + ac.getQtCamarote());
            }
            if (ac.getQtBalcaoNobre() > 0){
                mensagem = mensagem.concat(" Poltronas na Balcão nobre - " + ac.getQtBalcaoNobre());
            }
            mensagem = mensagem.concat("\n");
            System.out.println(mensagem);
        }
    }

    @Override
    public String toString() {
        return String.format("Nome do usuário: %s \nCPF do usuário: %s\n", this.nome, this.cpf);
    }
}
