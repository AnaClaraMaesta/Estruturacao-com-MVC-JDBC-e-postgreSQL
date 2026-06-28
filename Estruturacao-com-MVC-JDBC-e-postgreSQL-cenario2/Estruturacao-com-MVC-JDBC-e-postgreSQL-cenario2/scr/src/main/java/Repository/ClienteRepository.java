package Repository;

import Model.Cliente;
import Util.Conexao;

import java.sql.*;
import java.util.*;

public class ClienteRepository {
    public Cliente salvar(Cliente cliente) throws SQLException {
        String sql = """
                INSERT INTO cliente (nome, telefone) 
                VALUES (?, ?) RETURNING id
                """;
        try(Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                long id_cliente = rs.getLong("id");
                return new Cliente(id_cliente, cliente.getNome(), cliente.getTelefone());
            }

            throw new SQLException("Erro ao salvar CLIENTE - > ID não gerado");
        }
    }

    public Cliente atualizar(long id, String nome, String telefone) throws SQLException {
        String sql = """
                UPDATE cliente
                SET nome = ?, telefone = ?
                WHERE id = ?;
        """;
        try(Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setLong(3, id);
            int rs = stmt.executeUpdate();

            return new Cliente(id, nome, telefone);
        }
    }

    public void excluir(long id) throws SQLException {
        String sql = """
                DELETE FROM cliente
                WHERE id = ?;
        """;
        try(Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            int rs = stmt.executeUpdate();
        }
    }

    public Optional<Cliente> buscarPorId(long id) throws SQLException {
        String sql = """
                SELECT * FROM cliente
                WHERE id = ?;
        """;

        try(Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
        }
    }

    public List<Cliente> listarClientes()throws SQLException{
        String sql = "SELECT * FROM cliente order by id";
        List<Cliente> lista_clientes= new ArrayList<>();
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            while (rs.next()) lista_clientes.add(mapear(rs));
        }
        return lista_clientes;
    }


    private Cliente mapear(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String nome = rs.getString("nome");
        String telefone = rs.getString("telefone");

        return new Cliente(id, nome,telefone);
    }
}
