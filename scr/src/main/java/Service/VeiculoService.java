package Service;

import Model.Veiculo;
import Repository.VeiculoRepository;

import java.sql.SQLException;
import java.util.Optional;

public class VeiculoService {
    VeiculoRepository repo = new VeiculoRepository();

    public void Salvar(Veiculo veiculo) throws SQLException {
        repo.salvar(veiculo);
    }

    public Optional<Veiculo> buscarPorId(long id) throws SQLException {
        return repo.buscarPorId(id);
    }

    public Veiculo update(long id, String placa, String modelo, int ano) throws SQLException {
        return repo.atualizar(id, placa, modelo, ano);
    }

    public void delete(long id) throws SQLException {
        repo.excluir(id);
    }
}
