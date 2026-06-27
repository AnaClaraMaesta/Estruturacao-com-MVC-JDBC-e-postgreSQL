package Service;

import Model.Servico;
import Repository.ServicoRepository;

import java.sql.SQLException;

public class ServicoService {
    ServicoRepository repo = new ServicoRepository();

    public  void Salvar(Servico servico) throws SQLException
    {
        repo.salvar(servico);
    }

    public void update(Servico servico) throws SQLException
    {
        repo.atualizar(servico);
    }

    public Servico buscarPorIdCliente(long id) throws SQLException{
        return repo.buscarPorIdCliente(id).orElse(null);
    }

    public void delete(long id) throws SQLException{
        repo.excluir(id);
    }
}
