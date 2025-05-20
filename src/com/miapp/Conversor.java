package com.miapp;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Conversor {

    // Se crea una sola vez para toda la clase
    private final HttpClient client = HttpClient.newHttpClient();

    public void convertirMoneda(String base, String target, double cantidad) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/ebf7f0ab2b4e3d4e6ce4e84c/latest/" + base;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String json = response.body();
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
                JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

                if (rates.has(target)) {
                    double tasa = rates.get(target).getAsDouble();
                    double resultado = cantidad * tasa;
                    System.out.printf("%.2f %s = %.2f %s%n", cantidad, base, resultado, target);
                } else {
                    System.out.println("Moneda destino no encontrada.");
                }
            } else {
                System.out.println("Error en la respuesta de la API: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error al conectarse a la API.");
            e.printStackTrace();
        }
    }

    public void mostrarMonedasFiltradas(String base) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/ebf7f0ab2b4e3d4e6ce4e84c/latest/" + base;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String json = response.body();
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
                JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

                String[] monedas = {"ARS", "BRL", "CLP", "COP", "USD"};
                System.out.println("Tasas de cambio desde " + base + ":");
                System.out.println("-------------------------------");

                for (String codigo : monedas) {
                    if (rates.has(codigo)) {
                        double tasa = rates.get(codigo).getAsDouble();
                        System.out.printf("%s: %.4f%n", codigo, tasa);
                    } else {
                        System.out.println("No se encontró la tasa para: " + codigo);
                    }
                }

            } else {
                System.out.println("Error en la respuesta de la API: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error al conectarse a la API.");
            e.printStackTrace();
        }
    }
}
