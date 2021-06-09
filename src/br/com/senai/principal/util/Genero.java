package br.com.senai.principal.util;

import java.util.Scanner;

public enum Genero {
    ACAO, TERROR, SUSPENSE, COMEDIA, DRAMA, FARSA, MIMICA, MELODRAMA, OPERA, CIRCO, MUSICAL, SURREALISMO, TRAGEDIA, TRAGICOMEDIA, FANTOCHE, SOMBRAS;

    public static Genero escolherGerenero(Scanner scan){
        Integer opcao;
        System.out.println("Qual genero deseja escolher para a peça?");
        System.out.println("1. Acao");
        System.out.println("2. Terror");
        System.out.println("3. Suspense");
        System.out.println("4. Comédia");
        System.out.println("5. Drama");
        System.out.println("6. Farsa");
        System.out.println("7. Mímica");
        System.out.println("8. Melodrama");
        System.out.println("9. Ópera");
        System.out.println("10. Circo");
        System.out.println("11. Musical");
        System.out.println("12. Surrealismo");
        System.out.println("13. Tragédia");
        System.out.println("14. Tragecomédia");
        System.out.println("15. Fantoche");
        System.out.println("16. Sombras");
        opcao = Integer.valueOf(scan.nextLine());

        switch (opcao) {
            case 1:
                return ACAO;
            case 2:
                return TERROR;
            case 3:
                return SUSPENSE;
            case 4:
                return COMEDIA;
            case 5:
                return DRAMA;
            case 6:
                return FARSA;
            case 7:
                return MIMICA;
            case 8:
                return MELODRAMA;
            case 9:
                return OPERA;
            case 10:
                return CIRCO;
            case 11:
                return MUSICAL;
            case 12:
                return SURREALISMO;
            case 13:
                return TRAGEDIA;
            case 14:
                return TRAGICOMEDIA;
            case 15:
                return FANTOCHE;
            case 16:
                return SOMBRAS;
            default:
                return null;
        }
    }
}
