package com.aluracursos.principal;


import com.aluracursos.operaciones.ConvertidorMoneda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);
        String monedaAConvertir;
        String tipoDeMoneda;
        double cantidad;
        List<ConvertidorMoneda> currency =  new ArrayList<>();
        ConvertidorMoneda ConvertidorMoneda = new ConvertidorMoneda();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            System.out.println("******************************************************************");
            System.out.println("Ingrese las siglas del tipo de moneda:\n" +
                    "1. USD\n" + "2. COP\n" + "3. ARS\n"+ "4. DOP\n"+ "5. CAD\n"+"6. AUD\n"
                    + "Salir\n");
             tipoDeMoneda= read.next().toUpperCase();

            if  (tipoDeMoneda.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Ingrese la moneda a la que desea convertir (ej. USD, COP, ARS, DOP, CAD, AUD):");
            monedaAConvertir = read.next().toUpperCase();

            System.out.println("Ingrese el valor a convertir: ");
            cantidad = read.nextDouble();

            try {
                double convertedcantidad = ConvertidorMoneda.convertir(cantidad, tipoDeMoneda, monedaAConvertir);
                System.out.println(cantidad + " " + tipoDeMoneda + " son " + convertedcantidad + " " + monedaAConvertir);

            } catch (IOException | InterruptedException e) {
                System.out.println("Error al obtener la moneda de cambio.");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                read.nextLine();
            }
            System.out.println("------------------------------------------------------------");
            System.out.println("¿Desea realizar otra conversión? (si/no)");
            String continuar = read.next().toLowerCase();
            if (!continuar.equals("si")) {
                break;
            }
        }


        try {
            read.close();
            System.out.println(currency);
            FileWriter myDocument = new FileWriter("myDoc.json");
            myDocument.write(gson.toJson(currency));
            myDocument.close();
            System.out.println("Programa finalizado.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
