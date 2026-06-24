package Model;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consulta
{
    private long id;
    private LocalDate dataConsulta;
    private Animal animal;
    private Tutor tutor;
    private BigDecimal valor;
    private String descricao;
    //antes de salvar
    public Consulta(LocalDate dataConsulta, Animal animal, Tutor tutor, BigDecimal valor, String descricao)
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

    //depois de salvar
    public Consulta(long id, LocalDate dataConsulta, Animal animal, Tutor tutor, BigDecimal valor, String descricao) {
        this(dataConsulta, animal, tutor, valor, descricao);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Consulta => [data: %s, animal: %s, tutor: %s, valor: %s, descricao: %s]"
                .formatted(dataConsulta, animal, tutor, valor, descricao);
    }
}
