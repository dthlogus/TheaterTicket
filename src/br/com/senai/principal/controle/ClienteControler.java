package br.com.senai.principal.controle;

import br.com.senai.principal.Dao.Banco;
import br.com.senai.principal.modelo.Cliente;
import br.com.senai.principal.util.Uteis;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ClienteControler {

    private Boolean continuar = true;
    private Integer opcao = 10000;
    private Scanner scan = new Scanner(System.in);

    public void iniciar() {
        while (continuar) {
            System.out.println("Digite em número, qual opcão você deseja");
            System.out.println("1. Salvar o Cliente");
            System.out.println("2. Buscar o Cliente pelo CPF");
            System.out.println("0. Sair");
            try {
                opcao = Integer.valueOf(scan.nextLine());
            }catch(Exception e){
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
        if (Uteis.validadorNomes(nome)){
            System.out.println("Nome fora do padrão, por favor, tente novamente.\n");
            cadastrarCliente(scan);
        }
        System.out.println("Digite o seu cpf (Digite apenas números, e use os padrões 00000000000 ou 000.000.000-00)");
        cpf = scan.nextLine();
        if (Uteis.validadorCpf(cpf)){
            System.out.println("cpf fora do padrão, por favor, tente novamente.\n");
            cadastrarCliente(scan);
        }
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        Banco banco = new Banco();
        banco.salvarCliente(cliente);
    }

    public void buscarPorCPF(Scanner scan) {
        Banco banco = new Banco();

        System.out.println("Digite o cpf que deseja buscar (Digite apenas números, e use os padrões 00000000000 ou 000.000.000-00)");
        String cpf = scan.nextLine();
        if (Uteis.validadorCpf(cpf)){
            System.out.println("cpf fora do padrão, por favor, tente novamente.\n");
            return;
        }
        Cliente cliente = banco.buscarClientePorCpf(cpf);
        if (cliente == null){
            System.out.println("Não foi encontrado um cliente com esse cpf.");
            return;
        }
        System.out.println(cliente);
    }


}
