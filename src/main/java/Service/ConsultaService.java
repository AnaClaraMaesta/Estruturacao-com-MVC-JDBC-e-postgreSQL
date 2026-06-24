package Service;

import Model.Animal;
import Model.Consulta;
import Repository.ConsultaRepository;

import java.sql.SQLException;
import java.util.List;

public class ConsultaService {
    private ConsultaRepository repo = new ConsultaRepository();

    public List<Consulta> listarPorAnimal(long id) throws SQLException {
        return repo.listarPorAnimal(id);
    }

    public Consulta finalizar(Consulta consulta) throws SQLException {
        return repo.salvar(consulta);
    }
}
