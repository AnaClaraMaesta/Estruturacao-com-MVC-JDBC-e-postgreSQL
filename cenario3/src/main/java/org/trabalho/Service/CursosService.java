package org.trabalho.Service;

import org.trabalho.Model.Cursos;
import org.trabalho.Model.Matricula;
import org.trabalho.Repository.Alunorepository;
import org.trabalho.Repository.Cursorepository;
import org.trabalho.Repository.Matricularepository;

import java.sql.SQLException;

public class CursosService {

    private Matricularepository matricularepository;
    private Cursorepository cursorepository;

    public CursosService(Matricularepository matricularepository, Cursorepository cursorepository) {
        this.matricularepository = matricularepository;
        this.cursorepository = cursorepository;
    }

    public void reduzirQuantidade(Cursos cursos) throws SQLException {
        cursos.reduzir(matricularepository.listarMatricula().size());
        cursorepository.atualizarQuantidade(cursos.getId(),
                cursos.getVagas_disponiveis()
        );
    }
}
