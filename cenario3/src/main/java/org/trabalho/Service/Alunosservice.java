package org.trabalho.Service;

import org.trabalho.Model.Alunos;
import org.trabalho.Repository.Alunorepository;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Alunosservice {

    private Alunos aluno;

    Alunorepository alunosrepository = new Alunorepository();


    public Object alunosCadastrar(Alunos aluno) throws SQLException {
        return alunosrepository.cadastrar(aluno);
    }

    public Object alunosConsultaTodos() throws SQLException {
       return alunosrepository.listarAlunos();

    }


    public  Object alunosConsultaNome(String nome) throws SQLException {
        return alunosrepository.buscarPorNome(nome);
    }

    public void alunosAtualisar(Alunos aluno) throws SQLException {
        alunosrepository.atualizar(aluno);
    }


    public void alunosDeletar(BigInteger id) throws SQLException {
        alunosrepository.deletar(id);
    }

}
