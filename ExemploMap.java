package com.mycompany.exemplomap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExemploMap {

    public static void main(String[] args) {
        Map<String, List<String>> pessoasPorSexo = lerEPesquisarPorSexo();
        exibirPorSexo(pessoasPorSexo);
    }

    private static Map<String, List<String>> lerEPesquisarPorSexo() {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> map = new HashMap<>();
        map.put("M", new ArrayList<>());
        map.put("F", new ArrayList<>());

        System.out.print("Quantas pessoas deseja inserir? ");
        int quantidade = lerInteiro(sc);

        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Digite o nome da pessoa " + i + ": ");
            String nome = sc.nextLine().trim();

            String sexo;
            while (true) {
                System.out.print("Digite o sexo (M/F) da pessoa " + i + ": ");
                sexo = sc.nextLine().trim().toUpperCase();
                if (sexo.equals("M") || sexo.equals("F")) {
                    break;
                }
                System.out.println("Sexo inválido! Digite M ou F.");
            }

            map.get(sexo).add(nome);
        }

        return map;
    }

    private static void exibirPorSexo(Map<String, List<String>> map) {
        System.out.println("\nHomens:");
        map.get("M").forEach(System.out::println);

        System.out.println("\nMulheres:");
        map.get("F").forEach(System.out::println);
    }

    private static int lerInteiro(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número: ");
            }
        }
    }
}

