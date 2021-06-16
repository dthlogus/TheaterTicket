package br.com.senai.principal.util;

import java.util.Scanner;

public enum FaixaEtaria {
    LIVRE, DEZ, DOZE, QUATORZE, DEZESSEIS, DEZOITO;

    public static FaixaEtaria escolherFaixa(Scanner scan) {
        Integer opcao;
        System.out.println("Qual genero deseja escolher para a peça?");
        System.out.println("1. Livre - Não expõe crianças a conteúdos potencialmente prejudiciais");
        System.out.println("2. 10 Anos - Conteúdo violento ou linguagem inapropriada para crianças, ainda que em menor intensidade");
        System.out.println("3. 12 Anos - As cenas podem conter agressão física, consumo de drogas e insinuação sexual");
        System.out.println("4. 14 Anos - Conteúdos mais violentos e / ou de linguagem sexual mais acentuada");
        System.out.println("5. 16 Anos - Conteúdos mais violentos ou com conteúdo sexual mais intenso, com cenas de tortura, suicídio, estupro ou nudez total.");
        System.out.println("6. 18 Anos - Conteúdos violentos e sexuais extremos. Cenas de sexo, incesto ou atos repetidos de tortura, mutilação ou abuso sexual.");
        opcao = Integer.valueOf(scan.nextLine());

        switch (opcao) {
            case 1:
                return LIVRE;
            case 2:
                return DEZ;
            case 3:
                return DOZE;
            case 4:
                return QUATORZE;
            case 5:
                return DEZESSEIS;
            case 6:
                return DEZOITO;
            default:
                System.out.println("Você digitou uma opção errada, por favor, digite novamente.");
                return null;
        }
    }
}
