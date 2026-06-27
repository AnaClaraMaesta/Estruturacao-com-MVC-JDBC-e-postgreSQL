package Repository;

import Model.Cliente;
import Model.Veiculo;
import Util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class VeiculoRepository {
    public Veiculo salvar(Veiculo veiculo) throws SQLException {
        String sql = """
                INSERT INTO veiculo (placa, modelo, ano) 
                VALUES (?, ?, ?) RETURNING id
                """;
        try(Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setInt(3, veiculo.getAno());

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                long id_veiculo = rs.getLong("id");
                return new Veiculo(id_veiculo, veiculo.getPlaca(), veiculo.getModelo(), veiculo.getAno());
            }

            throw new SQLException("Erro ao salvar CLIENTE - > ID não gerado");
        }
    }

    public Veiculo atualizar(long id, String placa, String modelo, int ano) throws SQLException {
        String sql = """
                UPDATE veiculo
                SET placa = ?, modelo = ?, ano = ?
                WHERE id = ?;
        """;
        try(Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, placa);
            stmt.setString(2, modelo);
            stmt.setInt(3, ano);
            stmt.setLong(4, id);
            int rs = stmt.executeUpdate();

            return new Veiculo(id, placa, modelo, ano);
        }
    }

    public void excluir(long id) throws SQLException {
        String sql = """
                DELETE FROM veiculo
                WHERE id = ?;
        """;
        try(Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            int rs = stmt.executeUpdate();
        }
    }

    public Optional<Veiculo> buscarPorId(long id) throws SQLException {
        String sql = """
                SELECT * FROM veiculo
                WHERE id = ?;
        """;

        try(Connection conn = Conexao.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
        }
    }

    private Veiculo mapear(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String placa = rs.getString("placa");
        String modelo = rs.getString("modelo");
        int ano = rs.getInt("ano");

        return new Veiculo(id, placa,modelo, ano);
    }
}
