package org.trabalho.Model;

import java.math.BigInteger;

public class Cursos {
    private Long id;
    private String nome;
    private String descricao;
    private long carga_horaria;
    private int vagas_totais;
    private int vagas_disponiveis;

    public Cursos (Long id, String nome, String descricao, long carga_horaria, int vagas_totais, int vagas_disponiveis){
        if (nome == null || nome.isBlank()){
            throw new RuntimeException("O curso precisa ter um nome");
        }
        if (descricao == null || descricao.isBlank()){
            throw new RuntimeException("O curso precisa ter uma descrição");
        }
        if (carga_horaria <= 0){
            throw new RuntimeException("O curso precisa de uma carga horaria valida");
        }
        if (vagas_totais <= 0){
            throw new RuntimeException("Informe um valor valido de vagas");
        }
        if (vagas_disponiveis < 0){
            throw new RuntimeException("Informe um valor valido de vagas disponiveis");
        }
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.carga_horaria = carga_horaria;
        this.vagas_totais = vagas_totais;
        this.vagas_disponiveis = vagas_disponiveis;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public long getCarga_horaria() {
        return carga_horaria;
    }

    public int getVagas_totais() {
        return vagas_totais;
    }

    public int getVagas_disponiveis() {
        return vagas_disponiveis;
    }

    public boolean temDisponivel(int quantidade) {
        return vagas_disponiveis >= quantidade;
    }

    public void reduzir(int quantidade) {
        if (!temDisponivel(quantidade)) {
            throw new IllegalArgumentException("vagas insuficiente");
        }
        vagas_disponiveis -= quantidade ;
    }


    @Override
    public String toString() {
        return String.format("\nCurso => [id=%d, nome='%s', descrição='%s', carga horaria='%d', total de vagas:%d, vagas disponiveis:%d]",
                id, nome, descricao, carga_horaria, vagas_totais, vagas_disponiveis);
    }

}
