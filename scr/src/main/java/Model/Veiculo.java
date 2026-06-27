package Model;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private long id;
    private String placa;
    private String modelo;
    private int ano;

    public Veiculo(String placa, String modelo, int ano) {
        List<String> erros = new ArrayList<>();
        if(placa == null || placa.isBlank()) erros.add("Informe a placa");
        if(modelo == null || modelo.isBlank()) erros.add("Informe o modelo do veículo");
        if(ano > 2026 || ano < 1886) erros.add("Informe um ano válido");

        //segundo o google 🤓☝️:
        //O primeiro automóvel com motor de combustão interna, considerado o carro moderno,
        // foi inventado pelo engenheiro alemão Karl Benz em 1885. Ele patenteou o veículo,
        // conhecido como Benz Patent-Motorwagen, em 29 de janeiro de 1886

        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
    }

    public Veiculo(long id, String placa, String modelo, int ano) {
        this(placa, modelo, ano);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }
}
