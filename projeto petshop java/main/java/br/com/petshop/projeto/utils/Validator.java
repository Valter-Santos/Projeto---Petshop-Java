package br.com.petshop.projeto.utils;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern CPF = Pattern.compile("\\d{11}");

    private static final Pattern PHONE = Pattern.compile("[0-9\\-\\s()+]{6,20}");

    public static boolean isNotEmpty(String s) {
        return s != null && !s.trim().isEmpty();
    }

    public static boolean isValidCpf(String cpf) {
        if (cpf == null) return false;
        String only = cpf.replaceAll("[^0-9]", "");
        if (!CPF.matcher(only).matches()) return false;
        return only.length() == 11;
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null) return false;
        return PHONE.matcher(phone).matches();
    }

    public static boolean isNonNegativeInt(int n) { return n >= 0; }
}
