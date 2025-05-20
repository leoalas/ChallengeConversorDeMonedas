package com.miapp;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        Conversor conversor = new Conversor();

        while (true) {
            menu.mostrarMenu();
            int opcion = menu.leerOpcion();

            if (opcion == 9) {
                System.out.println("Saliendo del programa...");
                break;
            }

            String base = "";
            String target = "";

            switch (opcion) {
                case 1 -> { base = "USD"; target = "ARS"; }
                case 2 -> { base = "ARS"; target = "USD"; }
                case 3 -> { base = "USD"; target = "BRL"; }
                case 4 -> { base = "BRL"; target = "USD"; }
                case 5 -> { base = "USD"; target = "COP"; }
                case 6 -> { base = "COP"; target = "USD"; }
                case 7 -> { base = "USD"; target = "PEN"; }
                case 8 -> { base = "PEN"; target = "USD"; }
                default -> {
                    System.out.println("Opción inválida. Intente de nuevo.");
                    continue;
                }
            }

            double cantidad = menu.leerCantidad();
            conversor.convertirMoneda(base, target, cantidad);
        }

        scanner.close();
    }
}
