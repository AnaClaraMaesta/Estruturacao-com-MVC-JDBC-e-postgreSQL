package org.trabalho.Service;

import org.trabalho.Model.Cursos;
import org.trabalho.Model.Matricula;
import org.trabalho.Repository.Alunorepository;
import org.trabalho.Repository.Cursorepository;

import java.util.Objects;

public class Matriculaservice {

    private Cursorepository cursorepository;
    private Alunorepository alunorepository;

    public Matriculaservice (Cursorepository cursorepository, Alunorepository alunorepository){

        this.alunorepository = alunorepository;
        this.cursorepository = cursorepository;
    }

    public void validarVagas(Matricula matricula, Cursos cursos){
if (cursos.getVagas_disponiveis() <= 0 || matricula.getId().intValue() >= cursos.getVagas_totais()){
    throw new IllegalArgumentException("Não há mais disponibilidades de vagas para o curso: "
            + cursos.getNome());
}
    }

public void validarDuplicacao (Matricula matricula){
        if (Objects.equals(matricula.getId_aluno(), matricula.getId_curso())){
            throw new IllegalArgumentException("Aluno já matriculado nesse curso ");
        }

}

}
