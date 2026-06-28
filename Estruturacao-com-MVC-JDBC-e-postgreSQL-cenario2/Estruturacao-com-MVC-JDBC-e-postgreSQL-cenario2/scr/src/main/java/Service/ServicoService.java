package Service;

import Model.Cliente;
import Model.Servico;
import Model.Veiculo;
import Repository.ServicoRepository;
import Util.Conexao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoService {
    ServicoRepository repo = new ServicoRepository();

    public Servico Salvar(Servico servico) throws SQLException
    {
       return repo.salvar(servico);
    }

    public Servico buscarPorIdCliente(long id) throws SQLException{
        return repo.buscarPorIdCliente(id).orElse(null);
    }

    public List<Servico> listarTodos() throws SQLException{
        return repo.listarServicos();
    }

    public void delete(long id) throws SQLException{
        repo.excluir(id);
    }

    public Servico update(Servico servico) throws SQLException {
        return repo.atualizar(servico);
    }

}
