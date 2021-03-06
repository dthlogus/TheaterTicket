package br.com.senai.principal.controle;

import br.com.senai.principal.Banco.Banco;
import br.com.senai.principal.modelo.Cliente;
import br.com.senai.principal.util.Uteis;

import java.util.Scanner;

public class ClienteControler {

    private Boolean continuar = true;
    private Integer opcao;
    private Scanner scan = new Scanner(System.in);

    public void iniciar() {
        while (continuar) {
            opcao = 10000;
            System.out.println("Digite em número, qual opcão você deseja");
            System.out.println("1. Cadastrar o Cliente");
            System.out.println("2. Buscar o Cliente pelo CPF");
            System.out.println("0. Sair");
            try { // resolve o erro de parar o código ao digitar uma letra, o erro está sendo tratado no default.
                opcao = Integer.valueOf(scan.nextLine());
            } catch (Exception e) {
            }

            switch (opcao) {
                case 1:
                    cadastrarCliente(scan);
                    break;
                case 2:
                    buscarPorCPF(scan);
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

    public void cadastrarCliente(Scanner scan) {

        String nome = "";
        String cpf = "";
        Cliente cliente = new Cliente();
        System.out.println("Digite o seu nome (Digite apenas letras por favor.)");
        nome = scan.nextLine();
        if (Uteis.validadorNomes(nome)) {
            System.out.println("Nome fora do padrão, por favor, tente novamente.\n");
            cadastrarCliente(scan);
            return;
        }
        System.out.println("Digite o seu cpf (Digite apenas números, e use os padrões 00000000000 ou 000.000.000-00)");
        cpf = scan.nextLine();
        if (Uteis.validadorCpf(cpf)) {
            System.out.println("cpf fora do padrão, por favor, tente novamente.\n");
            cadastrarCliente(scan);
            return;
        }
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        Banco banco = Banco.getInstance();
        banco.salvarCliente(cliente);
    }

    public void buscarPorCPF(Scanner scan) {
        Banco banco = Banco.getInstance();

        System.out.println("Digite o cpf que deseja buscar (Digite apenas números, e use os padrões 00000000000 ou 000.000.000-00)");
        String cpf = scan.nextLine();
        if (Uteis.validadorCpf(cpf)) {
            System.out.println("cpf fora do padrão, por favor, tente novamente.\n");
            buscarPorCPF(scan);
            return;
        }
        Cliente cliente = banco.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Não foi encontrado um cliente com esse cpf.");
            return;
        }
        System.out.println(cliente);
    }
}
