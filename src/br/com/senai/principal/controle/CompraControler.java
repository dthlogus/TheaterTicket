package br.com.senai.principal.controle;

import br.com.senai.principal.Banco.Banco;
import br.com.senai.principal.modelo.Atracao;
import br.com.senai.principal.modelo.Cliente;
import br.com.senai.principal.util.Uteis;

import java.util.Scanner;

public class CompraControler {
    private Banco banco = Banco.getInstance();
    private Boolean continuar = true;
    private Integer opcao;
    private Double valorTotal = 0.0;
    private int quantidadePoltrona = 0;
    private Cliente clienteDaCompra;
    private Atracao atracaoDaCompra;
    public Double valorAtracao = 0.0;

    private Scanner scan = new Scanner(System.in);

    public void iniciar() {
        opcao = 10000;
        System.out.println("******** COMPRA ********");
        if(!buscarPorCPF(scan)){
            return;
        }
        mostrarTodasAsAtracoes();
        selecionarPeça(scan);
        while (continuar) {
            System.out.println("Selecione o lugar ");
            System.out.println(" 1 - PLATEIA A");
            System.out.println(" 2 - PLATEIA B");
            System.out.println(" 3 - FRISAS");
            System.out.println(" 4 - CAMAROTE");
            System.out.println(" 5 - BALCÃO NOBRE");
            System.out.println(" 0 - Sair");
            try { // resolve o erro de parar o código ao digitar uma letra, o erro está sendo tratado no default.
                opcao = Integer.valueOf(scan.nextLine());
            } catch (Exception e) {
            }

            switch (opcao) {
                case 1:
                    plateiaA(scan);
                    break;
                case 2:
                    plateiaB(scan);
                    break;
                case 3:
                    frisa(scan);
                    break;
                case 4:
                    camarote(scan);
                    break;
                case 5:
                    balcaoNobre(scan);
                    break;
                case 0:
                    continuar = false;
                    somaTotal();
                    break;
                default:
                    System.out.println("Foi digitado algum número que não esteja no menu, letra ou palavra, por favor, digite novamente.\n");
                    continuar = true;
                    break;
            }
        }
        clienteDaCompra.getAtracaoCliente().get(atracaoDaCompra.getId()).setValorTotal(valorTotal);
        banco.adicionarCompra(clienteDaCompra, valorTotal, atracaoDaCompra);
        System.out.println("O valor total é: R$ " + valorTotal);


    }

    // O usuario vai colocar o CPF dele e com isso vai realizar uma procura no banco e motrar se está cadastrado.
    public boolean buscarPorCPF(Scanner scan) {
        Banco banco = Banco.getInstance();
        System.out.println("Informe o CPF: ");
        String cpf = scan.nextLine();
        Cliente cliente = banco.buscarClientePorCpf(cpf);
        clienteDaCompra = cliente;
        if (cliente == null) {
            System.out.println("Não existe esse CPF");
            iniciar();
            return false;
        }
        System.out.println(cliente);
        return true;
    }

    // Mostrar as peças cadastradas
    private void mostrarTodasAsAtracoes() {
        banco.mostrarTodasAsAtracoes();
    }

    // Vai pedir ao usuário selecionar a peça pelo ID e mostrar a quantidade de poltronas e os lugares das poltronas
    public Integer selecionarPeça(Scanner scan) {
        Integer id;
        Atracao atracao;
        System.out.println("Selecione a peça que deseja pelo ID: ");
        id = Integer.valueOf(scan.nextLine());
        atracao = banco.buscarAtracaoPorId(id);
        System.out.println("Quantidade da Plateia A: " + atracao.getPoltrona().getQtPlateiaA() + " -------Preço da poltrona: R$ 40,00");
        System.out.println("Quantidade da Plateia B: " + atracao.getPoltrona().getQtPlateiaB() + " -------Preço da poltrona: R$ 60,00");
        System.out.println("Quantidade da Frisa: " + atracao.getPoltrona().getQtFrisa() + " -------Preço da poltrona: R$ 80,00");
        System.out.println("Quantidade do Camarote: " + atracao.getPoltrona().getQtCamarote() + " -------Preço da poltrona R$ 120,00");
        System.out.println("Quantidade do Balcão Nobre: " + atracao.getPoltrona().getQtBalcaoNobre() + " -------Preço da poltrona: R$ 250,00");
        atracaoDaCompra = atracao;
        clienteDaCompra.adicionarAtracao(atracao);
        banco.alterarAtracao(atracao);
        return id;
    }

