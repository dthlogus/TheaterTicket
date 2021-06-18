package br.com.senai.principal.controle;

import br.com.senai.principal.Dao.Banco;
import br.com.senai.principal.modelo.Atracao;
import br.com.senai.principal.modelo.Cliente;
import br.com.senai.principal.util.Uteis;

import java.util.Scanner;

public class CompraControler {
    private Boolean continuar = true;
    private Integer opcao = 10000;
    private Double valorTotal = 0.0;

    private Scanner scan = new Scanner(System.in);

    public void iniciar() {
            System.out.println("******** COMPRA ********");
            buscarPorCPF(scan);
            mostrarTodasAsAtracoes();
            selecionarPeça(scan);
            while (continuar){
                System.out.println("Selecione o lugar ");
                System.out.println(" 1 - PLATEIA A" );
                System.out.println(" 2 - PLATEIA B");
                System.out.println(" 3 - FRISAS");
                System.out.println(" 4 - CAMAROTE");
                System.out.println(" 5 - BALCÃO NOBRE");
                System.out.println(" 0 - Sair");
                try {
                    opcao = Integer.valueOf(scan.nextLine());
                }catch(Exception e){
                }

                switch (opcao) {
                    case 1 :
                        plateiaA(scan);
                        System.out.println(valorTotal);
                        break;
                    case 2 :
                        plateiaB(scan);
                        break;
                    case 3 :
                        frisa(scan);
                        break;
                    case 4 :
                        camarote(scan);
                        break;
                    case 5 :
                        balcaoNobre(scan);
                        break;
                    case 0 :
                        continuar = false;
                        break;
                    default:
                        System.out.println("Foi digitado algum número que não esteja no menu, letra ou palavra, por favor, digite novamente.\n");
                        continuar = true;
                        break;
                }

            }System.out.println("O valor total é: R$ " + valorTotal);

    }
    // O usuario vai colocar o CPF dele e com isso vai realizar uma procura no banco e motrar se está cadastrado.
    public void buscarPorCPF(Scanner scan) {
        Banco banco = new Banco();

        System.out.println("Informe o CPF: ");
        String cpf = scan.nextLine();
        Cliente cliente = banco.buscarClientePorCpf(cpf);
        if (cliente == null){
            System.out.println("Não existe esse CPF");
            return;
        }
        System.out.println(cliente);

    }
    // Mostrar as peças cadastradas
    private void mostrarTodasAsAtracoes() {
        Banco banco = new Banco();
        banco.mostrarTodasAsAtracoes();
    }
    // Vai pedir ao usuário selecionar a peça pelo ID e mostrar a quantidade de poltronas e os lugares das poltronas
    public void selecionarPeça (Scanner scan) {
        Integer id;
        Banco banco = new Banco();
        Atracao atracao;
        System.out.println("Selecione a peça que deseja pelo ID: ");
        id = Integer.valueOf(scan.nextLine());
        atracao = banco.buscarAtracaoPorId(id);
        System.out.println(" Quantidade da Plateia A: " + atracao.getPoltrona().getQtPlateiaA() + " -------Preço da poltrona: R$ 40,00");
        System.out.println(" Quantidade da Plateia B: " + atracao.getPoltrona().getQtPlateiaB() + " -------Preço da poltrona: R$ 60,00");
        System.out.println(" Quantidade da Frisa: " + atracao.getPoltrona().getQtFrisa() + " -------Preço da poltrona: R$ 80,00");
        System.out.println(" Quantidade do Camarote: " + atracao.getPoltrona().getQtCamarote() + " -------Preço da poltrona R$ 120,00");
        System.out.println(" Quantidade do Balcão Nobre: " + atracao.getPoltrona().getQtBalcaoNobre() + " -------Preço da poltrona: R$ 250,00");

        banco.alterarAtracao(atracao);
    }
    private  void plateiaA (Scanner scan) {
        Integer id ;
        Banco banco= new Banco();
        Atracao atracao;
        int qtd = 0;
        System.out.println("Selecione a peça que deseja pelo ID: ");
        id = Integer.valueOf(scan.nextLine());
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)){
            return;
        }
        System.out.println("Quantas poltronas deseja da Plateia A: ");
        qtd = Integer.valueOf(scan.nextLine());
        if(atracao.getPoltrona().comprarPlateiaA(qtd)) {
            valorTotal += 40.00 * qtd;
        }
    }
    private  void plateiaB (Scanner scan) {
        Integer id ;
        Banco banco= new Banco();
        Atracao atracao;
        int qtd = 0;
        System.out.println("Selecione a peça que deseja pelo ID: ");
        id = Integer.valueOf(scan.nextLine());
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)){
            return;
        }
        System.out.println("Quantas poltronas deseja da Plateia B: ");
        qtd = Integer.valueOf(scan.nextLine());
        if(atracao.getPoltrona().comprarPlateiaB(qtd)){
            valorTotal += 60.00 * qtd;
        }
    }
    private  void frisa (Scanner scan) {
        Integer id ;
        Banco banco= new Banco();
        Atracao atracao;
        int qtd = 0;
        System.out.println("Selecione a peça que deseja pelo ID: ");
        id = Integer.valueOf(scan.nextLine());
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)){
            return;
        }
        System.out.println("Quantas poltronas deseja da Frisa: ");
        qtd = Integer.valueOf(scan.nextLine());
        if(atracao.getPoltrona().comprarFrisa(qtd)) {
            valorTotal += 80.00 * qtd;
        }
    }
    private  void camarote (Scanner scan) {
        Integer id ;
        Banco banco= new Banco();
        Atracao atracao;
        int qtd = 0;
        System.out.println("Selecione a peça que deseja pelo ID: ");
        id = Integer.valueOf(scan.nextLine());
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)){
            return;
        }
        System.out.println("Quantas poltronas deseja do Camarote: ");
        qtd = Integer.valueOf(scan.nextLine());
        if(atracao.getPoltrona().comprarCamarote(qtd)) {
            valorTotal += 120.00 * qtd;
        }
    }
    private void balcaoNobre(Scanner scan) {
        Integer id ;
        Banco banco= new Banco();
        Atracao atracao;
        int qtd = 0;
        System.out.println("Selecione a peça que deseja pelo ID: ");
        id = Integer.valueOf(scan.nextLine());
        atracao = banco.buscarAtracaoPorId(id);
        if (!Uteis.validarId(atracao)){
            return;
        }
        System.out.println("Quantas poltronas deseja do Balcão Nobre: ");
        qtd = Integer.valueOf(scan.nextLine());
        if(atracao.getPoltrona().comprarBalcaoNobre(qtd)){
            valorTotal += 250.00 * qtd;
        }
    }
}
