package br.com.senai.principal.util;

import java.util.Scanner;

public enum Horario {

    MANHA, TARDE, NOITE;

    public static Horario escolherHorario(Scanner scan){
        Integer opcao;
        System.out.println("Qual horário deseja escolher para a peça?");
        System.out.println("1. Manhã");
        System.out.println("2. Tarde");
        System.out.println("3. Noite");
        opcao = Integer.valueOf(scan.nextLine());

        switch (opcao) {
            case 1:
                return MANHA;
            case 2:
                return TARDE;
            case 3:
                return NOITE;
            default:
                return null;
        }
    }
}
