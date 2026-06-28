package Service;

import Model.Cliente;
import Repository.ClienteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClienteService {
    ClienteRepository repo = new ClienteRepository();

    public Cliente Salvar(Cliente cliente) throws SQLException {
       return repo.salvar(cliente);
    }

    public Optional<Cliente> buscarPorId(long id) throws SQLException {
        return repo.buscarPorId(id);
    }

    public Cliente update(long id, String nome, String telefone) throws SQLException {
        return repo.atualizar(id, nome, telefone);
    }

    public void delete(long id) throws SQLException {
        repo.excluir(id);
    }

    public List<Cliente> listarTudo() throws SQLException {
        return repo.listarClientes();
    }

}
