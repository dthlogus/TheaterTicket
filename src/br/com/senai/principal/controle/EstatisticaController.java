package br.com.senai.principal.controle;


import br.com.senai.principal.Banco.Banco;

import java.util.Scanner;


public class EstatisticaController {
    Scanner scan = new Scanner(System.in);
    Boolean continuar = true;
    int opcSelecionada;

    public void iniciar() {

        Banco banco = Banco.getInstance();

        while (continuar) {
            opcSelecionada = 10000;
            System.out.println("******** ESTATISTICAS ********");
            System.out.println("1. Peça com maior/menor ingressos vendidos");
            System.out.println("2. Sessão com mais/menos poltronas ocupadas");
            System.out.println("3. Peça/sessão mais/menos lucrativa");
            System.out.println("4. Lucro médio do teatro.");
            System.out.println("0. Voltar");
            try { // resolve o erro de parar o código ao digitar uma letra, o erro está sendo tratado no default.
                opcSelecionada = Integer.valueOf(scan.nextLine());
            }catch (Exception e){

            }
            switch (opcSelecionada) {

                case 0:
                    continuar = false;
                    break;

                case 1:
                    banco.estatisticasQntMaisVendidos();
                    break;
                case 2:
                    banco.estatisticaPoltronasOcupadas();
                    break;
                case 3:
                    banco.rentabilidadeDaAtracao();
                    break;
                case 4:
                    banco.totalArrecadado();
                    break;
                default:
                    System.out.println("Opção inválida");
                    continuar = true;
                    break;
            }
        }
    }
}
