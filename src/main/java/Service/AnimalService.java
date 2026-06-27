package Service;

import Model.Animal;
import Repository.AnimalRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AnimalService {
    private AnimalRepository repo = new AnimalRepository();

    public Animal cadastrar(Animal animal) throws SQLException {
        return repo.salvar(animal);
    }

    public Optional<Animal> buscarPorId(long id) throws SQLException {
        return repo.buscarPorId(id);
    }

    public List<Animal> listarPorTutor(long id_tutor) throws SQLException {
        return repo.listarPorTutor(id_tutor);
    }

    public List<Animal> listarTudo() throws SQLException {
        return repo.listarTodos();
    }

    public void deletar(long id_animal) throws SQLException {
        repo.deletar(id_animal);
    }


}
