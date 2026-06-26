package org.trabalho.Controller;

import org.trabalho.Model.Alunos;
import org.trabalho.Repository.Alunorepository;
import org.trabalho.Repository.Cursorepository;
import org.trabalho.Repository.Matricularepository;

import java.math.BigInteger;
import java.sql.SQLException;

public class AlunosController {

    Alunorepository alunorepository = new Alunorepository();
    private Alunos alunos;

    public void alunosCadastrar(String nome, String email, String telefone) throws SQLException {
        alunos = new Alunos( null, nome, email, telefone);
        alunorepository.cadastrar(alunos);
        System.out.println("\n");
    }

    public void alunosConsultaTodos() throws SQLException {
        System.out.println(alunorepository.listarAlunos() + "\n");
    }


    public void alunosConsultaNome(String nome) throws SQLException {
        System.out.println(alunorepository.buscarPorNome(nome) + "\n");
    }

    public void alunosAtualisar(String nome, String email, String telefone, Long id) throws SQLException {
        alunos = new Alunos(id, nome, email, telefone);
        alunorepository.atualizar(alunos);
    }


    public void alunosDeletar(BigInteger id) throws SQLException {
        alunorepository.deletar(id);
        System.out.println("ID deletado\n");
    }

}
