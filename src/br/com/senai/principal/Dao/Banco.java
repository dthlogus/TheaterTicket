package br.com.senai.principal.Dao;

import br.com.senai.principal.modelo.Atracao;
import br.com.senai.principal.modelo.Cliente;
import br.com.senai.principal.modelo.Compra;
import br.com.senai.principal.util.Horario;

import java.util.ArrayList;
import java.util.List;

public class Banco {

public static Banco instanciaBanco;

private Banco(){

}
//Instanciar o banco "singleton"
public static Banco getInstance(){
    if(instanciaBanco != null){
        return instanciaBanco;
    }else {
        instanciaBanco = new Banco();
        return instanciaBanco;
    }
}
    //Tabelas do banco
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Atracao> atracoes = new ArrayList<>();
    private static List<Compra> compras = new ArrayList<>();

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
        if(atracoes.isEmpty()){
            System.out.println("Não existe atração cadastrada.");
            return;
        }
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
            if (atracaoLista.getId().equals(atracao.getId())) {
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

    // metodos Compra
    public Compra buscarCompraPorCpf(String cpf){
        if (compras.isEmpty()){
            System.out.println("Não foi efetuado nenhuma compra até o momento");
        }
        for (Compra compra : compras){
            if(compra.getCliente().getCpf().equals(cpf)){
                return compra;
            }
        }
        return null;
    }

    public void adicionarCompra(Cliente cliente, Double valorTotal, Atracao atracao){
        Compra compra = buscarCompraPorCpf(cliente.getCpf());
        if (compra == null){
            compra.setCliente(cliente);
            compra.setValorTotal(valorTotal);
            compra.adiconarAtracao(atracao);
            compras.add(compra);
            return;
        }
        compra.setValorTotal(valorTotal);
        compra.adiconarAtracao(atracao);
        return;
    }

    //iniciando estatisticas

    //Decidindo a maior e menor bilheteria
    public void estatisticasQntMaisVendidos(){
        Atracao maiorBilheteria = atracoes.get(0);
        Atracao menorBelheteria = atracoes.get(0);

        for(Atracao atracao : atracoes){
            //decidindo a menor bilheteria
             if(atracao.getPoltrona().getQntTotal() < menorBelheteria.getPoltrona().getQntTotal()){
                 menorBelheteria = atracao;
             }
            //decidindo a maior bilheteria
             if(atracao.getPoltrona().getQntTotal() > maiorBilheteria.getPoltrona().getQntTotal()){
                 maiorBilheteria = atracao;
             }
        }
        System.out.println("A menor bilheteria é: " + menorBelheteria);
        System.out.println("A maior bilheteria é: " + maiorBilheteria);
    }

    public void estatisticaPoltronasOcupadas(){
        Atracao menorOcupacao = atracoes.get(0);
        Atracao maiorOcupacao = atracoes.get(0);

        for(Atracao atracao : atracoes){
            //Decidindo a peça com menor Quantidade de Poltronas reservadas
            if(atracao.getPoltrona().getQntTotal() < menorOcupacao.getPoltrona().getQntTotal()){
                menorOcupacao = atracao;
            }
            //Decidindo a peça com maior Quantidade de Poltronas reservadas
            if (atracao.getPoltrona().getQntTotal() > maiorOcupacao.getPoltrona().getQntTotal()){
                maiorOcupacao = atracao;
            }
        }

        System.out.println(menorOcupacao);
        System.out.println(maiorOcupacao);
    }

}
