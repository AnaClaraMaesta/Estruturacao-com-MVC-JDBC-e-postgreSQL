package org.trabalho.Controller;

import org.trabalho.Model.Cursos;
import org.trabalho.Model.Matricula;
import org.trabalho.Repository.Cursorepository;
import org.trabalho.Repository.Matricularepository;
import org.trabalho.Service.CursosService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;

public class MatriculaController {

    CursosService cursosService;
    Matricularepository matricularepository = new Matricularepository();
    private Matricula matricula;

    public void matriculaCadastrar(Long id_aluno, String nome_aluno, Long id_curso, String nome_curso, BigDecimal valor) throws SQLException {
        matricula = new Matricula( null, id_aluno, nome_aluno, id_curso, nome_curso, null,  valor);
        matricularepository.cadastrar(matricula);
        System.out.println("\n");
    }

    public void matriculaConsultaTodos() throws SQLException {
        System.out.println(matricularepository.listarMatricula() + "\n");
    }


    public void matriculaConsultaCursosid(Long id) throws SQLException {
        System.out.println(matricularepository.buscarPorCurso(id) + "\n");
    }

    public void matriculaConsultaAlunosid(Long id) throws SQLException {
        System.out.println(matricularepository.buscarPorAluno(id) + "\n");
    }


    public void matriculaAtualisar(BigDecimal valor, Long id) throws SQLException {
        matricula = new Matricula(id, null, null, null, null, null, valor);
        matricularepository.atualizar(matricula);
    }


    public void matriculaDeletar(BigInteger id) throws SQLException {
        matricularepository.deletar(id);
        System.out.println("ID deletado\n");
    }


}
