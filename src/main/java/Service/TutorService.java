package Service;

import Model.Tutor;
import Repository.TutorRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TutorService {
    private TutorRepository repo = new TutorRepository();

    public Tutor cadastrar(Tutor tutor) throws SQLException {
        return repo.salvar(tutor);
    }

    public Optional<Tutor> buscarPorId(long id) throws SQLException {
        return repo.buscarPorId(id);
    }

    public List<Tutor> listarTudo() throws SQLException {
        return repo.listarTodos();
    }

    public void deletar(long id_consulta) throws SQLException {
        repo.deletar(id_consulta);
    }

    public void update(Tutor tutor) throws SQLException {
        repo.atualizar(tutor);
    }

}
