package br.com.senai.principal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uteis {

    public static boolean validadorNomes(String nome){
        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nome);
        if (matcher.matches()){
            return false;
        }else{
            return true;
        }
    }

    public static boolean validadorCpf(String cpf){
        String regx = "([0-9]{11})|([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(cpf);
        if (matcher.matches()){
            return false;
        }else{
            return true;
        }
    }
}
