package Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Servico {
    private long id;
    private Veiculo veiculo;
    private Cliente cliente;
    private BigDecimal valor;
    private String descricao;
    private boolean isConcluida;

    public Servico(Veiculo veiculo, Cliente cliente, BigDecimal valor, String descricao, boolean isConcluida) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.valor = valor;
        this.descricao = descricao;
        this.isConcluida = false;

        List<String> erros = new ArrayList<>();
        if(valor.compareTo(BigDecimal.ZERO) <0 || valor == null) erros.add("Valor não pode ser menor que zero");
        if(cliente == null) erros.add("O cliente não está cadastrado");
        if(veiculo == null) erros.add("O veículo não está cadastrado");
    }

    public Servico(long id, Veiculo veiculo, Cliente cliente,
                   BigDecimal valor, String descricao, boolean isConcluida)
    {
        this(veiculo, cliente, valor, descricao, isConcluida);
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean _isConcluida() {
        return isConcluida;
    }
}