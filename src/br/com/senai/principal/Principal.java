package br.com.senai.principal;

import br.com.senai.principal.controle.AtracaoControler;
import br.com.senai.principal.controle.ClienteControler;
import br.com.senai.principal.controle.CompraControler;
import br.com.senai.principal.controle.EstatisticaController;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Boolean continuar = true;
        Integer opcao = 10000;
        Scanner scan = new Scanner(System.in);

        System.out.println("*************************************");
        System.out.println("*    BEM VINDO AO THEATER TICKET    *");
        System.out.println("*************************************");

        do {

            System.out.println("Digite em número, qual opcão você deseja");
            System.out.println("1. Cliente");
            System.out.println("2. Atração");
            System.out.println("3. Compra");//adcionando a opção de compra
            System.out.println("5. Estatisticas");
            System.out.println("0. Sair");
            try {
                opcao = Integer.valueOf(scan.nextLine());
            } catch (Exception e) {
            }

            switch (opcao) {
                case 1:
                    ClienteControler cc = new ClienteControler();
                    cc.iniciar();
                    break;
                case 2:
                    AtracaoControler ac = new AtracaoControler();
                    ac.iniciar();
                    break;
                case 3:
                    CompraControler coc = new CompraControler();
                    coc.iniciar();
                    break;
                case 5:
                    EstatisticaController estat = new EstatisticaController();
                    estat.iniciar();
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Foi digitado algum número que não esteja no menu, letra ou palavra, por favor, digite novamente.\n");
                    continuar = true;
                    break;

            }

        } while (continuar);
        scan.close();
    }
}
