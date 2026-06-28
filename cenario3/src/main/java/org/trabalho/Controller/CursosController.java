package org.trabalho.Controller;

import org.trabalho.Model.Alunos;
import org.trabalho.Model.Cursos;
import org.trabalho.Repository.Alunorepository;
import org.trabalho.Repository.Cursorepository;
import org.trabalho.Service.CursosService;

import java.math.BigInteger;
import java.sql.SQLException;

public class CursosController {

    CursosService cursosService = new CursosService();

    public void cursosCadastrar(String nome, String descricao, long carga_horaria, int vagas_totais, int vagas_disponiveis) throws SQLException {
        Cursos cursos = new Cursos( null, nome, descricao, carga_horaria, vagas_totais, vagas_disponiveis);
        cursosService.cursoCadastrar(cursos);
        System.out.println("\n");
    }

    public void cursosConsultaTodos() throws SQLException {
        System.out.println(cursosService.cursoConsultaTodos() + "\n");
    }


    public void cursosConsultaNome(String nome) throws SQLException {
        System.out.println(cursosService.cursoConsultaNome(nome) + "\n");
    }

    public void cursosAtualisar(String nome, String descricao, Long carga_horaria, int vagas_totais, int vagas_disponiveis, Long id) throws SQLException {
        Cursos cursos = new Cursos(id, nome, descricao, carga_horaria, vagas_totais, vagas_disponiveis);
        cursosService.cursoAtualisar(cursos);
        System.out.println("Atualizado\n");
    }


    public void cursosDeletar(BigInteger id) throws SQLException {
        cursosService.cursoDeletar(id);
        System.out.println("ID deletado\n");
    }

}