    private void plateiaA(Scanner scan) {
        Integer id = atracaoDaCompra.getId();
        Atracao atracao;
        int qtd = 0;
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)) {
            return;
        }
        System.out.println("Quantas poltronas deseja da Plateia A: ");
        qtd = Integer.valueOf(scan.nextLine());
        Double vp = 40.00 * qtd;
        if (atracao.getPoltrona().comprarPlateiaA(qtd)) {
            valorTotal += vp;
            atracao.setValorArrecadado(vp);
            clienteDaCompra.getAtracaoCliente().get(id).setQtPlateiaA(qtd);
            System.out.println("A compra de " + qtd + " plateia A deu: R$"+vp+"\n Atualmente a compra esta com R$"+valorTotal);
        }
    }

    private void plateiaB(Scanner scan) {
        Integer id = atracaoDaCompra.getId();
        Atracao atracao;
        int qtd = 0;
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)) {
            return;
        }
        System.out.println("Quantas poltronas deseja da Plateia B: ");
        qtd = Integer.valueOf(scan.nextLine());
        if (atracao.getPoltrona().comprarPlateiaB(qtd)) {
            Double vp = 60.00 * qtd;
            valorTotal += vp;
            atracao.setValorArrecadado(vp);
            clienteDaCompra.getAtracaoCliente().get(id).setQtPlateiaB(qtd);
            System.out.println("A compra de " + qtd + " plateia B deu: R$"+vp+"\n Atualmente a compra esta com R$"+valorTotal);
        }
    }

    private void frisa(Scanner scan) {
        Integer id = atracaoDaCompra.getId();
        Atracao atracao;
        int qtd = 0;
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)) {
            return;
        }
        System.out.println("Quantas poltronas deseja da Frisa: ");
        qtd = Integer.valueOf(scan.nextLine());
        if (atracao.getPoltrona().comprarFrisa(qtd)) {
            Double vp = 80.00 * qtd;
            valorTotal += vp;
            atracao.setValorArrecadado(vp);
            clienteDaCompra.getAtracaoCliente().get(id).setQtFrisa(qtd);
            System.out.println("A compra de " + qtd + " frisa deu: R$"+vp+"\n Atualmente a compra esta com R$"+valorTotal);
        }
    }

    private void camarote(Scanner scan) {
        Integer id = atracaoDaCompra.getId();
        Atracao atracao;
        int qtd = 0;
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)) {
            return;
        }
        System.out.println("Quantas poltronas deseja do Camarote: ");
        qtd = Integer.valueOf(scan.nextLine());
        if (atracao.getPoltrona().comprarCamarote(qtd)) {
            Double vp = 120.00 * qtd;
            valorTotal += vp;
            atracao.setValorArrecadado(vp);
            clienteDaCompra.getAtracaoCliente().get(id).setQtCamarote(qtd);
            System.out.println("A compra de " + qtd + " camarote deu: R$"+vp+"\n Atualmente a compra esta com R$"+valorTotal);
        }
    }

    private void balcaoNobre(Scanner scan) {
        Integer id = atracaoDaCompra.getId();
        Atracao atracao;
        int qtd = 0;
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)) {
            return;
        }
        System.out.println("Quantas poltronas deseja do Balcão Nobre: ");
        qtd = Integer.valueOf(scan.nextLine());
        if (atracao.getPoltrona().comprarBalcaoNobre(qtd)) {
            Double vp = 250.00 * qtd;
            valorTotal += vp;
            atracao.setValorArrecadado(vp);
            clienteDaCompra.getAtracaoCliente().get(id).setQtBalcaoNobre(qtd);
            System.out.println("A compra de " + qtd + " balcão nobre deu: R$"+vp+"\nAtualmente a compra esta com R$"+valorTotal);
        }
    }

    public Double somaTotal() {
        valorAtracao += valorTotal;
        return valorAtracao;
    }
}
