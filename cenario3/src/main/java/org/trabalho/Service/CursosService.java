package org.trabalho.Service;

import org.trabalho.Model.Alunos;
import org.trabalho.Model.Cursos;
import org.trabalho.Model.Matricula;
import org.trabalho.Repository.Alunorepository;
import org.trabalho.Repository.Cursorepository;
import org.trabalho.Repository.Matricularepository;

import java.math.BigInteger;
import java.sql.SQLException;

public class CursosService {


    Cursorepository cursorepository = new Cursorepository();


    public Object cursoCadastrar(Cursos curso) throws SQLException {
        return cursorepository.cadastrar(curso);
    }

    public Object cursoConsultaTodos() throws SQLException {
        return cursorepository.listarCursos();

    }


    public  Object cursoConsultaNome(String nome) throws SQLException {
        return cursorepository.buscarPorNome(nome);
    }

    public void cursoAtualisar(Cursos curso) throws SQLException {
        cursorepository.atualizar(curso);
    }


    public void cursoDeletar(BigInteger id) throws SQLException {
        cursorepository.deletar(id);
    }



}
