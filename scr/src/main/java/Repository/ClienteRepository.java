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
            ResultSet rs = stmt.executeQuery();
            rs.getLong("id");

        }
    }
}
