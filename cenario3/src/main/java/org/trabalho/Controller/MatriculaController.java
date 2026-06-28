package org.trabalho.Controller;

import org.trabalho.Model.Matricula;
import org.trabalho.Repository.Matricularepository;
import org.trabalho.Service.CursosService;
import org.trabalho.Service.Matriculaservice;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;

public class MatriculaController {

    Matriculaservice matriculaservice = new Matriculaservice();
    private Matricula matricula;

    public void matriculaCadastrar(Long id_aluno, String nome_aluno, Long id_curso, String nome_curso, BigDecimal valor) throws SQLException {
        matricula = new Matricula( null, id_aluno, nome_aluno, id_curso, nome_curso, null,  valor);
        matriculaservice.alunosCadastrar(matricula);
        System.out.println("Matricula efetuada\n");
    }

    public void matriculaConsultaTodos() throws SQLException {
        System.out.println(matriculaservice.alunosConsultaTodos() + "\n");
    }


    public void matriculaConsultaCursosid(Long id) throws SQLException {
        System.out.println(matriculaservice.matriculaConsultaCurso(id)+ "\n");
    }

    public void matriculaConsultaAlunosid(Long id) throws SQLException {
        System.out.println(matriculaservice.matriculaConsultaAluno(id) + "\n");
    }


    public void matriculaAtualisar(BigDecimal valor, Long id) throws SQLException {
        matricula = new Matricula(id, null, null, null, null, null, valor);
       matriculaservice.matriculaAtualisar(matricula);
    }


    public void matriculaDeletar(BigInteger id) throws SQLException {
        matriculaservice.matriculaDeletar(id);
        System.out.println("ID deletado\n");
    }


}
