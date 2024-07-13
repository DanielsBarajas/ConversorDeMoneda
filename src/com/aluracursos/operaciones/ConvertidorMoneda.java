package com.aluracursos.operaciones;

import com.aluracursos.client.Api;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.Map;

public class ConvertidorMoneda {

    @SerializedName("base_code")
    private String base_code;
    @SerializedName("conversion_rates")
    private String conversion_rates;
    private String monedaAConvertir = "";
    private String  TipoMoneda = "";
    private String direccion = "";

    public double convertir(double amount, String tipoMoneda, String monedaAConvertir)throws IOException, InterruptedException {
        Map<String, Double> exchangeRates = Api.getApi(tipoMoneda);
        double conversionRate = exchangeRates.get(monedaAConvertir);
        return amount * conversionRate;
    }
    public String getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(String conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getMonedaAConvertir() {
        return monedaAConvertir;
    }

    public void setMonedaAConvertir(String monedaAConvertir) {
        this.monedaAConvertir = monedaAConvertir;
    }

    public String getTipoMoneda() {
        return TipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        TipoMoneda = tipoMoneda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "ConvertidorMoneda{" +
                "base_code='" + base_code + '\'' +
                ", conversion_rates='" + conversion_rates + '\'' +
                '}';
    }
}
