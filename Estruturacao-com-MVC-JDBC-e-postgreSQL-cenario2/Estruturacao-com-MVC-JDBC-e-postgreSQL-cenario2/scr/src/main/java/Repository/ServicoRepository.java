package Repository;

import Model.Servico;
import Model.Veiculo;
import Model.Cliente;

import Util.Conexao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicoRepository {
    public Servico salvar(Servico servico) throws SQLException {
        String sql = """
                INSERT INTO servico (id_cliente, id_veiculo, valor, descricao, isConcluida) 
                VALUES (?, ?, ?, ?,?) RETURNING id
                """;
        try(Connection conn = Conexao.getConnection()){
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, servico.getCliente().getId());
            stmt.setLong(2, servico.getVeiculo().getId());
            stmt.setBigDecimal(3, servico.getValor());
            stmt.setString(4, servico.getDescricao());
            stmt.setBoolean(5, servico._isConcluida());

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                long id_servico = rs.getLong("id");
                return new Servico(id_servico, servico.getVeiculo(),servico.getCliente(), servico.getValor(), servico.getDescricao(), servico._isConcluida());
            }

            throw new SQLException("Erro ao salvar CLIENTE - > ID não gerado");
        }
    }

    public Servico atualizar(Servico servico) throws SQLException {
        String sql = """
                UPDATE servico
                SET 
                WHERE id = ?;
        """;
        try(Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, servico.getVeiculo().getId());
            stmt.setLong(2,  servico.getCliente().getId() );
            stmt.setBigDecimal(3, servico.getValor());
            stmt.setString(4, servico.getDescricao() );
            stmt.setBoolean(5, servico._isConcluida());
            stmt.setLong(6, servico.getId());

            int rs = stmt.executeUpdate();

            return new Servico(servico.getId(), servico.getVeiculo(), servico.getCliente(), servico.getValor(), servico.getDescricao(), servico._isConcluida());
        }
    }

    public void excluir(long id) throws SQLException {
        String sql = """
                DELETE FROM servico
                WHERE id = ?;
        """;
        try(Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            int rs = stmt.executeUpdate();
        }
    }

    public Optional<Servico> buscarPorIdCliente(long id) throws SQLException {
        String sql = """
                SELECT * FROM servico WHERE id_cliente = ?;
        """;
        try(Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
        }
    }

    public List<Servico> listarServicos()throws SQLException{
        String sql = "SELECT * FROM servico order by id";
        List<Servico> lista_servicos= new ArrayList<>();
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            while (rs.next()) lista_servicos.add(mapear(rs));
        }
        return lista_servicos;
    }



    private Servico mapear(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        long id_cliente = rs.getLong("id_cliente");
        long id_veiculo = rs.getLong("id_veiculo");
        BigDecimal valor = rs.getBigDecimal("valor");
        String descricao = rs.getString("descricao");
        boolean isConcluida = rs.getBoolean("is_concluida");

        Cliente cliente = new ClienteRepository().buscarPorId(id_cliente).orElse(null);
        Veiculo veiculo = new VeiculoRepository().buscarPorId(id_veiculo).orElse(null);

        return new Servico(id,veiculo, cliente, valor, descricao, isConcluida);
    }
}
