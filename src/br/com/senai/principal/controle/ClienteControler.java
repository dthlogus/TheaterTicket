package br.com.senai.principal.controle;

import br.com.senai.principal.Dao.Banco;
import br.com.senai.principal.modelo.Cliente;

import java.util.Scanner;

public class ClienteControler {

    private Boolean continuar = true;
    private Integer opcao = 0;
    private Scanner scan = new Scanner(System.in);

    public void iniciar(){
        while(continuar){
            System.out.println("Digite em número, qual opcão você deseja");
            System.out.println("1. Salvar o Cliente");
            System.out.println("2. Buscar o Cliente pelo CPF");
            System.out.println("0. Sair");
            opcao = Integer.valueOf(scan.nextLine());

            switch (opcao){
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
                    continuar = true;
                    break;
            }
        }

    }

    public void cadastrarCliente(Scanner scan) {

        String nome = "";
        String cpf = "";
        Cliente cliente = new Cliente();

        System.out.println("Digite o seu nome");
        nome = scan.nextLine();

        System.out.println("Digite o seu cpf");
        cpf = scan.nextLine();

        cliente.setNome(nome);
        cliente.setCpf(cpf);
        Banco banco = new Banco();
        banco.salvarCliente(cliente);
    }

    public void buscarPorCPF(Scanner scan){
        Banco banco = new Banco();

        System.out.println("Digite o cpf que deseja buscar");
        String cpf = scan.nextLine();

        Cliente cliente = banco.buscarClientePorCpf(cpf);
        System.out.println(cliente);
    }
}
