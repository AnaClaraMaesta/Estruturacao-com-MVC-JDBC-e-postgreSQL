package org.trabalho.Service;

import org.trabalho.Model.Alunos;
import org.trabalho.Model.Cursos;
import org.trabalho.Model.Matricula;
import org.trabalho.Repository.Alunorepository;
import org.trabalho.Repository.Cursorepository;
import org.trabalho.Repository.Matricularepository;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Objects;

public class Matriculaservice {


    private Matricula matricula;

    Matricularepository matricularepository = new Matricularepository();


    public Object alunosCadastrar(Matricula matricula) throws SQLException {
        return matricularepository.cadastrar(matricula);
    }

    public Object alunosConsultaTodos() throws SQLException {
        return matricularepository.listarMatricula();

    }


    public  Object matriculaConsultaAluno(Long id) throws SQLException {
        return matricularepository.buscarPorAluno(id);
    }

    public  Object matriculaConsultaCurso(Long id) throws SQLException {
        return matricularepository.buscarPorCurso(id);
    }

    public void matriculaAtualisar(Matricula matricula) throws SQLException {
        matricularepository.atualizar(matricula);
    }


    public void matriculaDeletar(BigInteger id) throws SQLException {
        matricularepository.deletar(id);
    }

}
