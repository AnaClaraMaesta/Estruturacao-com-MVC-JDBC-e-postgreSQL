package org.trabalho.Controller;
import org.trabalho.Model.Alunos;
import org.trabalho.Service.Alunosservice;
import java.math.BigInteger;
import java.sql.SQLException;

public class AlunosController {

    Alunosservice alunosservice = new Alunosservice();

    public void alunosCadastrar(String nome, String email, String telefone) throws SQLException {
       Alunos aluno = new Alunos(null, nome, email, telefone);
        alunosservice.alunosCadastrar(aluno);
        System.out.println("Aluno cadastrado\n");
    }

    public void alunosConsultaTodos() throws SQLException {
        System.out.println(alunosservice.alunosConsultaTodos());
    }
    public void alunosConsultaNome(String nome) throws SQLException {
        System.out.println(alunosservice.alunosConsultaNome(nome));

    }

    public void alunosAtualisar(String nome, String email, String telefone, Long id) throws SQLException {
        Alunos aluno = new Alunos(id, nome, email, telefone);
        alunosservice.alunosAtualisar(aluno);
        System.out.println("Atualizado\n");
    }


    public void alunosDeletar(BigInteger id) throws SQLException {
        alunosservice.alunosDeletar(id);
        System.out.println("ID deletado\n");
    }

}
