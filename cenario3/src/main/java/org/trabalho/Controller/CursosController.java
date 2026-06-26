package org.trabalho.Controller;

import org.trabalho.Model.Alunos;
import org.trabalho.Model.Cursos;
import org.trabalho.Repository.Alunorepository;
import org.trabalho.Repository.Cursorepository;

import java.math.BigInteger;
import java.sql.SQLException;

public class CursosController {

    Cursorepository cursorepository = new Cursorepository();
    private Cursos cursos;

    public void cursosCadastrar(String nome, String descricao, long carga_horaria, int vagas_totais, int vagas_disponiveis) throws SQLException {
        cursos = new Cursos( null, nome, descricao, carga_horaria, vagas_totais, vagas_disponiveis);
        cursorepository.cadastrar(cursos);
        System.out.println("\n");
    }

    public void cursosConsultaTodos() throws SQLException {
        System.out.println(cursorepository.listarCursos() + "\n");
    }


    public void cursosConsultaNome(String nome) throws SQLException {
        System.out.println(cursorepository.buscarPorNome(nome) + "\n");
    }

    public void cursosAtualisar(String nome, String descricao, long carga_horaria, int vagas_totais, int vagas_disponiveis, Long id) throws SQLException {
        cursos = new Cursos(id, nome, descricao, carga_horaria, vagas_totais, vagas_disponiveis);
        cursorepository.atualizar(cursos);
    }


    public void cursosDeletar(BigInteger id) throws SQLException {
        cursorepository.deletar(id);
        System.out.println("ID deletado\n");
    }

}
