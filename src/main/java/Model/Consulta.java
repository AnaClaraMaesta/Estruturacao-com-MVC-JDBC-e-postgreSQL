package Model;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consulta
{
    private long idConsulta;
    private LocalDate dataConsulta;
    private Animal animal;
    private Tutor tutor;
    private BigDecimal valor;
    private TextArea descricao;

    public Consulta(LocalDate dataConsulta, Animal animal, Tutor tutor, BigDecimal valor, TextArea descricao)
    {
        List<String> erros = new ArrayList<>();
        if (dataConsulta == null) erros.add("Informe a data");
        if (animal == null) erros.add("o animal não está cadastrado");
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) erros.add("o valor não pode ser negativo");

        if (!erros.isEmpty()) {
            throw new IllegalArgumentException(String.join("\n", erros));
        }

        this.dataConsulta = dataConsulta;
        this.animal = animal;
        this.tutor = tutor;
        this.valor = valor;
        this.descricao = descricao;

    }

    public Animal getAnimal() {
        return animal;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TextArea getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Consulta => [" +
                "Data da consulta: "+ dataConsulta +
                "Animal: " + animal +
                "Tutor: " + tutor +
                "Valor: " + valor +
                "Descricao: " + descricao +
        "]";
    }
}
