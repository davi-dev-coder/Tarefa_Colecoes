
package com.mycompany.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafios {

    public static void main(String[] args) {
        List<String> nomes = lerNomes();
        nomes.sort(String::compareToIgnoreCase); 
        exibirNomes(nomes);
    }

    private static List<String> lerNomes() {
        Scanner scanner = new Scanner(System.in);
        List<String> nomes = new ArrayList<>();

        System.out.print("Quantos nomes deseja inserir? ");
        int quantidade = lerInteiro(scanner);

        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Digite o nome " + i + ": ");
            nomes.add(scanner.nextLine().trim());
        }

        return nomes;
    }

    private static void exibirNomes(List<String> nomes) {
        System.out.println("\nNomes ordenados:");
        nomes.forEach(System.out::println);
    }

    private static int lerInteiro(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número: ");
            }
        }
    }
}
