package br.com.petshop.projeto.views;

import java.util.Scanner;

public class InputHelper {
    private final Scanner sc = new Scanner(System.in);

    public String readLine(String label) {
        System.out.print(label + ": ");
        return sc.nextLine();
    }

    public int readInt(String label) {
        while (true) {
            System.out.print(label + ": ");
            String s = sc.nextLine();
            try { return Integer.parseInt(s.trim()); }
            catch (NumberFormatException e) { System.out.println("Valor inválido. Digite um número inteiro."); }
        }
    }
}
