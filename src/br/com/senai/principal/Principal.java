package br.com.senai.principal;

import br.com.senai.principal.controle.ClienteControler;
import br.com.senai.principal.modelo.Cliente;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Boolean continuar = true;
        Integer opcao = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("*************************************");
        System.out.println("*   BEM VINDO AO TESTE DO CÓDIGO    *");
        System.out.println("*************************************");

        do {
            System.out.println("Digite em número, qual opcão você deseja");
            System.out.println("1. Cliente");
            System.out.println("0. Sair");
            opcao = Integer.valueOf(scan.nextLine());

            switch (opcao){
                case 1:
                    ClienteControler cc = new ClienteControler();
                    cc.iniciar();
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    continuar = true;
                    break;
            }

        }while(continuar);
        scan.close();
    }
}
