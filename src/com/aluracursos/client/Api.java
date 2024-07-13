package com.aluracursos.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Api {
    //Variables finales como lo es la ai key y el inicio de la direccion
    private static final String API_KEY = "f38f6047ab3c6e6dabc75478";
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/";

    public static Map<String, Double> getApi(String tipoMoneda) throws IOException, InterruptedException {
        String url = URL_BASE + API_KEY + "/latest/" + tipoMoneda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");

        Map<String, Double> tipoDeCambio = new HashMap<>();
        for (String key : rates.keySet()){
            tipoDeCambio.put(key,rates.get(key).getAsDouble());

        }
        return tipoDeCambio;
    }
}
