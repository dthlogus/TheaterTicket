package br.com.senai.principal.controle;

import br.com.senai.principal.Dao.ClienteDao;
import br.com.senai.principal.modelo.Cliente;

import java.util.Scanner;

public class ClienteControler {

    private Boolean continuar = true;
    private Integer opcao = 0;
    Scanner scan = new Scanner(System.in);

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

        scan.close();
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
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.salvar(cliente);
    }

    public void buscarPorCPF(Scanner scan){
        ClienteDao clienteDao = new ClienteDao();

        System.out.println("Digite o cpf que deseja buscar");
        String cpf = scan.nextLine();

        Cliente cliente = clienteDao.buscarPorCpf(cpf);
        System.out.printf("Nome do usuário %s \nCpf do usuário %s\n",cliente.getNome(), cliente.getCpf());
    }
}
