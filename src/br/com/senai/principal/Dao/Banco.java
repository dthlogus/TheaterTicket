package br.com.senai.principal.Dao;

import br.com.senai.principal.modelo.Atracao;
import br.com.senai.principal.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    //Tabelas do banco
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Atracao> atracoes = new ArrayList<>();

    //ID's
    private static Integer idCliente = 1;
    private static Integer idAtracao = 1;


    // BANCO REFERENTE AO CLIENTE
    public void salvarCliente(Cliente cliente) {
        for (Cliente clienteLista: clientes) {
            if (clienteLista.getCpf().equals(cliente.getCpf())){
                System.out.println("Já existe um cliente com esse CPF");
                return;
            }
        }
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso");
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Integer index = 0; index < clientes.size(); index++){
            Cliente clienteBuscado = clientes.get(index);
            if(clienteBuscado.getCpf().equals(cpf)){
                return clienteBuscado;
            }
        }
        return null;
    }

    public void alterarClientePorId(Cliente cliente){
        for (Cliente clienteLista : clientes){
            if (clienteLista.equals(cliente)) {
                clientes.remove(clienteLista);
                clientes.add(cliente);
                System.out.println("Alteração feita com sucesso");
                return;
            }
        }
        System.out.println("Esse cliente não existe");
    }

    //BANCO REFERENTE AS ATRAÇÕES
    public void salvarAtracao(Atracao atracao){
        atracao.setId(idAtracao);
        atracoes.add(atracao);
    }

    public void mostrarTodasAsAtracoes(){
        for (Atracao atracao: atracoes) {
            System.out.println(atracao);
        }
    }

    public Atracao buscarAtracaoPorId(Integer id){
        for (Atracao atracao : atracoes) {
            if (atracao.getId().equals(id)){
                return atracao;
            }
        }
        return null;
    }

    public void alterarAtracao(Atracao atracao){
        for (Atracao atracaoLista : atracoes){
            if (atracaoLista.equals(atracao)) {
                atracoes.remove(atracaoLista);
                atracoes.add(atracao);
                return;
            }
        }
        System.out.println("Essa atração não existe");
    }

    public void excluirAtracao(Atracao atracao){
        for (Atracao atracaoLista : atracoes){
            if (atracaoLista.equals(atracao)) {
                atracoes.remove(atracaoLista);
                System.out.println("Excluido com sucesso");
                return;
            }
        }
        System.out.println("Essa atração não existe");
    }


}
