package br.com.senai.principal.controle;

import br.com.senai.principal.Banco.Banco;
import br.com.senai.principal.modelo.Compra;

import java.util.Scanner;

public class ReciboControle {
    private Boolean continuar = true;
    private Integer opcao;
    private Scanner scan = new Scanner(System.in);

    public void iniciar() {
        while (continuar) {
            opcao = 10000;
            System.out.println("Para impressão do recibo escolha uma opção:");
            System.out.println("1. Buscar Recibo:");
            System.out.println("0. Sair. ");

            try { // resolve o erro de parar o código ao digitar uma letra, o erro está sendo tratado no default.
                opcao = Integer.valueOf(scan.nextLine());
            } catch (Exception e) {
            }

            switch (opcao) {
                case 1:
                    buscarRecibo(scan);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Foi digitado algum número que não esteja no menu, letra ou palavra, por favor, digite novamente.\n");
                    continuar = true;
                    break;
            }
        }
    }

    private void buscarRecibo(Scanner scan) {
        System.out.println("Informe o seu CPF:");
        String cpf = scan.nextLine();
        Banco banco = Banco.getInstance();
        Compra compra = banco.buscarCompraPorCpf(cpf);
        if (compra == null) {
            System.out.println("Não existe compra.");
            return;
        }
        System.out.println(compra.getCliente());
        compra.getCliente().atracoesPoltronasCompradas();
    }
}
