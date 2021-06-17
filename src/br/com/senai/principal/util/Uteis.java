package br.com.senai.principal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uteis {

    public static Boolean validadorNomes(String nome){
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nome);
        if (matcher.matches()){
            return false;
        }else{
            return true;
        }
    }

    public static Boolean validadorCpf(String cpf){
        String regx = "([0-9]{11})|([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(cpf);
        if (matcher.matches()){
            return false;
        }else{
            return true;
        }
    }

    public static Boolean validarEnum(Object objeto){
        if (objeto == null){
            System.out.println("Por favor, escolha dentro das opções existente.");
            return false;
        }else{
            return true;
        }
    }

    public static Boolean validarId(Object objeto){
        if (objeto == null){
            System.out.println("Não existe esse ID, por favor, tente novamente.");
            return false;
        }else{
            return true;
        }
    }
}
