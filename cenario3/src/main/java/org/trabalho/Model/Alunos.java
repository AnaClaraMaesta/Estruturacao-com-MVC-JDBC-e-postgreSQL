package org.trabalho.Model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Alunos {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    public Alunos(Long id, String nome, String email, String telefone){
        if (nome == null || nome.isBlank()){
            throw new RuntimeException("O nome do aluno não pode ser vazio");

        }
        if (email == null || email.isBlank()){
            throw new RuntimeException("O email do aluno não pode ser vazio");

        }
        if (telefone == null || telefone.isBlank()){
            throw new RuntimeException("O telefone do aluno não pode ser vazio");

        }
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return String.format("\nAluno => [id=%d, nome='%s', email='%s', telefone='%s']",
               id, nome, email, telefone);
    }
}
