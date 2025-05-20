package com.miapp;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        System.out.println("----- Menú Conversor de Monedas -----");
        System.out.println("1 Dólar => Peso argentino");
        System.out.println("2 Peso argentino => Dólar");
        System.out.println("3 Dólar => Real brasileño");
        System.out.println("4 Real brasileño => Dólar");
        System.out.println("5 Dólar => Peso colombiano");
        System.out.println("6 Peso colombiano => Dólar");
        System.out.println("7 Dólar => Sol peruano");
        System.out.println("8 Sol peruano => Dólar");
        System.out.println("9 Salir");
        System.out.print("Elija una opción válida: ");
    }

    public int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next(); // limpiar el scanner
            System.out.print("Elija una opción válida: ");
        }
        return scanner.nextInt();
    }

    public double leerCantidad() {
        System.out.print("Ingrese la cantidad a convertir: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
            System.out.print("Ingrese la cantidad a convertir: ");
        }
        return scanner.nextDouble();
    }
}
