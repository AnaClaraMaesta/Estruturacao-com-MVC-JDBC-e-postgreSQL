package org.trabalho.Model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class Matricula {

    private Long id;
    private Long id_aluno;
    private Long id_curso;
    private String nome_aluno;
    private String nome_curso;
    private Timestamp data_matricula;
    private BigDecimal valor;

    public Matricula( Long id, Long id_aluno,String nome_aluno, Long id_curso, String nome_curso,  Timestamp data_matricula, BigDecimal valor  ){
        if (id_aluno == null || id_aluno.intValue() <= 0){
            System.out.println("O aluno não existe cadastre-o primeiro ");
        }
        if (id_curso == null || id_curso.intValue() <= 0){
            System.out.println("O curso não existe cadatre-o primeiro");
        }
        if (valor.compareTo(BigDecimal.ZERO) < 0  ){
            System.out.println("O valor da matricula não pode ser negativo ");
        }
        this.id = id;
        this.id_aluno = id_aluno;
        this.nome_aluno = nome_aluno;
        this.id_curso = id_curso;
        this.nome_curso = nome_curso;
        this.data_matricula = data_matricula;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public Long getId_aluno() {
        return id_aluno;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public Timestamp getData_matricula() {
        return data_matricula;
    }

    public BigDecimal getValor() {
        return valor;
    }


    public String getNome_aluno() {
        return nome_aluno;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    @Override
    public String toString() {
        return String.format("\nMatricula => [id=%d, id aluno='%d', nome aluno='%s', id curso='%d', nome curso='%s' data matricula='%s', valor='%f']",
                id, id_aluno, nome_aluno, id_curso, nome_curso, data_matricula, valor);
    }

}
